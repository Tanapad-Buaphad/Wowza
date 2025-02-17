package buaphad.tanapad.lab9;

import java.awt.*;
import javax.swing.*;

import buaphad.tanapad.lab8.MobileDeviceV3;

public class MobileDeviceV4 extends MobileDeviceV3 {

    protected ImageIcon newIcon, openIcon , saveIcon , exitIcon;
    protected Font smallFont = new Font("Arial", Font.PLAIN, 10) ,
    mediemFont = new Font("Arial", Font.PLAIN, 14) ,
    largeFont = new Font("Arial", Font.PLAIN, 18) ,
    extraLargeFont = new Font("Arial", Font.PLAIN, 22);

    public MobileDeviceV4(String title) {
        super(title);
    }

    public void addComponents(Container contentPane) {
        super.addComponents(contentPane);

    }

    public void addMenus() {
        super.addMenus();

        fileMenu.removeAll();

        ImageIcon newIcon = new ImageIcon("images/new_icon.png");
        newF = new JMenuItem("New",newIcon);
        ImageIcon openIcon = new ImageIcon("images/open_icon.png");
        openF = new JMenuItem("Open", openIcon);
        ImageIcon saveIcon = new ImageIcon("images/save_icon.png");
        saveF = new JMenuItem("Save",saveIcon);
        ImageIcon exitIcon = new ImageIcon("images/exit_icon.png");
        exitF = new JMenuItem("Exit", exitIcon);
        
        fileMenu.add(newF);
        fileMenu.addSeparator();
        fileMenu.add(openF);
        fileMenu.addSeparator();
        fileMenu.add(saveF);
        fileMenu.addSeparator();
        fileMenu.add(exitF);
        
    }

    public void addSize() {
        super.addSize();
        smallFont = new Font("Arial", Font.PLAIN, 10);
        mediemFont = new Font("Arial", Font.PLAIN, 14);
        largeFont = new Font("Arial", Font.PLAIN, 18);
        extraLargeFont = new Font("Arial", Font.PLAIN, 22);

        smallSize.setFont(smallFont);
        mediumSize.setFont(mediemFont);
        largeSize.setFont(largeFont);
        extraLargeSize.setFont(extraLargeFont);

    }

    public void addColor() {
        super.addColor();
        blackColor.setForeground(Color.BLACK);
        redColor.setForeground(Color.RED);
        greenColor.setForeground(Color.GREEN);
        blueColor.setForeground(Color.BLUE);

    }

    public void addFont() {
        super.addFont();
        font1.setFont(new Font("Serif", Font.PLAIN, 14));
        font2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        font3.setFont(new Font("Monospaced", Font.PLAIN, 14));

    }

    public static void createAndShowGUI() {
        MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
        JPanel panel = new JPanel();
        mdv4.addComponents(panel);
        mdv4.add(panel);
        mdv4.addMenus();
        mdv4.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MobileDeviceV4::createAndShowGUI);
    }
}
