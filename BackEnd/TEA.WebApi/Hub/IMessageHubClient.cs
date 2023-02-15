using TEA.Models.Entities;

namespace TEA.WebApi.Hub
{
    public interface IMessageHubClient
    {
        Task SendPrivateMessage(string message);
    }
}
