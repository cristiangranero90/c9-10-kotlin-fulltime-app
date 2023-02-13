using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TEA.Models.DTOs.Account
{
    public class LoginResponseDTO
    {
        public string Token { get; set; }

        public int Id { get; set; }

        public string Name { get; set; }

        public string LastName { get; set; }

        public string UserName { get; set; }

        public string? imageUrl { get; set; }

    }
}
