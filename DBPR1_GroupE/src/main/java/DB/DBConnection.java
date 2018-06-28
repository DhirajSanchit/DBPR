package DB;

import GUI.Display;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Class.forName;


public class DBConnection {

        private ResultSet Result;
        private Result resultaat;

        private Query query;
        static String user = "appie3";
        static String pass = "admin1234567890";

    private static String urlAuditBlackBox = "jdbc:sqlserver://localhost:1433;databaseName=AuditBlackBox";
    private static String urlSignaal = "jdbc:sqlserver://localhost:1433;databaseName=Signalen";

    public void login(String url, String username, String password)  throws ClassCastException {
        url = urlAuditBlackBox;
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




    public static String getUrlAuditBlackBox() {
        return urlAuditBlackBox;
    }

    public static String getUrlSignaal() {
        return urlSignaal;
    }


    public void getProfitClever(){

    }

    public void getProfitAD(){

    }

    public void getCleverAD(){

    }

}


