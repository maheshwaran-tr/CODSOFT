import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = DBconfig.url;
    private static final String userName = DBconfig.userName;
    private static final String password = DBconfig.password;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}