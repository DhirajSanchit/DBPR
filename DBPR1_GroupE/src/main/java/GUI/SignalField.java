package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SignalField extends Field{

    private Field signalField;
    private JTable signalTable;
    private GridBagConstraints gbc;
    private JScrollPane sgnScrollPane;
    private DefaultTableModel model;


    public SignalField(){

        /** Border voor context en layoutmanager voor component spacing**/
        this.createBorder("Signalen");
        setLayout(new GridBagLayout());

        /** GridBagConstrains om compononts te manipuleren**/
        gbc = new GridBagConstraints();
        model = new DefaultTableModel();
        model.setColumnCount(5);
        model.setRowCount(1);

        /** Instanties van de benodigde velden **/
        signalField = new Field();
        signalTable = new JTable(model);
        sgnScrollPane = new JScrollPane(signalTable,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        signalField.setLayout(new GridBagLayout());

        signalTable.setBackground(Color.ORANGE);
        signalTable.setEnabled(false);
        signalTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        signalTable.setFillsViewportHeight(true);

        /** Start toevoegen Jcomponents **/
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        signalField.add(signalTable.getTableHeader(), gbc);

        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        signalField.add(sgnScrollPane, gbc);


        ///////// Signals////////
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(signalField, gbc);

        signalTable.setBackground(Color.ORANGE);
        signalTable.setEnabled(false);
        signalTable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        signalTable.setFillsViewportHeight(true);
    }

    /**
     *
     *         cleverField.setBackground(Color.GREEN);
     *         cleverField.createBorder("Clever-AD  ");
     *         cleverField.setLayout(new GridBagLayout());
     *
     *         gbc.fill = GridBagConstraints.BOTH;
     *         gbc.anchor = GridBagConstraints.NORTH;
     *         gbc.gridx = 0;
     *         gbc.gridy = 0;
     *         cleverField.add(cleverTable.getTableHeader(), gbc);
     *         gbc.anchor = GridBagConstraints.NORTH;
     *         gbc.gridx = 0;
     *         gbc.gridy = 1;
     *         cleverField.add(clvrScrollPane, gbc);
     *
     *
     *         gbc.anchor = GridBagConstraints.NORTHWEST;;
     *         //gbc.insets = insets;
     *         gbc.fill = GridBagConstraints.BOTH;
     *         gbc.gridx = 0;
     *         gbc.gridy = 3;
     *         add(cleverField, gbc);
     */


    public Field getSignalField() {
        return signalField;
    }

    public void setSignalField(Field signalField) {
        this.signalField = signalField;
    }

    public JTable getSignalTable() {
        return signalTable;
    }

    public void setSignalTable(JTable signalTable) {
        this.signalTable = signalTable;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public JScrollPane getSgnScrollPane() {
        return sgnScrollPane;
    }

    public void setSgnScrollPane(JScrollPane sgnScrollPane) {
        this.sgnScrollPane = sgnScrollPane;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}
