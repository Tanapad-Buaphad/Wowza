package buaphad.tanapad.exercises.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;



public class GUI3 extends JFrame {

    protected JTextArea textArea;

    public GUI3(String title) {
        super(title);
    }

    public void setFrameFeatures() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void addComponents(Container contentPane) {
        contentPane.setLayout(new BorderLayout());

        JPanel row1 = new JPanel();
        row1.add(new JLabel("Name"));
        row1.add(new JTextField("Tanapad",15));

        JPanel row2 = new JPanel();
        row2.add(new JLabel("Address"));
        JTextArea txtArea = new JTextArea(4,20);
        txtArea.setText("Lorem Ipsum is simply dummy text of the priniting and typesetting" + 
                        "Lorem Ipsum is simply dummy text of the priniting and typesetting" + 
                        "Lorem Ipsum is simply dummy text of the priniting and typesetting" + 
                        "Lorem Ipsum is simply dummy text of the priniting and typesetting");
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtArea);
        row2.add(scrollPane);

        JPanel row3 = new JPanel();
        row3.add(new JButton("OK"));
        row3.add(new JButton("Cancel"));

        contentPane.add(row1,BorderLayout.NORTH);
        contentPane.add(row2,BorderLayout.CENTER);
        contentPane.add(row3,BorderLayout.SOUTH);
    }

    public static void createAndShowGUI() {
        GUI3 window = new GUI3("673040622-5");
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
