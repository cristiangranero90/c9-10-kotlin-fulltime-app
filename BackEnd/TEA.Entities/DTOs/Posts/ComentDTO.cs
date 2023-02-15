using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.Entities;

namespace TEA.Models.DTOs.Posts
{
    public class ComentDTO
    {
        public int Id { get; set; }

        public string Message { get; set; }

        public int PostId { get; set; }

        public int UserId { get; set; }

        public string? UserName { get; set; }

        public int? Likes { get; set; }

        public int? Dislikes { get; set; }

        public static explicit operator ComentDTO(Coment entity)
        {
            return new ComentDTO
            {
                Id = entity.Id,
                Message = entity.Message,
                PostId = entity.PostId,
                UserId = entity.UserId,
                UserName = entity.User?.UserName,
                Likes= entity.Likes,
                Dislikes= entity.Dislikes,

            };
        }
    }
}
