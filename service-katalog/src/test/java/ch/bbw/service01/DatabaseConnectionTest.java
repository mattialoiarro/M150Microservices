package ch.bbw.service01;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DataJpaTest
public class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            assertTrue(connection.isValid(5));
        } catch (SQLException e) {
            e.printStackTrace();
            assertTrue(false, "Database connection failed.");
        }
    }
}
