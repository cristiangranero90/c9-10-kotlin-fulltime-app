using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.Logs;

namespace TEA.Models.Entities
{
    public class Reaction : Log
    {
        public int Id { get; set; }

        public DateTime UpdateDate { get; set; }

        public int UserId { get; set; }

        public User? User { get; set; }

        public int Type { get; set; }

        public int? PostId { get; set; }

        public Post? Post { get; set; }

        public int? ComentId { get; set; }

        public Coment? Coment { get; set; }
    }
}
