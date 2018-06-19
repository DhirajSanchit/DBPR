package GUI;


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
//            System.out.println("Instantiated");
//

            /** Toevoeging van de notificatie panel**/
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.fill = GridBagConstraints.BOTH;
            display.add(notfications, gbc);
            System.out.print("auditblackbox added!");

            /** Toevoeging van de de 3 Tabellen van Leger des Heils  **/
            gbc.gridx = 0;
            gbc.gridy = 2;
//            gbc.weightx = 0.1;
//            gbc.weighty = 0.1;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.SOUTHWEST;
            gbc.fill = GridBagConstraints.BOTH;
            display.add(auditBlackBox, gbc);
            System.out.print("auditblackbox added!");






            /** Toevoeging van de Business Rules **/
            gbc.gridx = 3;
            gbc.gridy = 0;
//            gbc.gridwidth = 1;
//            gbc.gridheight = 2;
            gbc.anchor = GridBagConstraints.NORTHEAST;
            gbc.fill = GridBagConstraints.BOTH;
            display.add(businessRules, gbc);

            /** Toevoeging van de Signalen **/
            gbc.gridx = 3;
            gbc.gridy = 2;
//            gbc.gridwidth = 1;
//            gbc.gridheight = 2;
            gbc.anchor = GridBagConstraints.SOUTHEAST;
            gbc.fill = GridBagConstraints.BOTH;
            display.add(signals, gbc);



//            /** Panel Test **/
//            JPanel panel = new JPanel();
//            panel.setBackground(Color.BLUE);
//            panel.setSize(100,100);
//
//            gbc.gridx = 3;
//            gbc.gridy = 3;
//            gbc.fill = GridBagConstraints.NONE;
//            gbc.anchor = GridBagConstraints.SOUTHWEST;
//            display.add(panel, gbc);


        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }



        public final void start(){

       /* ///////// Audit Blackbox Tabellen/////////
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.LINE_START;
        add(auditBlackBox, gbc);


        ///////// Business Rules /////////
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.LINE_END;
        add(businessRules, gbc);
*/

       // add(signals);
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

        databaseField.setLayout(new GridLayout(3, 0, 5,5));
        databaseField.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Business Rules"
        ));

        **/

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

