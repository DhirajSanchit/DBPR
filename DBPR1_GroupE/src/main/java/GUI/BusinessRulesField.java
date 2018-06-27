package GUI;

import javax.swing.*;
import java.awt.*;

public class BusinessRulesField extends Field {

    //private Field businessRules;
    private JTextArea businessRulesList;
    //private JList businessRulesList;
    //private JPanel;
    private GridBagConstraints gbc;

//
//    JList businessRulesList = new JList();
//    JList signals = new JList();


    public BusinessRulesField() {

        String fillertext = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
                "xercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
                "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
                "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum \n";


        this.createBorder("Business Rules");

        /** instantie layout manager items **/
        gbc = new GridBagConstraints();

        /** Swing instanties voor de Audit blackbox DB  **/
        //businessRulesList = new JList();
        businessRulesList = new JTextArea();
        businessRulesList.setEditable(false);
        businessRulesList.append(fillertext);
        businessRulesList.setLineWrap(true);

        setLayout(new GridBagLayout());


        ///////// Business Rules /////////
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(businessRulesList), gbc);
    }


}