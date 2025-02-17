package buaphad.tanapad.lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class MySimpleWindow extends JFrame {

    protected JButton cancelButton, okButton;
    protected JPanel mainPanel , buttonPanel;

    public MySimpleWindow(String title) {
        super(title);
    }
    
    public void addComponents(Container contentPane) {
        buttonPanel = new JPanel();
        cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);
        okButton = new JButton("OK");
        buttonPanel.add(okButton);

        contentPane.setLayout(new BorderLayout());
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setFrameFeatures() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public static void createAndShowGUI() {
        MySimpleWindow msw =  new MySimpleWindow("My Simple Window");
        JPanel panel = new JPanel();
        msw.addComponents(panel);
        msw.add(panel);
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI();
        }
       }); 
    }
}

