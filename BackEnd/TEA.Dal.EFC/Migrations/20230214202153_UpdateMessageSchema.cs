using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace TEA.Dal.EFC.Migrations
{
    /// <inheritdoc />
    public partial class UpdateMessageSchema : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "RecipientUserId",
                table: "Message");

            migrationBuilder.DropColumn(
                name: "SenderUserId",
                table: "Message");

            migrationBuilder.AddColumn<string>(
                name: "SignalUser",
                table: "User",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");

            migrationBuilder.AddColumn<string>(
                name: "RecipientUser",
                table: "Message",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");

            migrationBuilder.AddColumn<string>(
                name: "SenderUser",
                table: "Message",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "SignalUser",
                table: "User");

            migrationBuilder.DropColumn(
                name: "RecipientUser",
                table: "Message");

            migrationBuilder.DropColumn(
                name: "SenderUser",
                table: "Message");

            migrationBuilder.AddColumn<int>(
                name: "RecipientUserId",
                table: "Message",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.AddColumn<int>(
                name: "SenderUserId",
                table: "Message",
                type: "int",
                nullable: false,
                defaultValue: 0);
        }
    }
}
