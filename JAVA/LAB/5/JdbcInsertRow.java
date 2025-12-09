import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcInsertRow {
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
            int id;
            String firstName, lastName, address;
            Scanner scan = new Scanner(System.in);
            System.out.println("Demo insert row into table Teachers ");
            System.out.print("Nhap vao ID: ");
            id = scan.nextInt();
            scan.nextLine();
            System.out.print("Nhap vao firstname: ");
            firstName = scan.nextLine();
            System.out.print("Nhap vao lastname: ");
            lastName = scan.nextLine();
            System.out.print("Nhap vao adress: ");
            address = scan.nextLine();
            String query = "INSERT INTO Teachers(Id, firstName, lastName, address)";
            query += " VALUES (" + id + ",'" + firstName + "', '" + lastName + "', '" + address + "')";
            System.out.println(query);
            stmt.execute(query);
            System.out.println("Thanh cong insert row.");
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
