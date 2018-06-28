package GUI;

/**

 TODO:
  - adjust insets setting
  - fill the elements with the query results

**/


import DB.Query;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

import static javafx.scene.input.KeyCode.J;

public class DataBaseField extends Field {

    private Field activeDirectoryField;
    private Field profitField;
    private Field cleverField;

    private JScrollPane adScrollPane, prScrollPane, clvrScrollPane;
    private GridBagConstraints gbc;
    private JTable activeDirectoryTable, profitTable, cleverTable;
    private Query query = new Query();

    private String[] columnNames = {"Source", "Hit", "Last", "Ur_Diff", "Source", "Hit", "Last", "Ur_Diff"};
    private Object[][] data = {
            {"Swing Timer", 2.99, 5, 1.01},
            {"Swing Worker", 7.10, 5, 1.010},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"Swing Worker", 7.10, 5, 1.010},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"Swing Timer", 2.99, 5, 1.01},
            {"Swing Worker", 7.10, 5, 1.010},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"Swing Worker", 7.10, 5, 1.010},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},
//            {"TableModelListener", 25.05, 5, 1.01},


    };
    private DefaultTableModel model = new DefaultTableModel(data, columnNames);


    public DataBaseField() {

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

        //Resultset resultset = stmt query.getCleverAdSignal(1);

        ///////// AuditBlackBox Tables/////////
        activeDirectoryTable = new JTable(model);
        profitTable = new JTable(model);
        cleverTable = new JTable(model);


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

        activeDirectoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        activeDirectoryTable.setFillsViewportHeight(true);

        profitTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        profitTable.setFillsViewportHeight(true);

        cleverTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        cleverTable.setFillsViewportHeight(true);
//

//        gbc.weightx = 0.0001;
//        gbc.weighty = 0.0001;
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.anchor = GridBagConstraints.CENTER;


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


        /////////////// TABLE EXPERIMENTATION ////////////////////
//        activeDirectoryField.add(activeDirectoryTable);
//        profitField.add(profitTable);
//        cleverField.add(cleverTable);
        /////////////// TABLE EXPERIMENT END ////////////////////

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

//    public void updateTable(JTable tableName, String[][] data, String[] names) {
//
//        if(tableName == activeDirectoryTable){
//            System.out.println("AD filled");
//        } if (tableName == profitTable){
//            System.out.println("profit");
//        }
//        if (tableName == cleverTable) {
//            System.out.println("clever filled");
//        }

        public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }

            return new DefaultTableModel(data, columnNames);

        }


    }


