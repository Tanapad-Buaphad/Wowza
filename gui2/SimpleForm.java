package buaphad.tanapad.exercises.gui2;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class SimpleForm extends JFrame {
    protected JPanel buttonsPanel, namePanel, addrPanel, mainPanel;
    protected JLabel nameLabel, addrLabel;
    protected JTextField nameTxt;
    protected JButton okButton, cancelButton;
    protected JTextArea addrTxtArea;
    protected JScrollPane addrScrollPane;

    public SimpleForm(String title) {
        super(title);
    }

    public void addComponents() {
        nameLabel = new JLabel("Name:");
        nameTxt = new JTextField("Tanapad", 15);
        mainPanel = (JPanel) this.getContentPane();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        addrLabel = new JLabel("Address:");
        addrTxtArea = new JTextArea(4, 12);
        addrScrollPane = new JScrollPane(addrTxtArea);

        mainPanel.setLayout(new BorderLayout());

        namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameTxt);

        addrPanel = new JPanel();
        addrTxtArea.setLineWrap(true);
        addrTxtArea.setWrapStyleWord(true);
        addrTxtArea.setText("Khon Kaen");
        addrPanel.add(addrLabel);
        addrPanel.add(addrScrollPane);

        buttonsPanel = new JPanel();
        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);

        mainPanel.add(namePanel, BorderLayout.NORTH);
        mainPanel.add(addrPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void setFrameFeatures() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args) {
        SimpleForm window = new SimpleForm("673040622-5");
        window.addComponents();
        window.setFrameFeatures();
    }
}