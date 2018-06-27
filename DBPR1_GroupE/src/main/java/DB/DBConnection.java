package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;


public class DBConnection {


        static String user = "appie3";
        static String pass = "admin1234567890";



    public void login(String username, String password) {
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


