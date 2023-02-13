using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.Entities;

namespace TEA.Models.DTOs.Posts
{
    public class ReactionDTO
    {
        public int Id { get; set; }

        public int UserId { get; set; }

        public int Type { get; set; }

        public int? PostId { get; set; }

        public int? ComentId { get; set; }

        public static explicit operator ReactionDTO (Reaction entity)
        {
            return new ReactionDTO
            {
                Id = entity.Id,
                UserId = entity.UserId,
                Type = entity.Type,
                PostId = entity.PostId,
                ComentId = entity.ComentId,

            };
        }
    }
}
