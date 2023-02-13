using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.DTOs.Posts;
using TEA.Models.Logs;

namespace TEA.Models.Entities 
{
    public class Post : Log
    {
        public int Id { get; set; }

        [Required]
        public string Title { get; set; }

        [Required]
        public string Description { get; set; }

        public int? Likes { get; set; }

        public int? Dislikes { get; set;}

        public int? Shared { get; set;}

        public DateTime UpdateDate { get; set; }

        public int Type { get; set; }

        public int UserId { get; set; }

        public User User { get; set; }

        public int? Coments { get; set; }

        public static explicit operator Post(PostDTO entity)
        {
            return new Post
            {
                Id = entity.Id,
                Title = entity.Title,
                Description = entity.Description,
                Likes = entity.Likes,
                Dislikes = entity.Dislikes,
                Shared = entity.Shared,
                Type = entity.Type,
                UserId = entity.UserId,
                Coments = entity.Coments,
            };
        }
    }
}
