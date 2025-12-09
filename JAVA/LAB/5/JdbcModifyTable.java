import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcModifyTable {
    public static void main(String[] args) {
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

            String query1 ="ALTER TABLE Teachers DROP COLUMN description";
            String query2 = "ALTER TABLE Teachers ADD address NVARCHAR(200)";
            //System.out.println(query1);
            stmt.execute(query2);
            System.out.println("Table Teachers is modified! Droped collumn description and added columm adress.");
            // -----close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
