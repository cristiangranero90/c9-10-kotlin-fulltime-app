 using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using TEA.Models.DTOs.Friendships;
using TEA.Models.Entities;
using TEA.Services;

namespace TEA.WebApi.Controllers.Users
{
    [Route("api/[controller]")]
    [ApiController]
    [Authorize]
    public class FriendshipController : ControllerBase
    {
        private readonly IRepository Repository;

        public FriendshipController(IRepository repository)
        {
            Repository = repository;
        }

        [HttpPost("SendFriendshipRequest")]
        public ActionResult SendFriendshipRequest(FriendshipDTO friendship)
        {
            if (!ModelState.IsValid)
            {
                var result = Repository.Create((Friendship)friendship);
                if (result != null)
                {
                    return Ok();
                }
            }

            return BadRequest();
        }
        [HttpPost("ResponseFriendshipRequest")]
        public ActionResult ReciveFriendshipRequest(FriendshipDTO friendship)
        {
            if (!ModelState.IsValid)
            {

                var result = Repository.Get<Friendship>(x => x.Id == friendship.Id);
                if (result != null)
                {
                    result.AceptedFriendship = friendship.AceptedFriendship;
                    var response = Repository.Update(result);
                    return Ok(response);
                }
            }

            return BadRequest("Bad Request");
        }
    }
}
