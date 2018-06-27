//import GUI.Field;
//
//import javax.swing.*;
//import javax.swing.event.TableModelListener;
//import javax.swing.table.TableModel;
//import java.awt.*;
//
//public class Snippet2 {
//
//    package GUI;
//
///**
//
// TODO:
// - adjust insets setting
// - fill the elements with the query results
//
// **/
//
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.event.TableModelListener;
//import javax.swing.table.TableModel;
//import java.awt.*;
//
//import static javafx.scene.input.KeyCode.J;
//
//    public class DataBaseField extends Field {
//
//        private Field activeDirectoryField;
//        private Field profitField;
//        private Field cleverField;
//
//        private JScrollPane adScrollPane, prScrollPane, clvrScrollPane;
//        private GridBagConstraints gbc;
//        private JTable activeDirectoryTable, profitTable, cleverTable;
//
//
//        public DataBaseField(){
////        Dimension dim = getPreferredSize();
////        dim.width = 1200;
////        dim.height = 500;
////        setPreferredSize(dim);
//            setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
//            createBorder("Databases");
//
//            /** instantie layout manager items **/
//            gbc = new GridBagConstraints();
//            setLayout(new GridBagLayout());
//
//            /** Swing instanties voor de Audit blackbox DB  **/
//
//            ///////// Fields for respective tables/////////
//            activeDirectoryField = new Field();
//            profitField = new Field ();
//            cleverField = new Field ();
//
//
//            ///////// AuditBlackBox Tables/////////
//            activeDirectoryTable = new JTable(myModel) {
//                public boolean getScrollableTracksViewportWidth() {
//                    return getPreferredSize().width < getParent().getWidth();
//                }
//            };
//            cleverTable = new JTable(1, 9);
//            profitTable = new JTable(1, 9);
//
//
//            ///////// Scrollpanes making the tablefields scrollable/////////
//            adScrollPane = new JScrollPane(activeDirectoryTable);
//            prScrollPane = new JScrollPane(cleverTable);
//            clvrScrollPane = new JScrollPane(profitTable);
//
//
//            activeDirectoryTable.setFillsViewportHeight(true);
//
//            gbc.weightx = 0.0001;
//            gbc.weighty = 0.0001;
//            gbc.gridx = 0;
//            gbc.gridy = 0;
//            gbc.fill = GridBagConstraints.BOTH;
//            gbc.anchor = GridBagConstraints.NORTHWEST;
//            activeDirectoryField.add(adScrollPane.add(activeDirectoryTable), gbc);
//
//
//            ///////// GridbagConstrains constants/////////
//            gbc.weightx = 0.5;
//            gbc.weighty = 0.5;
//            gbc.fill = GridBagConstraints.BOTH;
//            Insets insets = new Insets(5,5,10,5);
//
//            ///////// Active Directory /////////
//            activeDirectoryField.setBackground(Color.RED);
//            activeDirectoryField.createBorder("Active Directory");
//            activeDirectoryField.setLayout(new GridBagLayout());
//
//            gbc.gridx=0;
//            gbc.gridy=0;
//            gbc.anchor = GridBagConstraints.NORTHEAST;
//            gbc.insets = insets;
//            //activeDirectoryField.add(activeDirectoryTable.getTableHeader(),gbc);
//            add(activeDirectoryField, gbc);
//
//
//            ///////// Profit /////////
//            profitField.setBackground(Color.BLUE);
//            profitField.createBorder("Profit");
//            profitField.setLayout(new GridBagLayout());
//
//            gbc.gridx = 0;
//            gbc.gridy = 1;
//            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
//            gbc.insets = insets;
//            profitField.add(profitTable, gbc);
//            add(profitField, gbc);
//
//            ///////// Clever /////////
////        cleverField.setBackground(Color.GREEN);
////        cleverField.createBorder("Clever");
////        cleverField.setLayout(new GridBagLayout());
////
////        gbc.gridx = 0;
////        gbc.gridy = 2;
////        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
////        gbc.insets = insets;
////        cleverField.add(cleverTable, gbc);
////        add(clvrScrollPane.add(cleverField), gbc);
//
//            /////////////// TABLE CELLS/ DATA CANNOT BE EDITTED////////////////////
////        cleverField.setEnabled(false);
////        profitTable.setEnabled(false);
////        activeDirectoryTable.setEnabled(false);
//
//
//            /////////////// TABLE EXPERIMENTATION ////////////////////
////        activeDirectoryField.add(activeDirectoryTable);
////        profitField.add(profitTable);
////        cleverField.add(cleverTable);
//            /////////////// TABLE EXPERIMENT END ////////////////////
//
//        }
//
//
//        TableModel myModel = new TableModel() {
//
//
//
//            @Override
//            public int getRowCount() {
//                return 0;
//            }
//
//            @Override
//            public int getColumnCount() {
//                return 0;
//            }
//
//            @Override
//            public String getColumnName(int columnIndex) {
//                return null;
//            }
//
//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                return null;
//            }
//
//            @Override
//            public boolean isCellEditable(int rowIndex, int columnIndex) {
//                return false;
//            }
//
//            @Override
//            public Object getValueAt(int rowIndex, int columnIndex) {
//                return null;
//            }
//
//            @Override
//            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//
//            }
//
//            @Override
//            public void addTableModelListener(TableModelListener l) {
//
//            }
//
//            @Override
//            public void removeTableModelListener(TableModelListener l) {
//
//            }
//        };
//
//
//    }
//
//}
