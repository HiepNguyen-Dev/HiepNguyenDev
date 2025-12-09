import java.sql.*;

public class ConnectSQLServerWindowsAuth {
    public static void main(String[] args) {
        // --- SQL Server connection string using Windows Authentication
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;"
                + "databaseName=HAU;"
                + "integratedSecurity=true;"
                + "trustServerCertificate=true";   // <--- required
        Connection conn = null; // connection to database
        try {
            //1. Create connection to database server
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to SQL Server (Windows Authentication) successfully!");
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select * from Students");
            // show data
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3));
            }
            // close connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection error!");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
