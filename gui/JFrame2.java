package buaphad.tanapad.exercises.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JFrame2 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Component Test");
        JPanel panel = new JPanel();
        window.add(panel);
        window.setContentPane(panel);
        JButton button = new JButton("Submit");
        panel.add(button);
        JButton test = new JButton("Submit");
        panel.add(test);


        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
