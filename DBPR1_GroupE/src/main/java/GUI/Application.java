package GUI;


import DB.DBConnection;
import DB.Database;
import DB.Query;

import javax.swing.*;
import java.awt.*;

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

    private Database ldhDb;
    private String legerdbfile = "database.properties";

    private Database signaalDb;
    private String signaaldbfile = "signaal.properties";
//
    private Query queryList;

    {
        setTitle("Leger des Heils - Audit");
        setSize(1200, 1000);

    }

        public Application () {
            display = new Display();

            initializeDatabases();
            


            databaseConnection = new DBConnection();

            this.getContentPane().add(display);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

    private void initializeDatabases() {
        ldhDb = new Database(legerdbfile);
        signaalDb = new Database(signaaldbfile);
        queryList = new Query();
        System.out.println("test");
    }


    public final void start(){
         startConnection();
         }



        /**Method om de database connectie te starten**/
        public void startConnection(){
            /**Database connectie start   **/
            databaseConnection.login(DBConnection.getUrlAuditBlackBox(),"appie3","admin1234567890");
            //databaseConnection.login(DBConnection.getUrlSignaal(),"appie3", "admin1234567890");
            display.getNotfications().updateNotifications("Verbinding gemaakt! \n");
        }

    /**Method om de database connectie te stoppen**/
        public void stopConnection(){
            /**Database connectie stopt**/
            System.out.println("Connection stopped");
        }

    /**
    startButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            feedbackField.setText("Connection started");
        }
    });

    buttonCancel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            feedbackField.setText("Connection stopped");
        }
    });

    resetButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            feedbackField.setText("---");
            businessRulesTA.setText("---");
        }
    });




    // call onCancel() when cross is clicked
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            onCancel();
        }
    });

    // call onCancel() on ESCAPE
    contentPane.registerKeyboardAction(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            onCancel();
        }
    }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
}

private void onOK() {
    // add your code here
    dispose();
}

private void onCancel() {
    // add your code here if necessary
    dispose();
}

 **/




    }

