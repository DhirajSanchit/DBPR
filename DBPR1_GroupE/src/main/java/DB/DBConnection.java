package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {


    static String user = "appie2";
    static String pass = "1234";

    private static String urlAuditBlackBox = "jdbc:sqlserver://localhost:1433;databaseName=AuditBlackBox";
    private static String urlSignaal = "jdbc:sqlserver://localhost:1433;databaseName=Signaal";

    public void login(String url, String username, String password)  throws ClassCastException {
        url = url;
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

    public String getUrlAuditBlackBox() {
        return urlAuditBlackBox;
    }

    public String getUrlSignaal() {
        return urlSignaal;
    }


}