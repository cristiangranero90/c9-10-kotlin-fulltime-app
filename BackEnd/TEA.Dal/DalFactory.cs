using TEA.Dal.EFC;
using TEA.Services;

namespace TEA.Dal
{
    public class DalFactory
    {
        public static IRepository GetRepository(string type) =>
            type switch
            {
                "EFC" => new ApplicationDbContext(),
                _ => throw (new NullReferenceException(nameof(type)))
            };
    }
}