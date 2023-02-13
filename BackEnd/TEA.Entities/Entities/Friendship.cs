using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.DTOs.Friendships;
using TEA.Models.Logs;

namespace TEA.Models.Entities
{
    public class Friendship : Log
    {
        public int Id { get; set; }

        public DateTime UpdateDate { get; set; }

        public int SederUser { get; set; }

        public int RecipientUser { get; set; }

        public bool AceptedFriendship { get; set; }

        public int RelationshipType { get; set; }

        public static explicit operator Friendship(FriendshipDTO entity)
        {
            return new Friendship
            {
                Id = entity.Id,
                SederUser = entity.SederUser,
                RecipientUser = entity.RecipientUser,
                AceptedFriendship = entity.AceptedFriendship,
                RelationshipType = entity.RelationshipType,
            };
        }

    }
}
