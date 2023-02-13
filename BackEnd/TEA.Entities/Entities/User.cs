using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.Logs;

namespace TEA.Models.Entities
{
    public class User : Log
    {
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public string LastName { get; set; }

        [Required]
        public string UserName { get; set; }

        public string? ImageUrl { get; set; }

        [Required]
        public DateTime BirthDate { get; set; }

        public string? ProfileDescription { get; set; }

        public int? Gender { get; set; }

        [StringLength(450)]
        public string AspUserId { get; set; }
    }
}
