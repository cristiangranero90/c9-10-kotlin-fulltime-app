using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace TEA.Dal.EFC.Migrations
{
    /// <inheritdoc />
    public partial class UpdateFriendshipSchema : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "imageUrl",
                table: "User",
                newName: "ImageUrl");

            migrationBuilder.RenameColumn(
                name: "birthDate",
                table: "User",
                newName: "BirthDate");

            migrationBuilder.RenameColumn(
                name: "UpdateUser",
                table: "Friendship",
                newName: "SederUser");

            migrationBuilder.RenameColumn(
                name: "CreateUser",
                table: "Friendship",
                newName: "RecipientUser");

            migrationBuilder.AddColumn<bool>(
                name: "AceptedFriendship",
                table: "Friendship",
                type: "bit",
                nullable: false,
                defaultValue: false);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "AceptedFriendship",
                table: "Friendship");

            migrationBuilder.RenameColumn(
                name: "ImageUrl",
                table: "User",
                newName: "imageUrl");

            migrationBuilder.RenameColumn(
                name: "BirthDate",
                table: "User",
                newName: "birthDate");

            migrationBuilder.RenameColumn(
                name: "SederUser",
                table: "Friendship",
                newName: "UpdateUser");

            migrationBuilder.RenameColumn(
                name: "RecipientUser",
                table: "Friendship",
                newName: "CreateUser");
        }
    }
}
