package DB;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private String propertiesFile;
    private String queryUse;
    private Connection conn;
    private Statement stat;
    private ArrayList<Signaal> signaalLijst;
    private ArrayList<ArrayList<String>> signaalItemsList;
    private ArrayList<String> data;
    private ResultSet resultSet;

    public Database(String properties) {

        propertiesFile = properties;
        signaalLijst = new ArrayList<>();
        signaalItemsList = new ArrayList<>();


        try {
            DBProperties.init(propertiesFile);
            conn = DBProperties.getConnection();
            System.out.println("Verbinding gemaakt...");
        } catch (SQLException e) {
            System.out.println("Fout: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Fout: kan " + propertiesFile + " niet openen.");
        } catch (ClassNotFoundException e) {
            System.out.println("Fout: JDBC-driver niet gevonden.");
        }
    }


    public void queryexe(String db, String qry, boolean result) throws SQLException {
        stat = conn.createStatement();

        queryUse = db;

        stat.execute(queryUse);
        System.out.println("Database gevonden...");

        String qrySelect = qry;

        if (result) {
            resultSet = stat.executeQuery(qrySelect);
        } else {
            stat.executeUpdate(qrySelect);
        }
        System.out.println("Query exe succes :)");

    }

    public void fill() {
        for (int i = 0; i < signaalLijst.size(); i++) {
            data = new ArrayList<String>();
            data.add(Integer.toString(signaalLijst.get(i).getTabelid()));
            data.add(signaalLijst.get(i).getCode());
            data.add(signaalLijst.get(i).getEmployeeusername());
            data.add(signaalLijst.get(i).getUsername_pre2000());
            data.add(signaalLijst.get(i).getAfkomstVan());
            signaalItemsList.add(data);
            //System.out.println(signaalItemsList.get(i));
        }
    }

    /**
     * DATABASE RESULTSET
     **/

    public void saveres(ResultSet rSet, int type) {
        try {
            ResultSetMetaData metaData = rSet.getMetaData();
            //for(int i=0; i< metaData.getColumnCount(); i++){
            //for(int i = 0; i< rSet.getMetaData().getColumnCount(); i++){

            while (rSet.next()) {

                switch (type) {
                    case 0:
                        signaalLijst.add(
                                new Signaal(rSet.getInt("ID"),
                                        rSet.getString("code"),
                                        null, null,
                                        "Medewerker")
                        );
                        //System.out.println(type);
                        break;
                    case 1:
                        signaalLijst.add(
                                new Signaal(0, null,
                                        rSet.getString("EmployeeUsername"),
                                        null,
                                        "AfasProfit-Export")
                        );
                        //System.out.println(type);
                        break;
                    case 2:
                        signaalLijst.add(
                                new Signaal(0, null,
                                        null,
                                        rSet.getString("username_pre2000"),
                                        "AD-Export")
                        );
                        //System.out.println(type);
                        break;
                    case 3:
                        signaalLijst.add(
                                new Signaal(0, null,
                                        null,
                                        rSet.getString("username_pre2000"),
                                        "AD-Export")
                        );
                        //System.out.println(type);
                        break;
                    case 4:
                        signaalLijst.add(
                                new Signaal(rSet.getInt("id"),
                                        null, rSet.getString("EmployeeUsername"),
                                        null,
                                        "AfasProfit-Export")
                        );
                        //System.out.println(type);
                        break;
                    case 5:
                        signaalLijst.add(
                                new Signaal(rSet.getInt("ID"),
                                        rSet.getString("code"),
                                        null, null,
                                        "Medewerker"));
                        //System.out.println(type);
                        break;
                    case 6:
                        signaalLijst.add(
                                new Signaal(rSet.getInt("ID"),
                                        rSet.getString("code"),
                                        null,
                                        null,
                                        "Medewerker")
                        );
                        break;
                    case 7:
                        signaalLijst.add(
                                new Signaal(rSet.getInt("ID"),
                                        null,
                                        null,
                                        null,
                                        "Medewerker")
                        );
                        break;
                    case 8:
                        signaalLijst.add(
                                new Signaal(0,
                                        null, rSet.getString("employeeUsername"),
                                        null,
                                        "AfasProfit-Export")
                        );
                        break;
                    case 9:
                        signaalLijst.add(
                                new Signaal(0,
                                        null,
                                        rSet.getString("employeeUsername"),
                                        null,
                                        "AfasProfit-Export")
                        );
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;

                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    /**
     * END DATBASE RSULTSET
     **/


    public void closeConnection() {

        try {
            conn.close();
            System.out.println("... verbinding afgesloten.");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // arraylist naar array, zodat de data gevuld kunnen worden in respectivelijke tabellen tabellen
    public String[][] listToArray() {
        String[][] array = new String[signaalItemsList.size()][];
        for (int i = 0; i < signaalItemsList.size(); i++) {
            ArrayList<String> row = signaalItemsList.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }
        return array;
    }


    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ArrayList<Signaal> getList() {
        return signaalLijst;
    }

    public ArrayList<ArrayList<String>> getarrayListAL() {
        return signaalItemsList;
    }

}

