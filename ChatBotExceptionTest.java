import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ChatBotExceptionTest {

    private static String DB_URL = "jdbc:sqlite:chatbot.db";

    @Test
    public void testCreateUserWithInvalidEmail() throws SQLException {
        Assertions.assertThrows(SQLException.class, ()-> {
            try (Connection con = DriverManager.getConnection(DB_URL)) {
                // invalid "email" field
                String createUserSql = "INSERT INTO Users (email) VALUES ('johnexample.com')";
                executeStatement(con, createUserSql);
            }
        });
    }
    private static void executeStatement(Connection connection, String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
}
