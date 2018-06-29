package GUI;

import javax.swing.*;
import java.awt.*;

public class NotificationField extends Field{

    private GridBagConstraints gbc;
    private JTextArea notifications;


    public NotificationField(){
        setLayout(new GridBagLayout());

        this.createBorder("Notifications");
        gbc = new GridBagConstraints();
        notifications = new JTextArea();
        notifications.setEditable(false);
        notifications.setLineWrap(true);
        notifications.setSize(1,1);

        gbc.weightx =1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(notifications), gbc);
    }





    public JTextArea getNotifications() {
        //Returns the TextPane in notifications
        return notifications;
    }

    public void setNotifications(JTextArea notifications) {
        this.notifications = notifications;
    }

    public void updateNotifications(String notification){
        getNotifications().append(notification);
    }


}
