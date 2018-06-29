package GUI;

import Controllers.StringListener;
import DB.Database;
import DB.Signaal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ButtonField extends Field implements ActionListener {

    private JButton showSignalsBtn;
    private JButton saveSignalBtn;
    private JButton exportBtn;
    private GridBagConstraints gbc;
    private SignalField signals;
    private DataBaseField abb;

    private Database ldhdatabase;

    private StringListener textListener;

    public ButtonField(SignalField signals, DataBaseField abb) throws SQLException {
        this.abb = abb;
        this.signals = signals;
        this.ldhdatabase = new Database();
        ldhdatabase.fill();
//        ldhdatabase.fill(ldhdatabase.getSignaalPrLijst());
//        ldhdatabase.fill(ldhdatabase.getSignaalClLijst());
        ldhdatabase.initSignaalList();

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
                getSignals();

            }
        }
        if(clicked == saveSignalBtn) {
            if (textListener != null) {
                //System.out.println("saveSignalBtn Clicked");
                textListener.textEmitted("Opgeslagen \n");
            }
        }
        if(clicked == exportBtn) {
            try {
                exportToCSV();
                if (textListener != null) {
                    textListener.textEmitted("Bestand word geëxporteerd...\n");
                }
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(ButtonField.class.getName()).log(Level.SEVERE, null, ex);
                textListener.textEmitted("Bestand niet gevonden\n");
            }
            textListener.textEmitted("Bestand  geëxporteerd!\n");
        }
    }

    public void getSignals(){
        textListener.textEmitted("Signalen worden opgehaald...\n");
        for(Signaal signaal : ldhdatabase.getList(ldhdatabase.getSignaalADLijst())) {
            abb.addSignaal(abb.getAdmodel(), new Object[] {signaal.getCode(),signaal.getEmployeeusername(),signaal.getUsername_pre2000()});
            signals.addSignaal(new Object[] {signaal.getCode(),signaal.getEmployeeusername(),signaal.getUsername_pre2000()});
        }
        for(Signaal signaal : ldhdatabase.getList(ldhdatabase.getSignaalPrLijst())) {
            abb.addSignaal(abb.getPrmodel(), new Object[] {signaal.getCode(),signaal.getEmployeeusername(),signaal.getUsername_pre2000()});
           signals.addSignaal(new Object[] {signaal.getCode(),signaal.getEmployeeusername(),signaal.getUsername_pre2000()});

        }
        for(Signaal signaal : ldhdatabase.getList(ldhdatabase.getSignaalClLijst())) {
            abb.addSignaal(abb.getClmodel(), new Object[] {signaal.getCode(),signaal.getEmployeeusername(),signaal.getUsername_pre2000()});
            signals.addSignaal(new Object[] {signaal.getCode(),signaal.getEmployeeusername(),signaal.getUsername_pre2000()});
        }
        textListener.textEmitted("Signalen opgehaald\n");
    }

    private void exportToCSV() throws FileNotFoundException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();

        File file = new File("Signalen_" + dateFormat.format(date) + ".csv");
        PrintWriter pw = new PrintWriter(file);
        StringBuilder sb = new StringBuilder();

        String ColumnNamesList = "ID, code, EmployeeUsername, username_pre2000, afkomst,";

        sb.append(ColumnNamesList);

        sb.append('\n');

        for (int i = 0; i < ldhdatabase.getList().size(); i++) {
            sb.append(ldhdatabase.getList().get(i).getTabelid());
            sb.append(',');
            sb.append(ldhdatabase.getList().get(i).getCode());
            sb.append(',');
            sb.append(ldhdatabase.getList().get(i).getEmployeeusername());
            sb.append(',');
            sb.append(ldhdatabase.getList().get(i).getUsername_pre2000());
            sb.append(',');
            sb.append(ldhdatabase.getList().get(i).getAfkomstVan());
            sb.append('\n');
        }

        pw.write(sb.toString());
        pw.close();
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
