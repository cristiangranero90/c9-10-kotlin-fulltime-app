 using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using TEA.Models.DTOs.Posts;
using TEA.Models.Entities;
using TEA.Services;

namespace TEA.WebApi.Controllers.Posts
{
    [Route("api/[controller]")]
    [ApiController]
    [Authorize]
    public class ReactionController : ControllerBase
    {
        public readonly IRepository Repository;

        public ReactionController(IRepository repository)
        {
            Repository = repository;
        }

        [HttpPost]
        public ActionResult PostReaction(ReactionDTO reaction)
        {
            var Reaction = (Reaction)reaction;
            Reaction.CreateDate = DateTime.Now;
            var result = Repository.Create((Reaction)reaction);
            if (result == null)
            {
                return BadRequest("Hubo un problema inténtalo de nuevo.");
            }
            else
            {
                return Ok();
            }
        }

        [HttpGet("ComentReactions")]
        public ActionResult<List<ReactionDTO>> GetComentReaction(int comentId)
        {
            var result = Repository.List<Reaction>(x => x.ComentId == comentId).OrderByDescending(x => x.CreateDate).Select(c => (ReactionDTO)c).ToList();
            if(result.Count > 0)
            {
                return result;
            }
            else
            {
                return NotFound();
            }
            
        }
    }
}
