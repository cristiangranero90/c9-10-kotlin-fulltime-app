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
    public class PostController : ControllerBase
    {
        public readonly IRepository Repository;


        public PostController(IRepository repository)
        {
            Repository = repository;
        }

        [HttpPost]
        public ActionResult<PostDTO> UserPost(PostDTO post)
        {
            if (post.Id > 0)
            {
                var result = Repository.Get<Post>(x => x.Id == post.Id);
                if (result != null)
                {
                    result.Title = post.Title;
                    result.Description = post.Description;
                    result.UpdateDate = DateTime.Now;
                    var response = Repository.Update(result);
                    if (response)
                    {
                        var res = (PostDTO)Repository.Get<Post>(x => x.Id == post.Id);
                        return res;
                    }
                    else
                    {
                        return BadRequest("Sucedió un error inesperado");
                    }

                }
                else
                {
                    return BadRequest("Sucedió un error inesperado");
                }
            }
            else
            {

                var createPost = (Post)post;
                createPost.CreateDate = DateTime.Now;
                createPost.UpdateDate = DateTime.Now;
                var response = Repository.Create(createPost);
                if (response != null)
                {
                    return Ok(response);

                }
                else
                {
                    return BadRequest("Sucedió un error inesperado");
                }
            }
        }

        [HttpGet]
        public ActionResult<List<PostDTO>> GetPosts(int Id)
        {
            if (Id > 0)
            {
                var posts = Repository.List<Post>(x => x.UserId == Id).ToList();
                List<Friendship> friendsId = Repository.List<Friendship>(x => (x.SederUser == Id || x.RecipientUser == Id) && x.AceptedFriendship).ToList();
                if (friendsId.Count > 0)
                {
                    foreach (var item in friendsId)
                    {
                        var friendsPosts = Repository.List<Post>(x => x.UserId == item.Id).ToList();
                        posts.AddRange(friendsPosts);
                    }
                }
                if (posts.Count > 0)
                {
                    var response = posts.OrderBy(x => x.CreateDate).Reverse().Take(15);
                    return Ok(response);
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
    }
}
