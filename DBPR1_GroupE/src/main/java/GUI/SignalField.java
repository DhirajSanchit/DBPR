package GUI;

import javax.swing.*;
import java.awt.*;

public class SignalField extends Field{




    private Field signalField;
    private JList signalList;
    private GridBagConstraints gbc;


    public SignalField(){

        signalField = new Field();
        signalList = new JList();
        gbc = new GridBagConstraints();

        /** dimensions for the size **/
        Dimension dim = getPreferredSize();
        dim.width = 300;
        dim.height = 325;
        setPreferredSize(dim);



        ///////// Signals/////////
        signalField.createBorder("Signalen");
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.weightx = 5;
//        gbc.weighty = 5;
          gbc.insets = new Insets(5, 5, 5, 5);
//        gbc.fill = GridBagConstraints.FIRST_LINE_START;
        this.setBackground(Color.RED);
        add(new JLabel("Signalthing"), gbc);



    }
}
