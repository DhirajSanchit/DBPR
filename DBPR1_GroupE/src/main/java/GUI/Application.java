package GUI;

import com.sun.jmx.snmp.SnmpOpaque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javafx.scene.input.KeyCode.J;

public class Application extends JFrame {
    private JPanel contentPane, business;
    private JButton startButton;
    private JButton buttonCancel;
    private JButton resetButton;
    private JButton printButton;
    private JPanel businessRulesField;
    private JLabel businessRulesLabel;
    private JTextPane businessRulesTA;
    private JList brRapportList;
    private JLabel rapportLabel;
    private JLabel applicationTitleLabel;
    private JPanel buttonsField;
    private JPanel databaseField;
    private JTextPane feedbackField;
    private JPanel signalDB;
    private JPanel space;
    private JPanel businessSignals;
    private GridBagConstraints gbc;
    private GridBagLayout gridBag;




        public final void start(){
        Application application = new Application();
        gbc = new GridBagConstraints();
        gridBag = new GridBagLayout();
        Container contentPane = getContentPane();



        JPanel activeDirectoryPanel = new JPanel();
        JPanel profitPanel = new JPanel();
        JPanel cleverPanel = new JPanel ();
        JPanel signalsPanel = new JPanel ();
        JPanel businessRulesPanel =  new JPanel();
        contentPane.setLayout(gridBag);
        gbc.fill = GridBagConstraints.HORIZONTAL;




            activeDirectoryPanel.setBackground(Color.RED);
            activeDirectoryPanel.setSize(100,100);
            activeDirectoryPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Active Directory"
            ));
            gbc.weightx=1;
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.fill = GridBagConstraints.FIRST_LINE_START;
            gridBag.setConstraints(activeDirectoryPanel, gbc);
            contentPane.add(activeDirectoryPanel);



            profitPanel.setBackground(Color.BLUE);
            profitPanel.setSize(100,100);
            profitPanel.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(), "Profit"
            ));
            gbc.weightx = 2;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gridBag.setConstraints(profitPanel, gbc);
            contentPane.add(profitPanel);

            //cleverPanel
            cleverPanel.setBackground(Color.GREEN);
            cleverPanel.setSize(100,100);
            cleverPanel.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(), "Clever"));

            gbc.weightx = 3;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gridBag.setConstraints(cleverPanel, gbc);
            contentPane.add(cleverPanel);

            signalsPanel.setBackground(Color.YELLOW);
            signalsPanel.setSize(100,100);
            signalsPanel.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(), "Signalen"));

            gbc.gridx = 0;
            gbc.gridy = 4;
            gridBag.setConstraints(signalsPanel, gbc);
            contentPane.add(signalsPanel);


            businessRulesPanel.setBackground(Color.PINK);
            businessRulesPanel.setSize(100,100);
            businessRulesPanel.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(), "Business Rules"));
            gbc.gridx = 0;
            gbc.gridy = 5;
            gridBag.setConstraints(businessRulesPanel, gbc);
            contentPane.add(businessRulesPanel);





            JTable activeDirectoryTable = new JTable(1,5);
            JTable cleverTable = new JTable(1, 9);
            JTable profitTable = new JTable(1, 9);

            JList businessRulesList = new JList();
            JList signals = new JList();

            cleverTable.setEnabled(false);
            profitTable.setEnabled(false);
            activeDirectoryTable.setEnabled(false);

            activeDirectoryPanel.add(activeDirectoryTable);
            profitPanel.add(profitTable);
            cleverPanel.add(cleverTable);
            businessRulesPanel.add(businessRulesList);
            signalsPanel.add(signals);


            //space.add(clever);
            //space.add(profit);


        setTitle("Leger des Heils - Audit");
        setVisible(true);
        setSize(900, 650);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        /**
         * Initiëele velden ter bij het opstarten van het programma
         *
         */


        /** Hieronder is de opzet en vervolgends een toevoeging van alle visuele elementen die de GUI bevat*/

        /**  **/


        /**
         *  Methoden van de applicatie
         *
         *  De archictectuur van deze opzet kan nog veranderd worden
         *  Voor nu is er een overname van actionlisteners voor de knoppen
         */

        /**
        databaseField = new JPanel();
        databaseField.setLayout(new GridLayout(3, 0, 5,5));
        databaseField.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Business Rules"
        ));

        **/
            //databaseField.add;


        //Velden voor business rules en signalen


         //application.add(businessSignals);
         //application.add(businessRulesField);
         //application.add(signalDB);
        //application.add(label);

           //this.add(activeDirectoryPanel);
           //this.add(profitPanel);
    }


        /** hieronder moet nog de close operatie voor de DB connectie  **/



    /**Method om de database connectie te starten**/
        public void startConnection(){
            /**Database connectie start   **/

            System.out.println("connection started");

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

