using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace TEA.Dal.EFC.Migrations
{
    /// <inheritdoc />
    public partial class UpdatePostSchema : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "Coments",
                table: "Post",
                type: "int",
                nullable: true);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Coments",
                table: "Post");
        }
    }
}
