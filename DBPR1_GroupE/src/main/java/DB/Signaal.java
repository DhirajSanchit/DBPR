package DB;

public class Signaal {

    private int id, tabelid;
    private String employeeusername, username_pre2000, afkomstVan, code;

    public Signaal(int tabelid, String code, String employeeUsername, String username_pre2000, String afkomstVan) {
        this.tabelid = tabelid;
        this.username_pre2000 = username_pre2000;
        this.employeeusername = employeeUsername; // BA-acount
        this.code = code;
        this.afkomstVan = afkomstVan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTabelid() {
        return tabelid;
    }

    public void setTabelid(int tabelid) {
        this.tabelid = tabelid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmployeeusername() {
        return employeeusername;
    }

    public void setEmployeeusername(String employee) {
        this.employeeusername = employee;
    }

    public String getUsername_pre2000() {
        return username_pre2000;
    }

    public void setUsername2000(String username2000) {
        this.username_pre2000 = username2000;
    }

    public String getAfkomstVan() {
        return afkomstVan;
    }

    public void setAfkomstVan(String afkomst) {
        this.afkomstVan = afkomst;
    }
}

