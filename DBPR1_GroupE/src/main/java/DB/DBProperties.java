package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBProperties {

    private static String url;

    public static void init(String fileName) throws IOException, ClassNotFoundException{


        FileInputStream fileInputStream = new FileInputStream(fileName);

        Properties properties = new Properties();
        properties.load(fileInputStream);
        url = properties.getProperty("jdbc.url");
        String driver = properties.getProperty("jdbc.driver");
        if (driver != null) {
            Class.forName(driver);  // load the specified JDBC-driver
        }
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url);
    }
}

