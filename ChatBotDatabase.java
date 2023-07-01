
import java.sql.*;

public class ChatBotDatabase {
    public static void main(String[] args) {

         String url = "jdbc:sqlite:chatbot.db";
        
        //Database Connection)
        try (Connection con = DriverManager.getConnection(url)) {
            
            // Create Users table
            String createUsersTable = "Create Table users (id INTEGER PRIMARY KEY, name TEXT, email TEXT)";
            executeStatement(con, createUsersTable);
            
            //Create command Table
            String createCommandsTable = "Create table commands (id INTEGER, command TEXT)";
            executeStatement(con, createCommandsTable);

            //Create Chat History Table
            String createChatHistoryTable = "Create table chatHistory (id INTEGER PRIMARY KEY,command_id INTEGER REFERENCES Commands(id), timestamp TEXT)";
            executeStatement(con, createChatHistoryTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    
    private static void executeStatement(Connection con, String createUsersTable) {
        try (Statement statement = con.createStatement()) {
            statement.execute(createUsersTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

       // To verify the tables exist in Database
 /*   private static boolean checkTableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metadata = connection.getMetaData();
        ResultSet resultSet = metadata.getTables(null, null, tableName, null);
        return resultSet.next();
    }*/
}





