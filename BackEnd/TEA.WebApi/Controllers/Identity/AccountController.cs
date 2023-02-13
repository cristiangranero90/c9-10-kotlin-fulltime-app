using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.WebUtilities;
using System.Text.Encodings.Web;
using System.Text;
using TEA.Models.DTOs.Account;
using TEA.Models.Entities;
using TEA.Services;
using TEA.WebApi.Services;

namespace TEA.WebApi.Controllers.Identity
{
    [Route("api/[controller]")]
    [ApiController]
    public class AccountController : ControllerBase
    {
        private readonly IRepository Repository;
        private readonly UserManager<IdentityUser> UserManager;
        private readonly RoleManager<IdentityRole> RoleManager;
        private readonly JwtService JwtService;
        private readonly EmailSender EmailSender;

        public AccountController(IRepository repository,
                                    UserManager<IdentityUser> usermanager,
                                    RoleManager<IdentityRole> rolemanager,
                                    JwtService jwtService,
                                    EmailSender emailSender)
        {
            Repository = repository;
            UserManager = usermanager;
            RoleManager = rolemanager;
            JwtService = jwtService;
            EmailSender = emailSender;
        }

        [HttpPost("Login")]
        public async Task<ActionResult<LoginResponseDTO>> Authentication([FromBody] LoginRequestDTO login)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest("Verifique usuario y password");
            }

            var user = await UserManager.FindByNameAsync(login.Email);
            if (user == null)
            {
                return NotFound();
            }
            var isPasswordValid = await UserManager.CheckPasswordAsync(user, login.Password);
            if (isPasswordValid)
            {
                var token = JwtService.CreateToken(user);
                var userData = Repository.Get<User>(x => x.AspUserId == user.Id);
                if (userData != null)
                {
                    token.imageUrl = userData.ImageUrl;
                    token.Id = userData.Id;
                    token.UserName = userData.UserName;
                    token.Name = userData.Name;
                    token.LastName = userData.LastName;
                }
                return Ok(token);
            }
            else
            {
                return BadRequest("La contraseña es incorrecta.");
            }
        }

        [HttpPost("Register")]
        public async Task<ActionResult> Register(UserRegisterDTO newUser)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest("Datos incorrectos");
            }
            IdentityUser user = new()
            {
                Email = newUser.Email,
                UserName = newUser.Email,

            };
            var checkUserName = Repository.Get<User>(x => x.UserName == newUser.UserName);
            if (checkUserName != null)
            {
                return BadRequest($"El usuario {newUser.UserName} no se encuentra disponible");
            }

            var result = await UserManager.CreateAsync(user, newUser.Password);
            if (result.Succeeded)
            {
                string msg;
                var registeredUser = await UserManager.FindByNameAsync(newUser.Email);
                User newUserData = new()
                {
                    Name = newUser.Name,
                    LastName = newUser.LastName,
                    UserName = newUser.UserName,
                    ImageUrl = newUser.ImageUrl,
                    BirthDate = newUser.BirthDate,
                    ProfileDescription = newUser.ProfileDescription,
                    Gender = newUser.Gender,
                    AspUserId = registeredUser.Id,
                    CreateDate = DateTime.Now
                };
                var response = Repository.Create(newUserData);
                if (response != null)
                {
                    try
                    {
                        string returnUrl = "https://localhost:7221/api/Account/ConfirmAccount";

                        var token = await UserManager.GenerateEmailConfirmationTokenAsync(user);
                        token = WebEncoders.Base64UrlEncode(Encoding.UTF8.GetBytes(token));

                        var callbackUrl =

                            $"{returnUrl}?email={registeredUser.Email}&token={token}";

                        string EmailMessage = $"Hola{response.Name}, bienvenido a TEA, confirma tu cuenta en el siguien enlace <a href='{HtmlEncoder.Default.Encode(callbackUrl)}'>Has clic aquí</a>.";
                        await EmailSender.SendEmailAsync(registeredUser.Email, "Confirma tu correo", EmailMessage);
                        msg = "Correo enviado exitosamente";
                    }
                    catch
                    {
                        msg = "No se pudo enviar el correo por motivos del servidor";
                    }
                    return Ok($"El usuario ha sido registrado\n{msg}");
                }
                else
                {
                    return BadRequest("Error al crear el perfil de usuario");
                }
            }
            else
            {
                var results = result.Errors.First();

                return BadRequest($"{results.Description}");
            }
        }

        [HttpGet("ConfirmAccount")]
        public async Task<ActionResult> ConfirmEmail(string email, string token)
        {
            string response;
            var user = await UserManager.FindByEmailAsync(email);
            if (user != null)
            {
                var data = Convert.FromBase64String(token);
                var DecodedToken = Encoding.UTF8.GetString(data);
                var confirm = await UserManager.ConfirmEmailAsync(user, DecodedToken);
                if (confirm.Succeeded)
                {
                    response = "correo validado";
                }
                else
                {
                    response = $"{confirm.Errors.First().Description}";
                }

            }
            else
            {
                response = "No se ha encontrado el usuario";
            }
            return base.Content($"<div>{response}</div>", "text/html");
        }
    }
}
