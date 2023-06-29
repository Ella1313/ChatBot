
import org.junit.jupiter.api.*;
import java.sql.*;

    public class ChatBotDatabaseTest {

        private static String url = "jdbc:sqlite:chatbot.db";

     // This code has be run everytime to drop the Table.
        @BeforeEach
        public void clearData() throws SQLException {
            try (Connection connection = DriverManager.getConnection(url)) {
                String clearUsersTable = "DROP TABLE IF EXISTS users";
                String clearCommandsTable = "DROP TABLE IF EXISTS commands";
                String clearChatHistoryTable = "DROP TABLE IF EXISTS chatHistory";

                executeStatement(connection, clearUsersTable);
                executeStatement(connection, clearCommandsTable);
                executeStatement(connection, clearChatHistoryTable);
            }
        }

        @Test
        public void testCreateUsersTable() throws SQLException {
               Connection con = DriverManager.getConnection(url);
               //Create Users Table
                String createUsersTable = "Create Table users (id INTEGER PRIMARY KEY, name TEXT, email TEXT)";
                executeStatement(con, createUsersTable);

                //Insert a user into the Users Table
                equals("John");
                equals("john@example.com");

        }
        @Test
        public void testCreateCommandsTable() throws SQLException {
                Connection con = DriverManager.getConnection(url);
                //Create Commands table
                String createCommandsTable = "Create table Commands (id INTEGER, command TEXT)";
                executeStatement(con, createCommandsTable);

                //Insert command into the Commands table
                equals(1);
                equals("Hello");
        }
        @Test
        public void testCreateChatHistoryTable() throws SQLException {
            try (Connection con = DriverManager.getConnection(url)) {
                //Create Chat History table
                String createChatHistoryTable = "Create table chatHistory (id INTEGER PRIMARY KEY,command_id INTEGER REFERENCES Commands(id), timestamp TEXT)";
                executeStatement(con, createChatHistoryTable);

                //Insert chat History into the ChatHistory table
                equals(1);
                equals("06-29-2023 11:00:00");

            }
        }

        private static void executeStatement(Connection connection, String query)  {
            try (Statement statement = connection.createStatement()) {
                statement.execute(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        }




