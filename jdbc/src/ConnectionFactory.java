import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5441/mildevs", "postgres", "postgres"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
