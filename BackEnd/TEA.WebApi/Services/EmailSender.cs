using System.Net.Mail;
using System.Net;

namespace TEA.WebApi.Services
{
    public class EmailSender
    {
        private readonly IConfiguration Configuration;
        public EmailSender(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        public async Task SendEmailAsync(string email, string subject, string htmlMessage)
        {
            string fromMail = Configuration["SMTP:SenderEmail"];
            string fromPassword = Configuration["SMTP:Password"];

            MailMessage message = new MailMessage();
            message.From = new MailAddress(fromMail);
            message.Subject = subject;
            message.To.Add(new MailAddress(email));
            message.Body = "<html><body> " + htmlMessage + " </body></html>";
            message.IsBodyHtml = true;

            var smtpClient = new SmtpClient("smtp.office365.com")
            {
                Port = 587,
                Credentials = new NetworkCredential(fromMail, fromPassword),
                EnableSsl = true,

            };
            smtpClient.Send(message);
        }

    }
}
