package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    /**
     * @param args the command line arguments
     */


        static String username = "appie3";
        static String password = "admin1234567890";

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=AuditBlackBox";
        Connection con = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(url,
                        username,
                        password);

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


