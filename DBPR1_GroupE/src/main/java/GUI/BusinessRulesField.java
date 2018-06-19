package GUI;

import javax.swing.*;
import java.awt.*;

public class BusinessRulesField extends Field {

    private Field businessRules;
    //private JTextPane businessRulesList;
      private JList businessRulesList;
    //private JPanel;
    private GridBagConstraints gbc;

//
//    JList businessRulesList = new JList();
//    JList signals = new JList();


    public BusinessRulesField() {

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
                "xercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
                "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
                "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";


        this.createBorder("Business Rules");

        /** dimensions for the size **/
        Dimension dim = getPreferredSize();
        dim.width = 300;
        dim.height = 325;
        setPreferredSize(dim);

        /** instantie layout manager items **/
        gbc = new GridBagConstraints();

        /** Swing instanties voor de Audit blackbox DB  **/
          businessRulesList = new JList();
//        businessRulesList = new JTextPane();
//        businessRulesList.setText(text);
        //businessRulesList.setLineWrap(true);
        setLayout(new GridBagLayout());


        ///////// Business Rules /////////
        //gbc.weightx = 100;
        //gbc.weighty = 100;
        gbc.insets = new Insets(5, 5, 5, 5);
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel("---"), gbc);

    }


}