package GUI;

import javax.swing.*;
import java.awt.*;

public class BusinessRulesField extends Field {

    //private Field businessRules;
    private JTextArea businessRulesList;
    //private JPanel;
    private GridBagConstraints gbc;
    private String[][] businessRules;

//
//    JList businessRulesList = new JList();
//    JList signals = new JList();


    public BusinessRulesField() {

        businessRules = new String[][]{
                {"0", "Medewerker uit dienst in CleverNew, account in AD actief"},
                {"1", "Medewerker uit dienst in Profit, account is in AD actief"},
                {"2", "AD Account, onbekend in Clever"},
                {"3", "AD Account, onbekend in Profit"},
                {"4", "RDS naam in CleverNew bestaat niet in AD"},
                {"5", "RDS User naam in Clever bestaat niet in Afas Profit"},
                {"6", "Medewerker uit dienst in Profit, account is in Clever actief"},
                {"7", "RDS naam in Clevernew is niet ingevuld"},
                {"8", "RDS User naam in Profit bestaat niet in de AD"},
                {"9", "RDS User naam in Profit bestaat niet in Clever"}
        };

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

    public void setRules(){
        for(int i = 0; i < businessRules.length; i++) {
        for(int j = 0; j < businessRules[i].length; j++) {
            businessRulesList.append(" " + businessRules[i][j]);
        }
            businessRulesList.append("\n");

        }
    }

}


