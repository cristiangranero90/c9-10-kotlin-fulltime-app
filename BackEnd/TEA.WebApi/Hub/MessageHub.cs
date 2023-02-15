using Microsoft.AspNetCore.SignalR;
using TEA.Models.Entities;

namespace TEA.WebApi.Hub
{
    public class MessageHub : Hub<IMessageHubClient>
    {
        public async Task SendPrivateMessage(Message message)
        {
            await Clients.User(message.RecipientUser).SendPrivateMessage(message.MessageContent);
        }
    }
    
}
