package buaphad.tanapad.exercises.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

import javax.swing.*;
import javax.swing.event.*;



public class GUI3E extends GUI1 {

    public GUI3E(String title) {
        super(title);
    }


    public void addComponents(Container contentPane) {
        super.addComponents(contentPane);
        JLabel.setText("Name");
        contentPane.add(new JTextField("tanapad"));
    }

    public static void createAndShowGUI() {
        GUI3E window = new GUI3E("673040622-5");
        JPanel panel = new JPanel();
        window.addComponents(panel);
        window.setContentPane(panel);
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    createAndShowGUI();
                }
        });
    }    
}
