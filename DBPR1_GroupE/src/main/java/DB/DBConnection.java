package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=AuditBlackBox;user=appie2;password=1234;";
        Connection con = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);

            if (con != null) {
                System.out.println("Connected to db succesfully!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


