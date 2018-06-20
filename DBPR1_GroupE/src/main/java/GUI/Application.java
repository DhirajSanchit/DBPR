package GUI;


import DB.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Application extends JFrame {
    private JList brRapportList;
    private JLabel rapportLabel;
    private JTextPane feedbackField;
    private GridBagConstraints gbc;
    private GridBagLayout gridBag;
    private DataBaseField auditBlackBox;
    private BusinessRulesField businessRules;
    private SignalField signals;
    private JPanel display;
    private NotificationField notfications;
    private DBConnection databaseConnection;



        public Application (){

            setTitle("Leger des Heils - Audit");
            setSize(900, 750);

            display = new JPanel(new GridBagLayout());
            this.getContentPane().add(display);
            gbc = new GridBagConstraints();


            /** Hoofd display van de applicatie**/

//            System.out.println("Initiate");
             auditBlackBox = new DataBaseField();
             businessRules = new BusinessRulesField();
             signals = new SignalField();
             notfications = new NotificationField();
             databaseConnection = new DBConnection();
//            System.out.println("Instantiated");
//
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            gbc.fill = GridBagConstraints.BOTH;
            display.add(notfications, gbc);
            System.out.print("notificationpanel added!");


            /** Toevoeging van de de 3 Tabellen van Leger des Heils  **/
            gbc.gridx = 0;
            gbc.gridy = 2;
//            gbc.weightx = 0.1;
//            gbc.weighty = 0.1;
            gbc.gridwidth = 2;
//            gbc.gridheight = 3;
            gbc.anchor = GridBagConstraints.LAST_LINE_START;
            gbc.fill = GridBagConstraints.BOTH;
            display.add(auditBlackBox, gbc);
            System.out.print("auditblackbox added!");
            System.out.println("auditblackbox added!");

//            /** Toevoeging van de notificatie panel**/
//            gbc.gridx = 0;
//            gbc.gridy = 3;
//            gbc.weightx = 1;
//            gbc.weighty = 0.5;
//            gbc.gridwidth = 4;
//            gbc.anchor = GridBagConstraints.LAST_LINE_START;
//            gbc.fill = GridBagConstraints.HORIZONTAL;
//            display.add(notfications, gbc);
//            System.out.println("notificationpanel added!");

            /** Toevoeging van de Business Rules **/
            gbc.gridx = 3;
            gbc.gridy = 0;
//            gbc.gridwidth = 1;
//            gbc.gridheight = 2;
            gbc.anchor = GridBagConstraints.FIRST_LINE_END;
            gbc.fill = GridBagConstraints.BOTH;
            display.add(businessRules, gbc);
            System.out.println("Business Rules added!");

            /** Toevoeging van de Signalen **/
            gbc.gridx = 3;
            gbc.gridy = 2;
            gbc.gridheight = 1;
            gbc.insets = new Insets(2,5,5,2);
            gbc.anchor = GridBagConstraints.LAST_LINE_END;
            gbc.fill = GridBagConstraints.BOTH;
            display.add(signals, gbc);
            System.out.println("Signals added!");



        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }



        public final void start(){
         startConnection();
         }



        /**Method om de database connectie te starten**/
        public void startConnection(){
            /**Database connectie start   **/
            databaseConnection.login("appie3","admin1234567890");
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

