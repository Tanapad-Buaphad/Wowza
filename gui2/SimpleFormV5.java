package buaphad.tanapad.exercises.gui2;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class SimpleFormV5 extends SimpleFormV4 implements ActionListener {
    public SimpleFormV5(String title) {
        super(title);
    }

    public void actionPerformed(ActionEvent e) {
        Object srcObject = e.getSource();
        if (srcObject == okButton) {
            String name = nameTxt.getText();
            String addr = addrTxtArea.getText();
            JOptionPane.showMessageDialog(this, name + " lives at " + addr);
        }
    }

    public void addListeners() {
        okButton.addActionListener(this);
    }

    public static void createAndShowGUI() {
        SimpleFormV5 window = new SimpleFormV5("SimpleFormV5");
        window.addComponents();
        window.addMenus();
        window.addListeners();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}