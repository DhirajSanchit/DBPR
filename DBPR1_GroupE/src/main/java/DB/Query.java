package DB;

public class Query {

    private String query;


    public static String newquery = "";

    public static String printQuery(String query) {
        System.out.print(query);
        return query;
    }

    public static void main(String[] args) {
        printQuery(newquery);

    }


    public Query(){

    }

}

