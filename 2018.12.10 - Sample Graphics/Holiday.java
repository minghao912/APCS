import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Holiday implements ActionListener{
    private static JFrame win;
    private static Container contentPane;
    private static Graphics g;

    public static void main(String[] args) {
        Holiday holiday = new Holiday();
        holiday.makeFrame();
        
        ActionListener kylehasuglygraphics = new ActionListener() {
            public void actionPerformed(ActionEvent kenneedsglasses) {
                holiday.drawBackground();
            }
        };

        sleep(100);
        holiday.drawThings();

        new Timer(500, kylehasuglygraphics);
    }

    public static void sleep(int t) {
        try {
            Thread.sleep(t);
        } catch (Exception e) {
            System.out.println("Uh-oh!");
        }
    }

    public void makeFrame() {
        win = new JFrame("Jesus's Birthday"); // window setup
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setPreferredSize(new Dimension(800, 600));
        win.setResizable(false);
        win.pack();
        win.setLocationRelativeTo(null);
        win.setVisible(true);

        contentPane = win.getContentPane();
        g = contentPane.getGraphics();
    }

    public void drawThings() {
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
        g.fillOval(440, 290, 21, 21);

        g.setColor(new Color(0, 40, 10));
        g.fillRect(0, 450, 800, 300);
    }

    public void drawBackground() {
        contentPane.setBackground(new Color(25, 40, 60));
        
        for (int i = 0; i < 500; i++) {
            int x = randNum(0, 800);
            int y = randNum(0, 600);
            int length = randNum(2, 5);

            g.setColor(new Color(200, 250, 255));
            g.drawLine(x, y, x, y + length);
        }
    }

    public static int randNum(int min, int max) {
        return (int) (Math.random() * (max - 1) + 1);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}