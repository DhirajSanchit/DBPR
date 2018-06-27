package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SignalField extends Field{

    private Field signalField;
    private JTable signalList;
    private GridBagConstraints gbc;


    public SignalField(){

        /** Border voor context en layoutmanager voor component spacing**/
        this.createBorder("Signalen");
        setLayout(new GridBagLayout());

        /** GridBagConstrains om compononts te manipuleren**/
        gbc = new GridBagConstraints();

        /** Instanties van de benodigde velden **/
        signalField = new Field();
        signalList = new JTable(1,2);
        signalField.setLayout(new GridBagLayout());
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        signalField.add(signalList, gbc);

        ///////// Signals////////
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        //signalField.add(signalList);
        add(new JScrollPane(signalField), gbc);

        signalList.setBackground(Color.ORANGE);
        signalList.setEnabled(false);
    }
}
