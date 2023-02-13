using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;
using TEA.Services;

namespace TEA.Dal.EFC
{
    public partial class ApplicationDbContext : IRepository
    {
        public T Create<T>(T entity)
        {
            base.Add(entity);
            SaveChanges();
            return entity;
        }

        public bool Delete<T>(T entity)
        {
            base.Remove(entity);
            return SaveChanges() > 0;
        }

        public T Get<T>(Expression<Func<T, bool>> condition, params string[] includes) where T : class
        {
            return GetEntity<T>(condition, false, includes);
        }

        public T GetEntity<T>(Expression<Func<T, bool>> condition, bool asNoTracking = false, params string[] includes) where T : class
        {
            var query = base.Set<T>().Where(condition);
            foreach (string include in includes)
            {
                query = query.Include(include);
            }
            if (asNoTracking)
            {
                query = query.AsNoTracking();
            }
            return query.FirstOrDefault();
        }

        public IEnumerable<T> List<T>(Expression<Func<T, bool>>? condition = null, params string[] includes) where T : class
        {
            return ListEntity<T>(condition, false, includes);
        }

        public IEnumerable<T> ListEntity<T>(Expression<Func<T, bool>>? condition = null, bool asNoTracking = false, params string[] includes) where T : class
        {
            var query = condition != null
                ? base.Set<T>().Where(condition)
                : base.Set<T>();

            foreach (string include in includes)
            {
                query = query.Include(include);
            }

            if (asNoTracking)
            {
                query = query.AsNoTracking();
            }

            return query.ToList();
        }

        bool IRepository.Update<T>(T entity)
        {
            base.Entry(entity).State = EntityState.Detached;
            base.Update(entity);
            return SaveChanges() > 0;
        }
    }
}
