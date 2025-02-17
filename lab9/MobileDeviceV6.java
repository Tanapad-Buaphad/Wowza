package buaphad.tanapad.lab9;

import java.awt.*;
import javax.swing.*;


public class MobileDeviceV6 extends MobileDeviceV5 {

    // Custom colors
    protected final Color DARK_BLUE = Color.decode("#000080");
    protected final Color DARK_GREEN = Color.decode("#006400");
    protected final Color LIGHT_YELLOW = Color.decode("#fffccc");

    public MobileDeviceV6(String title) {
        super(title);
    }

    public void addComponents(Container contentPane) {
        super.addComponents(contentPane);
        

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        // Applying font and color settings correctly
        deviceLabel.setFont(labelFont);
        deviceLabel.setForeground(DARK_BLUE);
        deviceField.setBackground(Color.LIGHT_GRAY);

        brandLabel.setFont(labelFont);
        brandLabel.setForeground(DARK_BLUE);
        brandField.setBackground(Color.LIGHT_GRAY);

        priceLabel.setFont(labelFont);
        priceLabel.setForeground(DARK_BLUE);
        priceField.setBackground(Color.LIGHT_GRAY);

        typeLabel.setFont(labelFont);
        typeLabel.setForeground(DARK_BLUE);

        opSystemLabel.setFont(labelFont);
        opSystemLabel.setForeground(DARK_BLUE);

        featureLabel.setFont(labelFont);
        featureLabel.setForeground(DARK_BLUE);
        featuretxtArea.setBackground(LIGHT_YELLOW);

        devAvailableLabel.setFont(labelFont);
        devAvailableLabel.setForeground(DARK_BLUE);
        devAvalable.setBackground(Color.LIGHT_GRAY);
        devAvalable.setForeground(DARK_GREEN);

        rateLabel.setFont(labelFont);
        rateLabel.setForeground(DARK_BLUE);

        cancelButton.setForeground(Color.RED);
        okButton.setForeground(Color.GREEN);
    }

    public static void createAndShowGUI() {
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");
        JPanel panel = new JPanel();
        
        mdv6.addComponents(panel);
        mdv6.setContentPane(panel); // Ensure the panel is set as the main content pane
        mdv6.addMenus();
        mdv6.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
