package buaphad.tanapad.lab12;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FileChooserUI;

import buaphad.tanapad.lab10.MobileDeviceV11;
import buaphad.tanapad.lab8.MobileDeviceV1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class MobileDeviceV12 extends MobileDeviceV11 {

    public MobileDeviceV12(String title) {
        super(title);
    }

    public void addListeners() {
        super.addListeners();
        deviceField.addActionListener(this);
        brandField.addActionListener(this);
        priceField.addActionListener(this);
    }

    public void handleNormalTextField(JTextField tf, JComponent nextComponent) {
        deviceField.setName(" Device Name");
        brandField.setName(" Brand");
        priceField.setName(" Price");
        if (tf.getText() == null || tf.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Please enter some data in" + tf.getName(), "Message", JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, tf.getName() + "is change to " + tf.getText(), "Message", JOptionPane.INFORMATION_MESSAGE);
            nextComponent.setEnabled(true);
        }
    }

    public void handlePosNumTextField(JTextField tf, JComponent nextComponent) {
        priceField.setName(" Price");
        try {
            int priceFieldInt = Integer.parseInt(tf.getText());
    
            if (priceFieldInt < 0) {
                JOptionPane.showMessageDialog(this, "Price must be a positive number in " + tf.getName() + ".", "Message", JOptionPane.INFORMATION_MESSAGE);
                tf.requestFocusInWindow();
                nextComponent.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, tf.getName() + "is change to " + tf.getText(), "Message", JOptionPane.INFORMATION_MESSAGE);
                nextComponent.setEnabled(true);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number in " + tf.getName() + ".", "Message", JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
        }
        
    }

    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object srcObject = e.getSource();
        if (srcObject == deviceField) {
            handleNormalTextField(deviceField, brandField);
        } else if (srcObject == brandField) {
            handleNormalTextField(brandField, priceField);
        } else if (srcObject == priceField) {
            handlePosNumTextField(priceField, operating);
        }
    }

    public static void createAndShowGUI() {
        MobileDeviceV12 mdv12 = new MobileDeviceV12("Mobile Device V10");
        JPanel panel = new JPanel();
        mdv12.addComponents(panel);
        mdv12.setContentPane(panel);
        mdv12.addMenus();
        mdv12.addListeners(); // Add event listeners
        mdv12.enableKeyBoard();
        mdv12.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

}
