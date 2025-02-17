package buaphad.tanapad.lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import buaphad.tanapad.lab8.MySimpleWindow;

public class MobileDeviceV2 extends MobileDeviceV1 {

    protected JPanel extraPanel;
    protected JComboBox<String> operating;
    protected JTextArea featuretxtArea;
    protected JLabel  opSystemLabel, featureLabel;

    public MobileDeviceV2(String title){
    super(title);
    }

    public void addComponents(Container contentPane) {
        super.addComponents(contentPane);

        extraPanel = new JPanel(new GridLayout(2,2));

        opSystemLabel = new JLabel("Operating Systme:");
        operating = new JComboBox<>();
        operating.addItem("Android");
        operating.addItem("iOS");
        extraPanel.add(opSystemLabel);
        extraPanel.add(operating);

        featureLabel = new JLabel("Features:");
        featuretxtArea = new JTextArea(3,25);
        extraPanel.add(featureLabel);
        extraPanel.add(featuretxtArea);

        contentPane.add(extraPanel, BorderLayout.CENTER);
        

    }

    public static void createAndShowGUI() {
        MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");
        JPanel panel = new JPanel();
        mdv2.addComponents(panel);
        mdv2.add(panel);
        mdv2.setFrameFeatures();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
         public void run() {
             createAndShowGUI();
         }
        }); 
     }
}
