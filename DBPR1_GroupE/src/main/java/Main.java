import GUI.Application;
import GUI.Field;

import javax.swing.*;


public class Main {

    public static void main (String[] args) {
        Application application = new Application ();
        application.start();
        application.startConnection();
        application.stopConnection();

    }
}
