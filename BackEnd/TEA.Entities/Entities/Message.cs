using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.Logs;

namespace TEA.Models.Entities
{
    public class Message : Log
    {
        public int Id { get; set; }

        [Required]
        public string MessageContent { get; set; }

        [Required]
        public string SenderUser { get; set; }

        public string RecipientUser { get; set; }
    }
}
