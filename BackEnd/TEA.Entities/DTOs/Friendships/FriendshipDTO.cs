using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.Entities;

namespace TEA.Models.DTOs.Friendships
{
    public class FriendshipDTO
    {
        public int Id { get; set; }

        public int SederUser { get; set; }

        public int RecipientUser { get; set; }

        public bool AceptedFriendship { get; set; }

        public int RelationshipType { get; set; }

        public static explicit operator FriendshipDTO(Friendship entity)
        {
            return new FriendshipDTO 
            { 
                Id = entity.Id, 
                SederUser= entity.SederUser,
                RecipientUser= entity.RecipientUser,
                AceptedFriendship= entity.AceptedFriendship,
                RelationshipType= entity.RelationshipType,
            };
        }
    }
    
}
