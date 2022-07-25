package by.htp.ex.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractConnection {
	private static String url = "jdbc:mysql://127.0.0.1:3306/newsapp";
    private static String username = "root";
    private static String password = "";
    private static Connection connection = null;

    public static Connection connection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (connection == null) {
                connection = (Connection) DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Can't get a connection", e);
        }
        return connection;
    }
}
