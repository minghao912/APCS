import javax.swing.*;
import java.awt.*;

public class Holiday {
    private static JFrame win;
    private static Container contentPane;
    private static Graphics g;

    public static void main(String[] args) {
        Holiday holiday = new Holiday();
        holiday.makeFrame();

        try {
            Thread.sleep(400);
        } catch (Exception e) {
            System.out.println("Uh-oh!");
        }

        holiday.drawThings();
    }

    public void makeFrame() {
        win = new JFrame("Jesus's Birthday"); // window setup
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setPreferredSize(new Dimension(800, 600));
        win.setResizable(false);
        win.pack();
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }

    public void drawThings() {
        contentPane = win.getContentPane();
        g = contentPane.getGraphics();

        g.setColor(new Color(110, 65, 5));
        g.fillRect(350, 300, 100, 150);

        g.setColor(new Color(0, 91, 26));

        Polygon tri1 = new Polygon();
        tri1.addPoint(400, 100);
        tri1.addPoint(300, 200);
        tri1.addPoint(500, 200);
        g.fillPolygon(tri1); // drawPolygon() would create outline only

        Polygon tri2 = new Polygon();
        tri2.addPoint(400, 125);
        tri2.addPoint(250, 275);
        tri2.addPoint(550, 275);
        g.fillPolygon(tri2);

        Polygon tri3 = new Polygon();
        tri3.addPoint(400, 175);
        tri3.addPoint(200, 350);
        tri3.addPoint(600, 350);
        g.fillPolygon(tri3);

        g.setColor(new Color(255, 230, 70));
        g.fillOval(350, 200, 20, 20);
        g.fillOval(425, 215, 22, 22);
        g.fillOval(380, 245, 21, 21);
        g.fillOval(325, 270, 21, 21);
    }
}