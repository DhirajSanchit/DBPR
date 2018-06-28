package DB;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.ArrayList;

import static java.sql.JDBCType.NULL;

public class Query {

    private final ArrayList<String> profitCleverSignal;
    private final ArrayList<String> profitAdSignal;
    private final ArrayList<String> cleverAdSignal;

    private final ArrayList<String> impactQeurys;
    private String insertSignaalQuery, input;

    public Query(){

        Query query = new Query();
        profitCleverSignal = new ArrayList<>();
        profitAdSignal = new ArrayList<>();
        cleverAdSignal = new ArrayList<>();

        impactQeurys = new ArrayList<>();

        /** Profit-Clever  Signaal **/
         profitCleverSignal.add(
                "Select AD.EmployeeUsername, PC.Code \n" +
                        "from dbo.[AfasProfit-Export] \n" +
                        "AD LEFT JOIN dbo.PersoonCodes PC ON AD.EmployeeUsername= PC.Code \n " +
                        "where PC.Code IS NULL "
        );

        profitCleverSignal.add(
                "select pc.code, AP.ContractEndDate, pc.IsVerwijderd\n" +
                        "from dbo.PersoonCodes \n" +
                        "PC INNER JOIN dbo.[AfasProfit-Export] AP ON PC.code=AP.EmployeeUsername\n" +
                        "where AP.ContractEndDate <  CURRENT_TIMESTAMP and PC.IsVerwijderd = 0\n" +
                        "order by ap.ContractEndDate"
        );

        profitCleverSignal.add(
                "Select PC.Code, AP.EmployeeUsername\n" +
                        "from dbo.PersoonCodes\n" +
                        "PC LEFT JOIN dbo.[AfasProfit-Export] AP ON AP.EmployeeUsername= PC.Code\n" +
                        "where AP.EmployeeUsername IS NULL"
        );


        /** Profit-AD  Signaal **/

        profitAdSignal.add(
                "use AuditBlackBox\n" +
                        "Select EmployeeUsername, Username_Pre2000\n" +
                        "from dbo.[AfasProfit-Export] \n" +
                        "LEFT JOIN dbo.[AD-Export] ON Username_Pre2000=EmployeeUsername\n" +
                        "where Username_Pre2000 IS NULL"
        );




         profitAdSignal.add(
                " use AuditBlackBox\n" +
                        " Select AD.Username_Pre2000, afas.ContractEndDate,  AD.Disabled\n" +
                        " from dbo.[AfasProfit-Export] afas " +
                        "JOIN dbo.[AD-Export] AD ON Username_Pre2000=EmployeeUsername\n" +
                        " where afas.ContractEndDate IS NOT NULL and AD.Disabled = 1\n"
        );

        profitAdSignal.add(
                " use AuditBlackBox\n" +
                        "Select EmployeeUsername, Username_Pre2000\n" +
                        "from dbo.[AD-Export] \n" +
                        "LEFT JOIN dbo.[AfasProfit-Export] ON Username_Pre2000=EmployeeUsername\"\n" +
                        "where EmployeeUsername IS NULL"
        );


        /** Clever-AD  Signaal **/
        cleverAdSignal.add(
                "Select code from dbo.PersoonCodes " +
                        "where Code = 'Andere Code'"
        );

        cleverAdSignal.add(
                "Select code" +
                        "from dbo.PersoonCodes \n" +
                        "PC left joiN dbo.[AD-Export] AD ON PC.Code= AD.Username_Pre2000 \n" +
                        "where PC.code like '%hhs' and PC.code not like 'NULLhhs' and AD.Disabled = 0"
        );

        cleverAdSignal.add(
                "Select code from dbo.PersoonCodes \n" +
                        "INNER JOIN dbo.[AD-Export] on dbo.PersoonCodes.code = dbo.[AD-Export].Username_Pre2000\n" +
                        "where Einddatum IS NOT NULL"
        );

        cleverAdSignal.add(
                "Select pc.Code, ad.Username_Pre2000\n" +
                        "from dbo.PersoonCodes pc\n" +
                        "Left JOIN dbo.[AD-Export] ad on pc.code = ad.Username_Pre2000\n" +
                        "where Username_Pre2000 IS NULL and pc.code != 'Andere Code' "
        );




    }



    public String getProfitCleverSignal(int i) {
        return profitCleverSignal.get(i);
    }

    public String getProfitAdSignal(int i) {
        return profitAdSignal.get(i);
    }

    public String getCleverAdSignal(int i) {
        return cleverAdSignal.get(i);
    }

    public int getSignaalListSize(ArrayList list) {
        return list.size();
    }



//    public String getSignaalQuery(int i) {
//        return signaalQuerys.get(i);
//    }
//
//    public int getSignaalQlistSize() {
//        return signaalQuerys.size();
//    }

    public String getInsertSignaalQuery() {
        return insertSignaalQuery;
    }


    public void setInsertSignaalQuery(int tabelid, String code, String employeeUsername, String username_pre2000, String afkomstVan) {
        this.insertSignaalQuery = "INSERT INTO Signaal (tabelid,username_pre2000,employeeUsername,code,afkomstigVan)"
                + "VALUES (" + tabelid + ",'" + username_pre2000 + "','" + employeeUsername + "','" + code + "','" + afkomstVan + "')";
    }


    public void setInput(String input) {
        this.input = input;
    }

    public String getImpactQuery(String input, int i) {
        return impactQeurys.get(i);
    }

}

