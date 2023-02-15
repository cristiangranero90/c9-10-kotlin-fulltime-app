using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.SignalR;
using TEA.Models.Entities;
using TEA.Services;
using TEA.WebApi.Hub;

namespace TEA.WebApi.Controllers.Users
{
    [Route("api/[controller]")]
    [ApiController]
    public class MessageController : ControllerBase
    {
        private IHubContext<MessageHub, IMessageHubClient> MessageHub;
        private readonly IRepository Repository;

        public MessageController(IHubContext<MessageHub, IMessageHubClient> messageHub, IRepository repository)
        {
            MessageHub = messageHub;
            Repository = repository;
        }


        [HttpPost("SendMessage")]
        public ActionResult SendMesagge(Message message)
        {
            message.CreateDate = DateTime.Now;
            var result = Repository.Create(message);
            if (result != null)
            {
                MessageHub.Clients.User(message.RecipientUser).SendPrivateMessage(message.MessageContent);
                return Ok();
            }
            else
            {
                return BadRequest();
            }

            
        }
    }
}
