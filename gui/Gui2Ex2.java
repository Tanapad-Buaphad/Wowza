package buaphad.tanapad.exercises.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Gui2Ex2 extends JPanel {

    private Ellipse2D.Double circle = new Ellipse2D.Double(10, 10, 100, 100);
    private Rectangle2D.Double square = new Rectangle2D.Double(55, 55, 10, 10);
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.RED);
        g2d.draw(circle);
        g2d.setColor(Color.BLUE);
        g2d.fill(square);
    }
    public static void main(String[] args) {
        JFrame window = new JFrame("6225");
        Gui2Ex2 content = new Gui2Ex2();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(content);
        window.setLocation(100,100);
        window.setPreferredSize(new Dimension(100,100));
        window.pack();
        window.setVisible(true);

    }
    
    
}
