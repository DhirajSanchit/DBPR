package GUI;

import Controllers.StringListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonField extends Field implements ActionListener {

    private JButton showSignalsBtn;
    private JButton saveSignalBtn;
    private JButton exportBtn;
    private GridBagConstraints gbc;

     private StringListener textListener;

    public ButtonField(){

//        Dimension dim = getPreferredSize();
//        dim.width = 1200;
//        setPreferredSize(dim);

        this.createBorder("Buttons");
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        //GridBag X coordinator
        int gbcX = 0;

        //Insets for adding space between components
        Insets insets = new Insets(5,10,5,10);

        showSignalsBtn = new JButton("Signalen Tonen");
        saveSignalBtn = new JButton("Signalen Opslaan");
        exportBtn = new JButton("Exporteren naar CSV");
        NotificationField notifications = new NotificationField();

        showSignalsBtn.addActionListener(this);
        saveSignalBtn.addActionListener(this);
        exportBtn.addActionListener(this);

        //GridBagLayout constrains for the whole button field
        gbc.weightx = 0.3;
        gbc.weighty = 0.3;
        gbc.insets = insets;


        ///////// Show Signals Button /////////
        gbc.gridx = gbcX;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(showSignalsBtn, gbc);

        gbcX++;

        ///////// Save Signals Button /////////
        gbc.gridx = gbcX;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(saveSignalBtn, gbc);

        gbcX++;

        ///////// Export CSV Button /////////
        gbc.gridx = gbcX;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(exportBtn, gbc);

    }


    public void actionPerformed(ActionEvent e){
        JButton clicked = (JButton) e.getSource();
        if(clicked == showSignalsBtn){
            if (textListener != null) {
                //System.out.println("showSignalsBtn Clicked");
                textListener.textEmitted("showSignalsBtn Clicked \n");
            }
        }
        if(clicked == saveSignalBtn) {
            if (textListener != null) {
                //System.out.println("saveSignalBtn Clicked");
                textListener.textEmitted("saveSignalBtn Clicked \n");
            }
        }
        if(clicked == exportBtn) {
            if (textListener != null) {
                //System.out.println("exportBtn Clicked");
                exportToCSV();
            }
        }
    }

    private void exportToCSV() {
        
    }

    public void setStringListener(StringListener listener){
        this.textListener = listener;
    }

    public JButton getExportBtn() {
        return exportBtn;
    }

    public void setExportBtn(JButton exportBtn) {
        this.exportBtn = exportBtn;
    }

    public JButton getShowSignalsBtn() {
        return showSignalsBtn;
    }

    public void setShowSignalsBtn(JButton showSignalsBtn) {
        this.showSignalsBtn = showSignalsBtn;
    }

    public JButton getSaveSignalBtn() {
        return saveSignalBtn;
    }

    public void setSaveSignalBtn(JButton saveSignalBtn) {
        this.saveSignalBtn = saveSignalBtn;
    }

}
