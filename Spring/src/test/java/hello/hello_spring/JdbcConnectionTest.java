package hello.hello_spring;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JdbcConnectionTest {

    @Test
    void testSqlServerConnection() throws Exception {
        String url = "jdbc:sqlserver://DESKTOP-7LGLMR5\\SQLEXPRESS;databaseName=Member;encrypt=true;trustServerCertificate=true";
        String username = "dev_user";
        String password = "dev1234!";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            assertTrue(connection.isValid(2));
            System.out.println("✅ JDBC 연결 성공!");
        }
    }
}
