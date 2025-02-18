    package buaphad.tanapad.exercises.gui2;

    import java.awt.event.*;

    import javax.swing.JOptionPane;
    import javax.swing.JRadioButton;


    public class SimpleFormV7 extends SimpleFormV6 implements ItemListener{
        
        public SimpleFormV7(String title) {
            super(title);
        }

        public void itemStateChanged(ItemEvent e) {
            JRadioButton srcItem = (JRadioButton) e.getItemSelectable();
            String genderSelect = srcItem.getActionCommand();
            if (e.getStateChange() == ItemEvent.SELECTED) {
                JOptionPane.showMessageDialog(this, genderSelect + " is selected");
            }
        }

        public void actionPerformed(ActionEvent e) {
            Object srcObject = e.getSource();
            if (srcObject == okButton) {
                String name = nameTxt.getText();
                String addr = addrTxtArea.getText();
                String gender = getSelectedGender();
                String languages = getSelectedLanguages();
                JOptionPane.showMessageDialog(this, name + " lives at " + addr + " is " + gender + " knows these languages: " + languages);
            }
        }

        private String getSelectedGender() {
            if (male.isSelected()) return "male";
            if (female.isSelected()) return "female";
            if (other.isSelected()) return "other";
            return "not specified";
        }

        private String getSelectedLanguages() {
            StringBuilder sb = new StringBuilder();
            if (python.isSelected()) sb.append("python ");
            if (java.isSelected()) sb.append("java ");
            if (javascript.isSelected()) sb.append("javascript ");  
            return sb.toString();
        }

        public void addListeners() {
            okButton.addActionListener(this);
            male.addItemListener(this);
            female.addItemListener(this);
            other.addItemListener(this);
        }

        public static void createAndShowGUI() {
            SimpleFormV7 window = new SimpleFormV7("SimpleFormV7");
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
