package GUI;


import DB.DBConnection;
import DB.Database;
import DB.Query;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Application extends JFrame {
    private JList brRapportList;
    private JLabel rapportLabel;
    private JTextPane feedbackField;
    private GridBagConstraints gbc;
    private GridBagLayout gridBag;
    private DataBaseField auditBlackBox;
    private BusinessRulesField businessRules;
    private SignalField signals;
    private NotificationField notfications;
    private DBConnection databaseConnection;
    private ButtonField buttons;
    private Display display;

    private Database legerDesHeilsDB;
    private Database signaalDB;
    private Query queryList;

    {
        setTitle("Leger des Heils - Audit");
        setSize(1200, 1000);
    }

    public Application () throws SQLException {
        display = new Display();
        legerDesHeilsDB = new Database();
        signaalDB = new Database();
        queryList = new Query();

        databaseConnection = new DBConnection();
        this.getContentPane().add(display);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public final void start(){
        startConnection();
    }

    /**Method om de database connectie te starten**/
    public void startConnection(){
        /**Database connectie start   **/
        databaseConnection.login(databaseConnection.getUrlAuditBlackBox(),"appie3","admin1234567890");
        display.getNotfications().updateNotifications("Verbinding gemaakt met AuditBlackBox! \n");
        databaseConnection.login(databaseConnection.getUrlSignaal(),"appie3","admin1234567890");
        display.getNotfications().updateNotifications("Verbinding gemaakt met signaal! \n");
    }

    /**Method om de database connectie te stoppen**/
    public void stopConnection(){
        /**Database connectie stopt**/
        System.out.println("Connection stopped");
    }

}

