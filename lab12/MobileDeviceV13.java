package buaphad.tanapad.lab12;

import buaphad.tanapad.lab7.MobileDevice;  // Added import for the MobileDevice abstract class
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class MobileDeviceV13 extends MobileDeviceV12 implements ActionListener {

    // New buttons for adding and displaying devices
    protected JButton addButton;
    protected JButton displayButton;

    // List to store devices
    protected ArrayList<MobileDevice> deviceList;

    public MobileDeviceV13(String title) {
        super(title);
        deviceList = new ArrayList<>();
    }

    @Override
    public void addComponents(Container contentPane) {
        super.addComponents(contentPane);


        addButton = new JButton("Add");
        displayButton = new JButton("Display");
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);
    }


    @Override
    public void addListeners() {
        super.addListeners();
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
    }

    /**
     * Handles the new "Add" and "Display" buttons, or delegates other actions to the superclass.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == addButton) {
            handleAddButton();
        } else if (src == displayButton) {
            handleDisplayButton();
        } else {
            super.actionPerformed(e);
        }
    }

    /**
     * Reads input from deviceField, brandField, and priceField.
     */
    public void handleAddButton() {
        String name = deviceField.getText().trim();
        String brand = brandField.getText().trim();
        String priceText = priceField.getText().trim();

        // Check which radio button is selected
        String type = smartRadio.isSelected() ? "Smartphone" : "Tablet";

        // Basic validation
        if (name.isEmpty() || brand.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please fill in Device Name, Brand, and Price",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceText);
            if (price < 0) {
                JOptionPane.showMessageDialog(this,
                    "Price must be a positive number",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Invalid price format",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new device object
        MobileDevice newDevice = new SimpleDevice(type, name, brand, price);
        deviceList.add(newDevice);

        // Confirmation
        JOptionPane.showMessageDialog(this,
            type + " \"" + name + "\" is added.",
            "Info", JOptionPane.INFORMATION_MESSAGE);

        // Optionally clear the fields
        deviceField.setText("");
        brandField.setText("");
        priceField.setText("");
    }

    /**
     * Displays the current list of devices in a dialog.
     */
    public void handleDisplayButton() {
        if (deviceList.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No devices to display.",
                "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (MobileDevice device : deviceList) {
            sb.append(device.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(),
            "Device List", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * SimpleDevice is a basic implementation of MobileDevice, storing type, name, brand, and price.
     */
    public static class SimpleDevice extends MobileDevice {
        private String type;
        private String name;
        private String brand;
        private double price;

        public SimpleDevice(String type, String name, String brand, double price) {
            this.type = type;
            this.name = name;
            this.brand = brand;
            this.price = price;
        }

        @Override
        public String toString() {
            return type + " " + name + " (" + brand + ") " + price + " Baht.";
        }
    }

    public static void createAndShowGUI() {
        MobileDeviceV13 mdv13 = new MobileDeviceV13("Mobile Device V13");
        JPanel panel = new JPanel(new BorderLayout());
        mdv13.addComponents(panel);
        mdv13.setContentPane(panel);
        mdv13.addMenus();
        mdv13.addListeners();
        mdv13.enableKeyBoard();
        mdv13.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MobileDeviceV13::createAndShowGUI);
    }
}
