using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using TEA.Models.Entities;
using TEA.Services;

namespace TEA.WebApi.Controllers.Posts
{
    [Route("api/[controller]")]
    [ApiController]
    [Authorize]
    public class ComentController : ControllerBase
    {
        private readonly IRepository Repository;
        public ComentController(IRepository repository)
        {
            Repository = repository;
        }

        [HttpGet]
        public ActionResult<List<Coment>> GetComentsByPostId(int postId)
        {
            if (postId > 0)
            {
                var result = Repository.List<Coment>(x => x.PostId == postId).ToList();
                if (result.Count > 0)
                {
                    return result;
                }
                else
                {
                    return NotFound();
                }
            }
            else
            {
                return BadRequest();
            }


        }

        [HttpPost]
        public ActionResult PostComent(Coment coment)
        {
            var result = Repository.Create(coment);
            if (result != null)
            {
                return Ok("Comentario creado");
            }
            else
            {
                return BadRequest();
            }
        }
        [HttpPost]
        public ActionResult<bool> DeleteComent(int Id)
        {
            if (!(Id > 0))
            {
                return BadRequest();
            }
            return Repository.Delete(Id);
        }
    }
}
