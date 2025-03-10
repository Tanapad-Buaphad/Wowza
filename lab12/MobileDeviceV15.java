package buaphad.tanapad.lab12;

import buaphad.tanapad.lab7.MobileDevice; // Import your base MobileDevice class from lab7
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class MobileDeviceV15 extends MobileDeviceV14 implements ActionListener, Serializable {

    protected JMenuItem txtSave, binarySave;
    protected JMenu formatMenu;

    public MobileDeviceV15(String title) {
        super(title);
    }

    @Override
    public void addMenus() {
        super.addMenus();

        formatMenu = new JMenu("Format");
        txtSave = new JMenuItem("Text");
        binarySave = new JMenuItem("Binary");

        configMenu.add(formatMenu);
        formatMenu.add(txtSave);
        formatMenu.add(binarySave);
    }

    @Override
    public void addListeners() {
        super.addListeners();

    }



    public void handleMenuSave() {
    }

    /**
     * handleMenuOpen() opens an Open dialog, reads the file line by line,
     * reconstructs SimpleDevice objects, and updates deviceList.
     */
    public void handleMenuOpen() {
        super.handleMenuOpen();
    }

    /**
     * Main method to launch MobileDeviceV14.
     */
    public static void createAndShowGUI() {
        MobileDeviceV15 mdv15 = new MobileDeviceV15("Mobile Device V14");
        JPanel panel = new JPanel(new BorderLayout());
        mdv15.addComponents(panel);
        mdv15.setContentPane(panel);
        mdv15.addMenus();
        mdv15.addListeners();
        mdv15.enableKeyBoard();
        mdv15.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MobileDeviceV14::createAndShowGUI);
    }
}
