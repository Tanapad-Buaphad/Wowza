package buaphad.tanapad.lab12;

import buaphad.tanapad.lab7.MobileDevice;  // Your base abstract MobileDevice
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class MobileDeviceV15 extends MobileDeviceV14 implements ActionListener {

    // Format menu components
    protected JMenu formatMenu;
    protected JCheckBoxMenuItem textFormat, binaryFormat;
    protected ButtonGroup formatGroup;

    public MobileDeviceV15(String title) {
        super(title);
    }
    
    @Override
    public void addMenus() {
        // Reuse existing menus from MobileDeviceV14
        super.addMenus();
        
        // Create the Format menu with Text and Binary options
        formatMenu = new JMenu("Format");
        textFormat = new JCheckBoxMenuItem("Text", true);
        binaryFormat = new JCheckBoxMenuItem("Binary", false);
        
        // Group them so only one is selected
        formatGroup = new ButtonGroup();
        formatGroup.add(textFormat);
        formatGroup.add(binaryFormat);
        
        // Add the Format menu to the configuration menu (assumed inherited as configMenu)
        configMenu.add(formatMenu);
        formatMenu.add(textFormat);
        formatMenu.add(binaryFormat);
    }
    
    @Override
    public void addListeners() {
        super.addListeners();
        textFormat.addActionListener(this);
        binaryFormat.addActionListener(this);
    }
    
    /**
     * Overrides actionPerformed to handle file menu actions.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == openF) {
            handleMenuOpen();
        } else if (src == saveF) {
            handleMenuSave();
        } else {
            super.actionPerformed(e);
        }
    }
    
    /**
     * Overrides handleMenuSave(). If Text format is selected, call the parent's
     * text-based saving method; otherwise, use binary serialization.
     */
    @Override
    public void handleMenuSave() {
        if (textFormat.isSelected()) {
            // Reuse parent's text-based file saving
            super.handleMenuSave();
            return;
        }
        // Binary saving using FileOutputStream and ObjectOutputStream
        JFileChooser fc = new JFileChooser();
        int option = fc.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(deviceList);
                JOptionPane.showMessageDialog(this,
                        "Binary file saved successfully at " + file.getAbsolutePath(),
                        "Save", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error saving binary file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Overrides handleMenuOpen(). If Text format is selected, call the parent's
     * text-based opening method; otherwise, use binary deserialization.
     */
    @Override
    public void handleMenuOpen() {
        if (textFormat.isSelected()) {
            // Reuse parent's text-based file opening
            super.handleMenuOpen();
            return;
        }
        // Binary loading using FileInputStream and ObjectInputStream
        JFileChooser fc = new JFileChooser();
        int option = fc.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            JOptionPane.showMessageDialog(this,
                    "Opening binary file from " + file.getAbsolutePath(),
                    "Open", JOptionPane.INFORMATION_MESSAGE);
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                if (obj instanceof ArrayList) {
                    @SuppressWarnings("unchecked")
                    ArrayList<MobileDevice> list = (ArrayList<MobileDevice>) obj;
                    deviceList = list;
                    handleDisplayButton();
                }
            } catch (IOException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error opening binary file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Inner SimpleDevice class implements Serializable for binary I/O.
     */
    public static class SimpleDevice extends MobileDevice implements Serializable {
        private static final long serialVersionUID = 1L;
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
        MobileDeviceV15 mdv15 = new MobileDeviceV15("Mobile Device V15");
        JPanel panel = new JPanel(new BorderLayout());
        mdv15.addComponents(panel);
        mdv15.setContentPane(panel);
        mdv15.addMenus();
        mdv15.addListeners();
        mdv15.enableKeyBoard();
        mdv15.setFrameFeatures();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MobileDeviceV15::createAndShowGUI);
    }
}
