package payroll;
import java.sql.*;
public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/payroll_system";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}