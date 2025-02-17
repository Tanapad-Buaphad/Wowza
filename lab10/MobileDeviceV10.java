package buaphad.tanapad.lab10;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FileChooserUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;


public class MobileDeviceV10 extends MobileDeviceV9 implements ActionListener ,  ListSelectionListener , ChangeListener {

    

    public MobileDeviceV10(String title) {
        super(title);
    }

    public void addListeners() {
        super.addListeners();
        operating.addActionListener(this);
        devAvalable.addListSelectionListener(this);  // Vendor List Listener
        ratingSlider.addChangeListener(this);  // Rating Slider Listener
    }

    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (e.getSource() == operating) {
            String selectedOS = (String) operating.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected Operating System : " + selectedOS,
                    "OS Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // Handle JList (Vendor selection) changes
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) { // Ensure it's the final selection
            java.util.List<String> selectedVendors = devAvalable.getSelectedValuesList();
            String vendors = String.join(", ", selectedVendors);
            JOptionPane.showMessageDialog(this, "Device is available at: " + vendors,
                    "Vendor Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Handle JSlider (Rating changes)
    @Override
    public void stateChanged(ChangeEvent e) {
        if (!ratingSlider.getValueIsAdjusting()) { // Only trigger when adjustment is finished
            int rating = ratingSlider.getValue();
            JOptionPane.showMessageDialog(this, "New rating: " + rating,
                    "Rating Adjustment", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public static void createAndShowGUI() {
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");
        JPanel panel = new JPanel();
        mdv10.addComponents(panel);
        mdv10.setContentPane(panel);
        mdv10.addMenus();
        mdv10.addListeners(); // Add event listeners
        mdv10.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
