using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using TEA.Helpers;
using TEA.Models.Entities;

namespace TEA.Dal.EFC
{
    public partial class ApplicationDbContext : IdentityDbContext
    {

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(Configuration.GetConnectionString("TestConnection"));
        }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            base.OnModelCreating(builder);
        }

        #region tables 
        public DbSet<User> User { get; set; }   
        public DbSet<Post> Post { get; set; }   
        public DbSet<PostGallery> PostGallery { get; set; }   
        public DbSet<Coment> Coment { get; set; }   
        public DbSet<Reaction> Reaction { get; set; }   
        public DbSet<Message> Message { get; set; }   
        public DbSet<Friendship> Friendship { get; set; }   

        #endregion
    }
}