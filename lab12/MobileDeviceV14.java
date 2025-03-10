package buaphad.tanapad.lab12;

import buaphad.tanapad.lab7.MobileDevice;  // Import your base MobileDevice class from lab7
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class MobileDeviceV14 extends MobileDeviceV13 implements ActionListener {

    protected JMenuItem txtSave , binarySave;
    protected JMenu formatMenu;
    
    public MobileDeviceV14(String title) {
        super(title);
    }

    @Override
    public void addMenus() {
        super.addMenus();
    }
    
    @Override
    public void addListeners() {
        super.addListeners();
        openF.addActionListener(this);
        saveF.addActionListener(this);
    }
    
    /**
     * Extend actionPerformed to handle file menu events.
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
     * handleMenuSave() opens a Save dialog and writes each device’s information,
     * as produced by SimpleDevice.toString(), to the selected file.
     */
    public void handleMenuSave() {
        JFileChooser fc = new JFileChooser();
        int option = fc.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                for (MobileDevice device : deviceList) {
                    writer.println(device.toString());
                }
                JOptionPane.showMessageDialog(this, "File saved successfully.",
                                              "Save", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(),
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * handleMenuOpen() opens an Open dialog, reads the file line by line,
     * reconstructs SimpleDevice objects, and updates deviceList.
     */
    public void handleMenuOpen() {
        JFileChooser fc = new JFileChooser();
        int option = fc.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Opening " + file.getAbsolutePath(),
                                          "Open", JOptionPane.INFORMATION_MESSAGE);
            deviceList.clear();
            try (Scanner scanner = new Scanner(new FileReader(file))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) continue;
                    // Expected format: "Smartphone <name> (<brand>) <price> Baht." 
                    // or "Tablet <name> (<brand>) <price> Baht."
                    String type;
                    if (line.startsWith("Smartphone"))
                        type = "Smartphone";
                    else if (line.startsWith("Tablet"))
                        type = "Tablet";
                    else
                        continue;
                    
                    String remaining = line.substring(type.length()).trim();
                    int openParen = remaining.indexOf('(');
                    int closeParen = remaining.indexOf(')');
                    if (openParen == -1 || closeParen == -1) continue;
                    String name = remaining.substring(0, openParen).trim();
                    String brand = remaining.substring(openParen + 1, closeParen).trim();
                    String after = remaining.substring(closeParen + 1).trim();
                    String[] parts = after.split(" ");
                    if (parts.length < 1) continue;
                    double price;
                    try {
                        price = Double.parseDouble(parts[0]);
                    } catch (NumberFormatException ex) {
                        continue;
                    }
                    MobileDevice device = new SimpleDevice(type, name, brand, price);
                    deviceList.add(device);
                }
                // Display the updated device list using the existing display method.
                handleDisplayButton();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage(),
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Main method to launch MobileDeviceV14.
     */
    public static void createAndShowGUI() {
        MobileDeviceV14 mdv14 = new MobileDeviceV14("Mobile Device V14");
        JPanel panel = new JPanel(new BorderLayout());
        mdv14.addComponents(panel);
        mdv14.setContentPane(panel);
        mdv14.addMenus();
        mdv14.addListeners();
        mdv14.enableKeyBoard();
        mdv14.setFrameFeatures();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MobileDeviceV14::createAndShowGUI);
    }
}
