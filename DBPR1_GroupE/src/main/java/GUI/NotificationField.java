package GUI;

import javax.swing.*;
import java.awt.*;

public class NotificationField extends Field{

    private GridBagConstraints gbc;
    private JTextPane notifications;


    public NotificationField(){

//        Dimension dim = getPreferredSize();
//        dim.width = 900;
//        dim.height = 200;
//        setPreferredSize(dim);



        this.createBorder("Notifications");
        gbc = new GridBagConstraints();
        notifications = new JTextPane();
        add(new JLabel("this is a notifcation"));

        gbc.fill = GridBagConstraints.FIRST_LINE_START;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(notifications, gbc);

    }
}
