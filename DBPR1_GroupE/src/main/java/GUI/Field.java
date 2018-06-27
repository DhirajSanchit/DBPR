package GUI;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {

    private GridBagConstraints gbc;
    private GridBagLayout gridBagLayout;


    void createBorder(String title){
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), title));


        }
    }

