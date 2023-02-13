using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.Entities;

namespace TEA.Models.DTOs.Posts
{
    public class PostDTO
    {
        public int Id { get; set; }

        public string Title { get; set; }

        public string Description { get; set; }

        public int? Likes { get; set; }

        public int? Dislikes { get; set; }

        public int? Shared { get; set; }

        public int Type { get; set; }

        public int UserId { get; set; }

        public int? Coments { get; set; }

        public static explicit operator PostDTO (Post entity)
        {
            return new PostDTO
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
