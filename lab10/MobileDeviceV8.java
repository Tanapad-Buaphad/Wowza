package buaphad.tanapad.lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import buaphad.tanapad.lab9.MobileDeviceV7;

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {

    public MobileDeviceV8(String title) {
        super(title);
    }

    // Remove @Override since the superclass does not define this method
    public void addListeners() {
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            // Collect all user-selected data
            String deviceName = deviceField.getText();
            String brand = brandField.getText();
            String price = priceField.getText();
            
            // Get selected type
            String type = smartRadio.isSelected() ? "Smartphone" : "Tablet";
            
            // Get selected OS
            String os = (String) operating.getSelectedItem();

            // Get features from text area
            String features = featuretxtArea.getText();

            // Get available vendors
            String availableAt = (String) devAvalable.getSelectedValue();

            // Get rating
            int rating = ratingSlider.getValue();

            // Format message
            String message = String.format(
                "Device Name: %s\nBrand: %s\nPrice: %s\nType: %s\nOperating System: %s\nFeatures:\n%s\nAvailable at: %s\nRating: %d",
                deviceName, brand, price, type, os, features, availableAt, rating
            );

            // Show information dialog
            JOptionPane.showMessageDialog(this, message, "Device Information", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == cancelButton) {
            // Reset all input fields
            deviceField.setText("");
            brandField.setText("");
            priceField.setText("");
            featuretxtArea.setText("");
            smartRadio.setSelected(true);
            operating.setSelectedIndex(0);
            devAvalable.clearSelection();
            ratingSlider.setValue(5);
        }
    }

    public static void createAndShowGUI() {
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");
        JPanel panel = new JPanel();
        mdv8.addComponents(panel);
        mdv8.setContentPane(panel);
        mdv8.addMenus();
        mdv8.addListeners(); // Add event listeners
        mdv8.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
