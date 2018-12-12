import javax.swing.*;
import java.awt.*;

public class Tree {
    private static JFrame treeFrame;

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.drawThings();

        treeFrame.setPreferredSize(new Dimension(800, 600));
        treeFrame.pack();
        treeFrame.setLocationRelativeTo(null);
        treeFrame.setVisible(true);
    }

    // Tree
    public void drawThings() {
        treeFrame = new JFrame("Jesus's Birthday");
        Graphics t = treeFrame.getContentPane().getGraphics();

        t.setColor(new Color(110, 65, 5));
        t.fillRect(350, 300, 100, 150);

        t.setColor(new Color(0, 91, 26));

        Polygon tri1 = new Polygon();
        tri1.addPoint(400, 100);
        tri1.addPoint(300, 200);
        tri1.addPoint(500, 200);
        t.fillPolygon(tri1); // drawPolygon() would create outline only

        Polygon tri2 = new Polygon();
        tri2.addPoint(400, 125);
        tri2.addPoint(250, 275);
        tri2.addPoint(550, 275);
        t.fillPolygon(tri2);

        Polygon tri3 = new Polygon();
        tri3.addPoint(400, 175);
        tri3.addPoint(200, 350);
        tri3.addPoint(600, 350);
        t.fillPolygon(tri3);

        t.setColor(new Color(255, 230, 70));
        t.fillOval(350, 200, 20, 20);
        t.fillOval(425, 215, 22, 22);
        t.fillOval(380, 245, 21, 21);
        t.fillOval(325, 270, 21, 21);
        t.fillOval(440, 290, 21, 21);

        t.setColor(new Color(0, 40, 10));
        t.fillRect(0, 450, 800, 300);
    }
}