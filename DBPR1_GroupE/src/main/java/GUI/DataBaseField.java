package GUI;

/**

 TODO:
  - adjust insets setting
  - fill the elements with the query results

**/


import javax.swing.*;
import java.awt.*;


public class DataBaseField extends Field {

    private Field activeDirectoryField;
    private Field profitField;
    private Field cleverField;

    private JScrollPane adScrollPane, prScrollPane, clvrScrollPane;
    private GridBagConstraints gbc;
    private JTable activeDirectoryTable, profitTable, cleverTable;


    public DataBaseField(){

        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        createBorder("Databases");

    /** instantie layout manager items **/
    gbc = new GridBagConstraints();

    /** Swing instanties voor de Audit blackbox DB  **/

     ///////// Fields for respective tables/////////
     activeDirectoryField = new Field();
     profitField = new Field ();
     cleverField = new Field ();

     ///////// Scrollpanes making the tablefields scrollable/////////
     adScrollPane = new JScrollPane();
     prScrollPane = new JScrollPane();
     clvrScrollPane = new JScrollPane();

     ///////// AuditBlackBox Tables/////////
     activeDirectoryTable = new JTable(1,5);
     cleverTable = new JTable(1, 9);
     profitTable = new JTable(1, 9);


     setLayout(new GridBagLayout());


        ///////// GridbagConstrains constants/////////
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        Insets insets = new Insets(5,5,10,5);

        ///////// Active Directory /////////
        activeDirectoryField.setBackground(Color.RED);
        activeDirectoryField.createBorder("Active Directory");
        activeDirectoryField.setLayout(new GridBagLayout());

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = insets;
        activeDirectoryField.add(activeDirectoryTable,gbc);
        add(adScrollPane.add(activeDirectoryField), gbc);

        ///////// Profit /////////
        profitField.setBackground(Color.BLUE);
        profitField.createBorder("Profit");
        profitField.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = insets;
        profitField.add(profitTable, gbc);
        add(prScrollPane.add(profitField), gbc);

        ///////// Clever /////////
        cleverField.setBackground(Color.GREEN);
        cleverField.createBorder("Clever");
        cleverField.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = insets;
        cleverField.add(cleverTable, gbc);
        add(clvrScrollPane.add(cleverField), gbc);

        /////////////// TABLE CELLS/ DATA CANNOT BE EDITTED////////////////////
        cleverField.setEnabled(false);
        profitTable.setEnabled(false);
        activeDirectoryTable.setEnabled(false);
        /////////////// TABLE EXPERIMENTATION ////////////////////
//        activeDirectoryField.add(activeDirectoryTable);
//        profitField.add(profitTable);
//        cleverField.add(cleverTable);
        /////////////// TABLE EXPERIMENT END ////////////////////

     }


}
