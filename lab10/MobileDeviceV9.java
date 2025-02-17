package buaphad.tanapad.lab10;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MobileDeviceV9 extends MobileDeviceV8 implements ActionListener {

    protected JFileChooser fc;
    protected Font smallFont = new Font("",Font.PLAIN,10) ,
                    mediemFont = new Font("Arial", Font.PLAIN, 14) ,
                    largeFont = new Font("Arial", Font.PLAIN, 18) ,
                    extraLargeFont = new Font("Arial", Font.PLAIN, 22) ,
                        font1Font = new Font("Serif", Font.PLAIN, 14) , 
                        font2Font = new Font("SansSerif", Font.PLAIN, 14) , 
                        font3Font = new Font("Monospaced", Font.PLAIN, 14);

    public MobileDeviceV9(String title) {
        super(title);
    }

    public void addListeners() {
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        newF.addActionListener(this);
        openF.addActionListener(this);
        saveF.addActionListener(this);
        exitF.addActionListener(this);
        smallSize.addActionListener(this);
        mediumSize.addActionListener(this);
        largeSize.addActionListener(this);
        extraLargeSize.addActionListener(this);
        blackColor.addActionListener(this);
        redColor.addActionListener(this);
        greenColor.addActionListener(this);
        blueColor.addActionListener(this);
        font1.addActionListener(this);
        font2.addActionListener(this);
        font3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        fc = new JFileChooser();

        if (e.getSource() == newF) {
            deviceField.setText("");
            brandField.setText("");
            priceField.setText("");
            featuretxtArea.setText("");
            smartRadio.setSelected(true);
            operating.setSelectedIndex(0);
            devAvalable.clearSelection();
            ratingSlider.setValue(5);
        }else if (e.getSource() == openF) {
            int returnValue = fc.showOpenDialog(MobileDeviceV9.this);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                JOptionPane.showMessageDialog(this,"Open: " + file.getName());
            }
        }else if (e.getSource() == saveF) {
            int returnValue = fc.showSaveDialog(MobileDeviceV9.this);
            if(returnValue == JFileChooser.APPROVE_OPTION);
                File file = fc.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Data is saved to " + file.getName() + " successfully");
        }else if (e.getSource() == exitF) {
            System.exit(0);
        }
        
        else if (e.getSource() == smallSize) {
            deviceField.setFont(smallFont);
            brandField.setFont(smallFont);
            priceField.setFont(smallFont);
            featuretxtArea.setFont(smallFont);
        }else if (e.getSource() == mediumSize) {
            deviceField.setFont(mediemFont);
            brandField.setFont(mediemFont);
            priceField.setFont(mediemFont);
            featuretxtArea.setFont(mediemFont);
        }else if (e.getSource() == largeSize) {
            deviceField.setFont(largeFont);
            brandField.setFont(largeFont);
            priceField.setFont(largeFont);
            featuretxtArea.setFont(largeFont);
        }else if (e.getSource() == extraLargeSize) {
            deviceField.setFont(extraLargeFont);
            brandField.setFont(extraLargeFont);
            priceField.setFont(extraLargeFont);
            featuretxtArea.setFont(extraLargeFont);
        }
        
        else if (e.getSource() == blackColor) {
            deviceField.setForeground(Color.BLACK);
            brandField.setForeground(Color.BLACK);
            priceField.setForeground(Color.BLACK);
            featuretxtArea.setForeground(Color.BLACK);
        }else if (e.getSource() == redColor) {
            deviceField.setForeground(Color.RED);
            brandField.setForeground(Color.RED);
            priceField.setForeground(Color.RED);
            featuretxtArea.setForeground(Color.RED);
        }else if (e.getSource() == greenColor) {
            deviceField.setForeground(Color.GREEN);
            brandField.setForeground(Color.GREEN);
            priceField.setForeground(Color.GREEN);
            featuretxtArea.setForeground(Color.GREEN);
        }else if (e.getSource() == blueColor) {
            deviceField.setForeground(Color.BLUE);
            brandField.setForeground(Color.BLUE);
            priceField.setForeground(Color.BLUE);
            featuretxtArea.setForeground(Color.BLUE);
        }

        else if (e.getSource() == font1) {
            deviceField.setFont(font1Font);
            brandField.setFont(font1Font);
            priceField.setFont(font1Font);
            featuretxtArea.setFont(font1Font);
        }else if (e.getSource() == font2) {
            deviceField.setFont(font2Font);
            brandField.setFont(font2Font);
            priceField.setFont(font2Font);
            featuretxtArea.setFont(font2Font);
        }else if (e.getSource() == font3) {
            deviceField.setFont(font3Font);
            brandField.setFont(font3Font);
            priceField.setFont(font3Font);
            featuretxtArea.setFont(font3Font);
        }
    }

    public static void createAndShowGUI() {
        MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile Device V9");
        JPanel panel = new JPanel();
        mdv9.addComponents(panel);
        mdv9.setContentPane(panel);
        mdv9.addMenus();
        mdv9.addListeners(); // Add event listeners
        mdv9.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
