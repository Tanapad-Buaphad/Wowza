package buaphad.tanapad.exercises.gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class GUI5 extends GUI3 {

    protected JPanel mainPanel;
    protected JLabel nameLabel , addressLabel , languageLabel , genderLabel , hobbiesLabel;
    protected JTextField nameTextField;
    protected JTextArea addressArea , hobbiesArea ;
    protected JRadioButton genderRadio ;
    protected JCheckBox languageCheckBox;

    public GUI5(String title) {
        super(title);
    }

    public void createNameLabel() {
        nameLabel = new JLabel("Name:");
        addressLabel = new JLabel("Address:");
        languageLabel = new JLabel("Language:");
        genderLabel = new JLabel("Gender:");
        hobbiesLabel = new JLabel("Hobbies:");
    }

    public void createInput() {
        nameTextField = new JTextField();
        addressArea = new JTextArea();
        languageCheckBox = new JCheckBox();
        genderRadio = new JRadioButton();
    }

    public void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);
        createNameLabel();
        
        
    }

     public static void createAndShowGUI() {
        GUI5 window = new GUI5("673040622-5");
        JPanel panel = new JPanel();
        window.addComponents(panel);
        window.setContentPane(panel);
        window.setFrameFeatures();
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
