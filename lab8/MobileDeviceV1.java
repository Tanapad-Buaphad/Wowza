package buaphad.tanapad.lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import buaphad.tanapad.lab8.MySimpleWindow;

public class MobileDeviceV1 extends MySimpleWindow {

    protected JTextField deviceField, brandField, priceField;
    protected JPanel inforPanel, radioPanel;
    protected JLabel deviceLabel, brandLabel, priceLabel, typeLabel;
    protected JRadioButton smartRadio, tabletRadio;

    public MobileDeviceV1(String title){
    super(title);
    }

    public void addComponents(Container contentPane) {
        super.addComponents(contentPane);

        inforPanel = new JPanel(new GridLayout(4,2));
        deviceLabel = new JLabel("Device Name:");
        deviceField = new JTextField(15);
        inforPanel.add(deviceLabel);
        inforPanel.add(deviceField);

        brandLabel = new JLabel("Brand:");
        brandField = new JTextField(15);
        inforPanel.add(brandLabel);
        inforPanel.add(brandField);

        priceLabel = new JLabel("Price:");
        priceField = new JTextField(15);
        inforPanel.add(priceLabel);
        inforPanel.add(priceField);

        
        typeLabel = new JLabel("Type:");
        radioPanel = new JPanel();
        smartRadio = new JRadioButton("Smartphone", true);
        tabletRadio = new JRadioButton("Tablet");
        inforPanel.add(typeLabel);
        radioPanel.add(smartRadio);
        radioPanel.add(tabletRadio);
        inforPanel.add(radioPanel);

        contentPane.setLayout(new BorderLayout());
        contentPane.add(inforPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

    }

    public static void createAndShowGUI() {
        MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");
        JPanel panel = new JPanel();
        mdv1.addComponents(panel);
        mdv1.add(panel);
        mdv1.setFrameFeatures();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
         public void run() {
             createAndShowGUI();
         }
        }); 
     }
}
