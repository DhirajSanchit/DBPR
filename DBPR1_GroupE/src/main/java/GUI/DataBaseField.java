package GUI;

/**

 TODO:
  - adjust insets setting
  - fill the elements with the query results

**/


import javax.swing.*;
import java.awt.*;

import static javafx.scene.input.KeyCode.J;

public class DataBaseField extends Field {

    private Field activeDirectoryField;
    private Field profitField;
    private Field cleverField;
    private Field signalsField;
    private Field businessRulesField;
    //private JPanel;
    private GridBagConstraints gbc;
    private JTable activeDirectoryTable, profitTable, cleverTable;


    public DataBaseField(){
        Dimension dim = getPreferredSize();
        dim.width = 600;
        dim.height = 500;
        setPreferredSize(dim);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    /** instantie layout manager items **/
    gbc = new GridBagConstraints();

    /** Swing instanties voor de Audit blackbox DB  **/
     activeDirectoryField = new Field();
     profitField = new Field ();
     cleverField = new Field ();
     signalsField = new Field ();
     businessRulesField =  new Field();

     activeDirectoryTable = new JTable(1,5);
     cleverTable = new JTable(1, 9);
     profitTable = new JTable(1, 9);

     setLayout(new GridBagLayout());



        ///////// Active Directory Panel /////////
        activeDirectoryField.setBackground(Color.RED);
        activeDirectoryField.setSize(100,100);
        activeDirectoryField.createBorder("Active Directory");

        gbc.weightx=1;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(5, 5, 10, 5);
        activeDirectoryField.add(activeDirectoryTable);
        add(activeDirectoryField, gbc);


        ///////// Profitpanel /////////
        profitField.setBackground(Color.BLUE);
        profitField.setSize(100,100);
        profitField.createBorder("Profit");

        gbc.weightx = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(5, 5, 10, 5);
        profitField.add(profitTable);
        add(profitField, gbc);

        ///////// cleverPanel /////////
        cleverField.setBackground(Color.GREEN);
        cleverField.setSize(100,100);
        cleverField.createBorder("Clever");


        cleverField.setEnabled(false);
        profitTable.setEnabled(false);
        activeDirectoryTable.setEnabled(false);


        gbc.weightx = 3;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(5, 5, 10, 5);
        cleverField.add(cleverTable);
        add(cleverField, gbc);


        /////////////// TABLE EXPERIMENTATION ////////////////////

//        activeDirectoryField.add(activeDirectoryTable);
//        profitField.add(profitTable);
//        cleverField.add(cleverTable);
        /////////////// TABLE EXPERIMENT END ////////////////////

     }


}
