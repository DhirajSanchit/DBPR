package GUI;

import Controllers.StringListener;
import DB.DBConnection;

import javax.swing.*;
import java.awt.*;

public class Display extends Field{

    private ButtonField buttons;
    private DataBaseField auditBlackBox;
    private BusinessRulesField businessRules;
    private SignalField signals;
    private NotificationField notfications;
    private GridBagConstraints gbc;


    public Display(){

        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        /** Hoofd display van de applicatie**/
        buttons = new ButtonField();
        auditBlackBox = new DataBaseField();
        businessRules = new BusinessRulesField();
        signals = new SignalField();
        notfications = new NotificationField();


        /** GridBagConstraints die ervoor zorgen dat de extra ruimte verminderd word tussen Velden **/
        gbc.weightx = 0.000001;
        gbc.weighty = 0.000001;
        Insets insets = new Insets(5,5,5,5);
        gbc.insets = insets;

        /** Knoppen **/
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(buttons, gbc);
        System.out.println("Buttons added!");

        /** Toevoeging van de de 3 Tabellen van Leger des Heils  **/

        gbc.weightx = 0.001;
        gbc.weighty = 0.001;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        add(auditBlackBox, gbc);
        System.out.println("auditblackbox added!");

        //Resizing van de WeightX en WeightY, zodat de Fields aan de rechterkant correct getoond worden.
        gbc.weightx = 0.001;
        gbc.weighty = 0.001;

        /** Toevoeging van de Business Rules **/
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1 ;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.fill = GridBagConstraints.BOTH;
        add(businessRules, gbc);
        System.out.println("Business Rules added!");

        /** Toevoeging van de Signalen **/
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.fill = GridBagConstraints.BOTH;
        add(signals, gbc);
        System.out.println("Signals added!");

        /** Toevoeging van de notificatie panel**/

        //Resizing van de opvulling van de cellen. Zorgt ervoor dat de Notificaties geen andere JComponents
        //opzij schuift. Weighty zorgt ervoor dat de grote van dit component verticaal iets groter is dan 1 cel.
        gbc.weightx = 1;
        gbc.weighty = 0.0001;

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.insets = new Insets(0,0,0,0);
        add(notfications, gbc);
        System.out.println("notificationpanel added!");

        buttons.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                notfications.updateNotifications(text);
            }
        });

        }



    public ButtonField getButtons() {
        return buttons;
    }

    public DataBaseField getAuditBlackBox() {
        return auditBlackBox;
    }

    public BusinessRulesField getBusinessRules() {
        return businessRules;
    }

    public SignalField getSignals() {
        return signals;
    }

    public NotificationField getNotfications() {
        return notfications;
    }

    public void setButtons(ButtonField buttons) {
        this.buttons = buttons;
    }

    public void setAuditBlackBox(DataBaseField auditBlackBox) {
        this.auditBlackBox = auditBlackBox;
    }

    public void setBusinessRules(BusinessRulesField businessRules) {
        this.businessRules = businessRules;
    }

    public void setSignals(SignalField signals) {
        this.signals = signals;
    }

    public void setNotfications(NotificationField notfications) {
        this.notfications = notfications;
    }

}


