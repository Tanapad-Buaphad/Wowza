package buaphad.tanapad.lab11;

import javax.swing.*;
import javax.swing.border.Border;

import buaphad.tanapad.lab11.MobileDeviceComplete;
import buaphad.tanapad.lab11.ReadImage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {

    public MobileDeviceCompleteV2(String title) {
        super(title);
    }

public void addListeners() {
    deviceNameField.addActionListener(this);
    brandField.addActionListener(this);
    priceField.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == deviceNameField) {
        JOptionPane.showMessageDialog(this, "You pressed Enter in Device Name field: " + deviceNameField.getText(),
                "Notification", JOptionPane.INFORMATION_MESSAGE);
    } else if (e.getSource() == brandField) {
        JOptionPane.showMessageDialog(this, "Brand field says: " + brandField.getText(),
                "Notification", JOptionPane.INFORMATION_MESSAGE);
    } else if (e.getSource() == priceField) {
        JOptionPane.showMessageDialog(this, "Price entered: " + priceField.getText(),
                "Notification", JOptionPane.INFORMATION_MESSAGE);
    }
}

    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 window = new MobileDeviceCompleteV2("Mobile Device CompleteV2");
        window.addComponents();
        window.addMenus();
        window.addListeners();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }));
    }
}
