using System.Linq.Expressions;

namespace TEA.Services
{
    public interface IRepository
    {
        public T Create<T> (T entity);

        public bool Update<T> (T entity);

        public bool Delete<T> (T entity);

        public T Get<T> (Expression<Func<T, bool>> condition, params string[] includes) where T : class;

        public T GetEntity<T>(Expression<Func<T, bool>> condition, bool asNoTracking = false, params string[] includes) where T : class;
        
        public IEnumerable<T> List<T>(Expression<Func<T, bool>>? condition = null, params string[] includes) where T : class;
        
        public IEnumerable<T> ListEntity<T>(Expression<Func<T, bool>>? condition = null, bool asNoTracking = false, params string[] includes) where T : class;
    }
}