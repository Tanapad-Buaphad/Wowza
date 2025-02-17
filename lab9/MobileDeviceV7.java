package buaphad.tanapad.lab9;

import java.awt.*;
import javax.swing.*;

public class MobileDeviceV7 extends MobileDeviceV6 {

    public MobileDeviceV7(String title) {
        super(title);
    }

    protected ReadImage samsungGalaxyS25UltraPic;
    protected JPanel picturePanel;

    @Override
    public void addComponents(Container contentPane) {
        super.addComponents(contentPane);

        deviceField.setText("Samsung Galaxy S25 Ultra");
        brandField.setText("Samsung");
        priceField.setText("46,900");
        featuretxtArea.setText(
                "- 200MP Camera\r\n" +
                        "- 1TB Storage\r\n" +
                        "- Snapdragon Gen 4 Processor\r\n" +
                        "- 5000mAh Battery\r\n" +
                        "- 6.8-inch AMOLED Display\r\n" +
                        "- 120Hz Refresh Rate\r\n" +
                        "- Fast Charging\r\n");
        ratingSlider.setValue(9);

        // Load Image
        samsungGalaxyS25UltraPic = new ReadImage("buaphad\\images\\S25-ultra.jpg", 0.45f);
        samsungGalaxyS25UltraPic.setPreferredSize(
                new Dimension(samsungGalaxyS25UltraPic.getWidth(), samsungGalaxyS25UltraPic.getHeight()));

        // Add Image to UI
        superExtraPanel.add(samsungGalaxyS25UltraPic);
    }

    public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
        JPanel panel = new JPanel();
        mdv7.addComponents(panel);
        mdv7.setContentPane(panel); // Ensure the panel is set as the main content pane
        mdv7.addMenus();
        mdv7.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
