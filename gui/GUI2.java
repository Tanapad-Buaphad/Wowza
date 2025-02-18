package buaphad.tanapad.exercises.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

import javax.swing.*;
import javax.swing.event.*;



public class GUI2 extends GUI1 {

    public GUI2(String title) {
        super(title);
    }


    public void addComponents(Container contentPane) {

        contentPane.setLayout(new GridLayout(2,1));

        JPanel row1 = new JPanel(new FlowLayout());
        row1.add(new JLabel("Name"));
        row1.add(new JTextField("Tanapad"));

        JPanel row2 = new JPanel(new FlowLayout());
        row2.add(new JButton("Pizza"));
        row2.add(new JButton("Spaghetti"));
        row2.add(new JButton("Fried Chicken"));

        contentPane.add(row1);
        contentPane.add(row2);
    }

    public static void createAndShowGUI() {
        GUI2 window = new GUI2("673040622-5");
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
