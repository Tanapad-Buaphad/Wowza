
package buaphad.tanapad.lab9;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV5 extends MobileDeviceV4 {

    protected JPanel superExtraPanel , devAvailablePanel , ratePanel;
    protected JLabel devAvailableLabel , rateLabel;
    protected JSlider ratingSlider;
    protected JList devAvalable;
    protected String[] devAvalableList = {"AIS", "True", "DTAC", "Shopee"};


    public MobileDeviceV5(String title) {
        super(title);
    }

    @Override
    public void addComponents(Container contentPane) {

        // Reuse existing components
        super.addComponents(contentPane);

        devAvailablePanel = new JPanel(new GridLayout(0,2));
        devAvailableLabel = new JLabel("The device is available at:");
        devAvalable = new JList<>(devAvalableList);
        devAvalable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        devAvailablePanel.add(devAvailableLabel);
        devAvailablePanel.add(devAvalable);

        ratePanel = new JPanel(new GridLayout(2,1));
        rateLabel = new JLabel("Rate the device (0–10):");
        ratingSlider = new JSlider(0, 10, 5);
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);
        ratePanel.add(rateLabel);
        ratePanel.add(ratingSlider);

        superExtraPanel = new JPanel();
        superExtraPanel.setLayout(new BoxLayout(superExtraPanel, BoxLayout.Y_AXIS));
        superExtraPanel.add(extraPanel);
        superExtraPanel.add(devAvailablePanel);
        superExtraPanel.add(ratePanel);        

        contentPane.add(superExtraPanel, BorderLayout.CENTER);
    }

    public static void createAndShowGUI() {
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
        JPanel panel = new JPanel();
        mdv5.addComponents(panel);
        mdv5.add(panel);
        mdv5.addMenus();
        mdv5.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}