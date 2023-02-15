using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Xml.Linq;
using TEA.Models.DTOs.Posts;
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
        public ActionResult PostComent(ComentDTO coment)
        {
            var comentCreated = (Coment)coment;
            comentCreated.CreateDate = DateTime.Now;
            var result = Repository.Create(comentCreated);
            if (result != null)
            {
                var postChanged = Repository.Get<Post>(x => x.Id == coment.PostId);
                postChanged.Coments++;
                Repository.Update(postChanged);
                return Ok("Comentario creado");
            }
            else
            {
                return BadRequest();
            }
        }
        [HttpPost("DeleteComent")]
        public ActionResult<bool> DeleteComent(int Id)
        {
            if (Id > 0)
            {
                var postId = Repository.Get<Coment>(x => x.Id == Id).PostId;
                var result = Repository.Delete(Id);
                if (result)
                {
                    var postChanged = Repository.Get<Post>(x => x.Id == postId);
                    postChanged.Coments--;
                    Repository.Update(postChanged);
                    return Ok("Comentario eliminado");
                }
            }
            
            return BadRequest();
        }
    }
}
