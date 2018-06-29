package GUI;

/**

 TODO:
 - adjust insets setting
 - fill the elements with the query results

 **/


import DB.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;


public class DataBaseField extends Field  {
    private Database ldhdatabase;


    private Field activeDirectoryField;
    private Field profitField;
    private Field cleverField;

    private JScrollPane adScrollPane, prScrollPane, clvrScrollPane;
    private GridBagConstraints gbc;
    private JTable activeDirectoryTable, profitTable, cleverTable;

    private Database database;
    private String[] columnNamesAD = {"Code", "Employeeusername", "IsVerwijderd", "Business Rule"};
    private String[] columnNamesPr = {"EmployeeUsername", "Username_Pre2000", "afas.ContractEndDate", "Business Rule"};
    private String[] columnNamesCl = {"id", "code", "Username_pre2000", "Business Rule"};
    private Object[][] data = {};

    private DefaultTableModel admodel = new DefaultTableModel(data, columnNamesAD);
    private DefaultTableModel prmodel = new DefaultTableModel(data, columnNamesPr);
  private DefaultTableModel clmodel = new DefaultTableModel(data, columnNamesCl);

    public DataBaseField() throws SQLException {

        ldhdatabase = new Database();

        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        createBorder("Databases");

        /** instantie layout manager items **/
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        /** Swing instanties voor de Audit blackbox DB  **/

        ///////// Fields for respective tables/////////
        activeDirectoryField = new Field();
        profitField = new Field();
        cleverField = new Field();

        ///////// AuditBlackBox Tables/////////
        activeDirectoryTable = new JTable(admodel);
        profitTable = new JTable(prmodel);
        cleverTable = new JTable(clmodel);

        //////// Scrollpanes making the tablefields scrollable/////////
        adScrollPane = new JScrollPane(activeDirectoryTable,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        prScrollPane = new JScrollPane(profitTable,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        clvrScrollPane = new JScrollPane(cleverTable,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


        activeDirectoryTable.setFillsViewportHeight(true);
        profitTable.setFillsViewportHeight(true);
        cleverTable.setFillsViewportHeight(true);


        ///////// GridbagConstrains constants/////////
        gbc.weightx = 0.005;
        gbc.weighty = 0.005;
        gbc.fill = GridBagConstraints.BOTH;
        Insets insets = new Insets(5, 5, 10, 5);

        ///////// Active Directory /////////
        activeDirectoryField.setBackground(Color.RED);
        activeDirectoryField.createBorder("Profit-Clever");
        activeDirectoryField.setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        activeDirectoryField.add(activeDirectoryTable.getTableHeader(), gbc);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        activeDirectoryField.add(adScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        //gbc.insets = insets;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1 / 100;
        add(activeDirectoryField, gbc);

        /////// Profit /////////
        profitField.setBackground(Color.BLUE);
        profitField.createBorder("Profit-AD ");
        profitField.setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        profitField.add(profitTable.getTableHeader(), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        profitField.add(prScrollPane, gbc);


//        profitField.add(profitTable.getTableHeader(), gbc);
//        profitField.add(profitTable, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = insets;
        add(profitField, gbc);

        /////// Clever /////////
        cleverField.setBackground(Color.GREEN);
        cleverField.createBorder("Clever-AD  ");
        cleverField.setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        cleverField.add(cleverTable.getTableHeader(), gbc);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        cleverField.add(clvrScrollPane, gbc);


        gbc.anchor = GridBagConstraints.NORTHWEST;
        ;
        //gbc.insets = insets;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(cleverField, gbc);


//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.BASELINE;
//        gbc.fill = GridBagConstraints.BOTH;
//        cleverField.add(cleverTable.getTableHeader(), gbc);
//        cleverField.add(clvrScrollPane, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 1;
//        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
//        gbc.insets = insets;
//        add(cleverField, gbc);


        /////////////// TABLE CELLS/ DATA CANNOT BE EDITTED////////////////////
        cleverField.setEnabled(false);
        profitTable.setEnabled(false);
        activeDirectoryTable.setEnabled(false);
        /////////////// TABLE CELLS/ DATA CANNOT BE EDITTED END////////////////
    }

    public JTable getActiveDirectoryTable() {
        return activeDirectoryTable;
    }

    public JTable getProfitTable() {
        return profitTable;
    }

    public JTable getCleverTable() {
        return cleverTable;
    }

    public void addSignaal(DefaultTableModel model, Object[] signaal) {
        if(model == admodel) {
            admodel.addRow(signaal);
        }
        if(model == prmodel) {
            prmodel.addRow(signaal);
        }
        if(model ==clmodel) {
            clmodel.addRow(signaal);
        }
    }

    public DefaultTableModel getAdmodel() {
        return admodel;
    }

    public DefaultTableModel getPrmodel() {
        return prmodel;
    }

    public DefaultTableModel getClmodel() {
        return clmodel;
    }
}

