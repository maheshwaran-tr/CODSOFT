import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = DBConfig.url;
    private static final String userName = DBConfig.userName;
    private static final String password = DBConfig.password;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}