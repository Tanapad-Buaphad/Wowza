package buaphad.tanapad.lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import buaphad.tanapad.lab8.MySimpleWindow;

public class MobileDeviceV3 extends MobileDeviceV2 {

    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu, sizeMenu, colorMenu, fontMenu;
    protected JMenuItem newF, openF, saveF, exitF, smallSize, mediumSize, largeSize, extraLargeSize,
                        blackColor, redColor, greenColor, blueColor, font1, font2, font3;

    public MobileDeviceV3(String title){
    super(title);
    }

    public void addComponents(Container contentPane) {
        super.addComponents(contentPane);
    }

    public void addMenus() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        configMenu = new JMenu("Config");

        newF = new JMenuItem("New");
        openF = new JMenuItem("Open");
        saveF = new JMenuItem("Save");
        exitF = new JMenuItem("Exit");

        addSize();
        addColor();
        addFont();

        fileMenu.add(newF);
        fileMenu.addSeparator();
        fileMenu.add(openF);
        fileMenu.addSeparator();
        fileMenu.add(saveF);
        fileMenu.addSeparator();
        fileMenu.add(exitF);
        configMenu.add(sizeMenu);
        configMenu.add(colorMenu);
        configMenu.add(fontMenu);
        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        this.setJMenuBar(menuBar);
    }

    public void addSize() {
        sizeMenu = new JMenu("Size");
        smallSize = new JMenuItem("Small");
        mediumSize = new JMenuItem("Meadum");
        largeSize = new JMenuItem("Large");
        extraLargeSize = new JMenuItem("Extra Large");

        sizeMenu.add(smallSize);
        sizeMenu.add(mediumSize);
        sizeMenu.add(largeSize);
        sizeMenu.add(extraLargeSize);

    }

    public void addColor() {
        colorMenu = new JMenu("Color");
        blackColor = new JMenuItem("Black");
        redColor = new JMenuItem("Red");
        greenColor = new JMenuItem("Green");
        blueColor = new JMenuItem("Blue");

        colorMenu.add(blackColor);
        colorMenu.add(redColor);
        colorMenu.add(greenColor);
        colorMenu.add(blueColor);
    }

    public void addFont() {
        fontMenu = new JMenu("Font");
        font1 = new JMenuItem("Font1");
        font2 = new JMenuItem("Font2");
        font3 = new JMenuItem("Font3");

        fontMenu.add(font1);
        fontMenu.add(font2);
        fontMenu.add(font3);
    }

    public static void createAndShowGUI() {
        MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
        JPanel panel = new JPanel();
        mdv3.addComponents(panel);
        mdv3.add(panel);
        mdv3.addMenus();
        mdv3.setFrameFeatures();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
         public void run() {
             createAndShowGUI();
         }
        }); 
     }
}
