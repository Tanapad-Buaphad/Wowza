package buaphad.tanapad.exercises.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;



public class GUI1 extends JFrame {

    protected JPanel nameJPanel;
    protected JLabel nametext;
    protected JButton pizza, friedchicken ,spaghetti;

    public GUI1(String title) {
        super(title);
    }

    public void setFrameFeatures() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void addComponents() {
        nameJPanel = new JPanel();
        nametext = new JLabel("Tanapad");
        pizza = new JButton("Pizza");
        friedchicken = new JButton("Fried Chicken");
        spaghetti = new JButton("Spaghetti");

        
        nameJPanel.add(nametext);
        nameJPanel.add(pizza);
        nameJPanel.add(friedchicken);
        nameJPanel.add(spaghetti);
    }

    public static void createAndShowGUI() {
        GUI1 window = new GUI1("673040622-5");
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
