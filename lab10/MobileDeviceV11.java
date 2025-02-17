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
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;


public class MobileDeviceV11 extends MobileDeviceV10 implements ActionListener  {

    

    public MobileDeviceV11(String title) {
        super(title);
    }

    public void addListeners() {
        super.addListeners();
        smartRadio.addActionListener(this);
        tabletRadio.addActionListener(this);
        fileMenu.addActionListener(this);
        newF.addActionListener(this);
        openF.addActionListener(this);
        saveF.addActionListener(this);
        exitF.addActionListener(this);
    }

    public void addComponents(Container contentPane) {
        super.addComponents(contentPane);
    }

    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (e.getSource() == smartRadio) {
            JOptionPane.showMessageDialog(this, "Smartphone is selected" , "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getSource() == tabletRadio) {
            JOptionPane.showMessageDialog(this, "Tablet is selected" , "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        }
    
    public void enableKeyBoard() {
        fileMenu.setMnemonic(KeyEvent.VK_F);
        newF.setMnemonic(KeyEvent.VK_N);
        newF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        openF.setMnemonic(KeyEvent.VK_O);
        openF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        saveF.setMnemonic(KeyEvent.VK_S);
        saveF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        exitF.setMnemonic(KeyEvent.VK_Q);
        exitF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }
    

    public static void createAndShowGUI() {
        MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V10");
        JPanel panel = new JPanel();
        mdv11.addComponents(panel);
        mdv11.setContentPane(panel);
        mdv11.addMenus();
        mdv11.addListeners(); // Add event listeners
        mdv11.enableKeyBoard();
        mdv11.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
