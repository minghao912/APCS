import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Holiday {
    private static JFrame win;
    private static Container contentPane;
    private static Graphics g;
    
    public static void main(String[] args) {
        Holiday holiday = new Holiday();
        holiday.makeFrame();

        new PlaySound().play("LetItSnow2.wav", -10.0f);

        Timer yeet = new Timer();
        TimerTask activateWiper = new TimerTask() {
            @Override
            public void run() {
                holiday.wiper();
            }
        };
        yeet.schedule(activateWiper, 5000, 10000);

        Timer memes = new Timer();
        TimerTask kylehasuglygraphics = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Yo!");
                holiday.drawBackground();
            }
        };
        memes.schedule(kylehasuglygraphics, 0, 100);

        Timer endingSequence = new Timer();
        TimerTask endCard = new TimerTask() {
            @Override
            public void run() {
                yeet.cancel();
                yeet.purge();
                memes.cancel();
                memes.purge();
                holiday.end();
            }
        };
        endingSequence.schedule(endCard, 115000);
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

    /*
    Tree
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
    */

    public void drawBackground() {
        System.out.println("Drawing bakgoround");
        contentPane.setBackground(new Color(25, 40, 60));
        
        for (int i = 0; i < 100; i++) {
            int x = randNum(0, 800);
            int y = randNum(0, 600);
            int length = randNum(2, 5);
            int thickness = randNum(1, 3);

            g.setColor(new Color(200, 250, 255));
            g.fillOval(x, y, thickness, length);
        }

        /*         
        sleep(100);
        System.out.println("Drawing objets.");
        drawThings(); 
        */
    }

    public void wiper() {
        for (int deg = 0; deg <= 90; deg++) {
            g.setColor(new Color(25, 40, 60));

            g.fillArc(-800, 25, 1600, 1600, 0, deg);
            System.out.println("squeak");
            sleep(50);
        }
    }

    public void end() {
        JFrame end = new JFrame("Happy Holidays!");
        end.setPreferredSize(new Dimension(800, 600));
        end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] stuff = { "Season's Greetings!", "Happy Holidays!", "-Ming" };

        JPanel inner = new JPanel();
        inner.setLayout(new GridBagLayout());
        inner.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(box.createVerticalGlue());
        for (String thing : stuff) {
            JLabel label = new JLabel("<html><h1><div style='text-align: center;'>" + thing + "</div></h1></html>", SwingConstants.CENTER);
            label.setFont(new Font("Sans_Serif", Font.BOLD, 36));
            box.add(label);
        }
        box.add(box.createVerticalGlue());
        
        inner.add(box);

        end.add(inner);
        end.pack();
        end.setLocationRelativeTo(null);
        end.setVisible(true);

        win.dispose();
    }

    public static int randNum(int min, int max) {
        return (int) (Math.random() * (max - 1) + 1);
    }
}

//12/12/2018 12:32
