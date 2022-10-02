package udemy;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {
    public static Connection connect() throws Exception {
        // Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydemodb";
        String username = "root";
        String password = "Gltsry1905!";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
