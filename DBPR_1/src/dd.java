import javax.swing.*;
import java.awt.event.*;

public class dd extends JFrame {
    private JPanel contentPane;
    private JButton startButton;
    private JButton buttonCancel;
    private JButton resetButton;
    private JButton printButton;
    private JPanel businessRulesField;
    private JLabel businessRulesLabel;
    private JTextPane businessRulesTA;
    private JList brRapportList;
    private JLabel rapportLabel;
    private JLabel applicationTitleLabel;
    private JPanel buttonsField;
    private JPanel databaseField;
    private JTextPane feedbackField;

    public dd() {
        setContentPane(contentPane);
        setVisible(true);
        getRootPane().setDefaultButton(startButton);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                feedbackField.setText("Connection started");
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                feedbackField.setText("Connection stopped");
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                feedbackField.setText("---");
                businessRulesTA.setText("---");
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

       // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        dd dialog = new dd();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
