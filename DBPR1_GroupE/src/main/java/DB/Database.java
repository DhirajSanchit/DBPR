package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private String propertiesFile;
    private String queryUse;
    private Query queries;
    private Connection conn;
    private Statement stat;
    private ArrayList<Signaal> signaalADLijst;
    private ArrayList<Signaal> signaalPrLijst;
    private ArrayList<Signaal> signaalClLijst;
    private ArrayList<ArrayList<String>> arrayListAL;
    private ArrayList<String> data;
    private ResultSet resultSet;
    private ArrayList<Signaal> signaalLijst;


    public Database() throws SQLException {
        this.signaalADLijst = new ArrayList<>();
        this.signaalPrLijst = new ArrayList<>();
        this.signaalClLijst = new ArrayList<>();
        this.signaalLijst = new ArrayList<>();

        this.queries = new Query();
        this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=AuditBlackBox;integratedSecurity=true");
    }

    public void queryexe(String db, String qry, boolean result) throws SQLException {
        stat = conn.createStatement();

        queryUse = db;
        System.out.println(queryUse);
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

    public void initSignaalList() throws SQLException {
        stat = conn.createStatement();

        for(int i = 0; i < 3; i++) {
            resultSet = stat.executeQuery(queries.getProfitCleverSignal(i));
            while(resultSet.next()) {
                String result = resultSet.getString("code");
                Signaal mySignaal = new Signaal(9001,result,result,result,result);
                signaalADLijst.add(mySignaal);
                signaalLijst.add(mySignaal);
            }
        }
        for(int i = 0; i < 3; i++) {
            resultSet = stat.executeQuery(queries.getProfitAdSignal(i));
            while(resultSet.next()) {
                String result = resultSet.getString("Username_Pre2000");
                Signaal mySignaal = new Signaal(9001,result,result,result,result);
                signaalPrLijst.add(mySignaal);
                signaalLijst.add(mySignaal);
            }
        }
        for(int i = 0; i < 4; i++) {
            resultSet = stat.executeQuery(queries.getCleverAdSignal(i));
            while(resultSet.next()) {
                String result = resultSet.getString("Code");
                Signaal mySignaal = new Signaal(9001,result,result,result,result);
                signaalClLijst.add(mySignaal);
                signaalLijst.add(mySignaal);
            }
        }
    }

    public void fill() {

        for(int i = 0; i< signaalLijst.size(); i++){
            data = new ArrayList<String>();
            data.add(Integer.toString(signaalLijst.get(i).getTabelid()));
            data.add(signaalLijst.get(i).getCode());
            data.add(signaalLijst.get(i).getEmployeeusername());
            data.add(signaalLijst.get(i).getUsername_pre2000());
            data.add(signaalLijst.get(i).getAfkomstVan());
            arrayListAL.add(data);
            System.out.println(arrayListAL.get(i));
        }


        for (int i = 0; i < signaalADLijst.size(); i++) {
            data = new ArrayList<String>();
            data.add(Integer.toString(signaalADLijst.get(i).getTabelid()));
            data.add(signaalADLijst.get(i).getCode());
            data.add(signaalADLijst.get(i).getEmployeeusername());
            data.add(signaalADLijst.get(i).getUsername_pre2000());
            data.add(signaalADLijst.get(i).getAfkomstVan());
            arrayListAL.add(data);
            System.out.println(arrayListAL.get(i));
        }


        for (int i = 0; i < signaalPrLijst.size(); i++) {
            data = new ArrayList<String>();
            data.add(Integer.toString(signaalPrLijst.get(i).getTabelid()));
            data.add(signaalPrLijst.get(i).getCode());
            data.add(signaalPrLijst.get(i).getEmployeeusername());
            data.add(signaalPrLijst.get(i).getUsername_pre2000());
            data.add(signaalPrLijst.get(i).getAfkomstVan());
            arrayListAL.add(data);
            System.out.println(arrayListAL.get(i));
        }

        for (int i = 0; i < signaalClLijst.size(); i++) {
            data = new ArrayList<String>();
            data.add(Integer.toString(signaalClLijst.get(i).getTabelid()));
            data.add(signaalClLijst.get(i).getCode());
            data.add(signaalClLijst.get(i).getEmployeeusername());
            data.add(signaalClLijst.get(i).getUsername_pre2000());
            data.add(signaalClLijst.get(i).getAfkomstVan());
            arrayListAL.add(data);
            System.out.println(arrayListAL.get(i));
        }
    }


    /** DATABASE RESULTSET

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



     /** END DATBASE RSULTSET**/


    public void closeconnection() {

        try {
            conn.close();
            System.out.println("... verbinding afgesloten.");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[][] listToArray(){
        String[][] array = new String[arrayListAL.size()][];
        for (int i = 0; i < arrayListAL.size(); i++) {
            ArrayList<String> row = arrayListAL.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }
        return array;
    }



    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet){
        this.resultSet = resultSet;
    }

    public ArrayList<Signaal> getList() {
        return signaalLijst;
    }

    public ArrayList<Signaal> getList(ArrayList list) {

        if (list == signaalADLijst) {
            return signaalADLijst;
        }
        if (list == signaalPrLijst) {
            return signaalPrLijst;
        }
        if (list == signaalClLijst) {
            return signaalClLijst;
        }
        return null;
    }

    public ArrayList<ArrayList<String>> getarrayListAL(){
        return arrayListAL;
    }


    public ArrayList<Signaal> getSignaalADLijst() {
        return signaalADLijst;
    }

    public ArrayList<Signaal> getSignaalPrLijst() {
        return signaalPrLijst;
    }

    public ArrayList<Signaal> getSignaalClLijst() {
        return signaalClLijst;
    }
}
