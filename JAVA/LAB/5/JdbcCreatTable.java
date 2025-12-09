import java.sql.*;

public class JdbcCreatTable {
    public static void main(String args[]) {
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
            String query ="CREATE TABLE Teachers (" +
                    "id   INT  NOT NULL," +
                    "firstName NVARCHAR(255) NOT NULL," +
                    "lastName NVARCHAR (255) NOT NULL," +
                    "description NVARCHAR (255) NOT NULL," +
                    "PRIMARY KEY (id));";
            System.out.println(query);
            stmt.execute(query);
            System.out.println("Table Teachers is created");
            // -----close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
