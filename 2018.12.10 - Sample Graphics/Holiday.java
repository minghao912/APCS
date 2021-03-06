import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Holiday {
    private static JFrame win;
    private static Container contentPane;
    private static Graphics g;
    private static JFrame endFrame;
    private static JPanel treePanel;
    
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

    public void drawBackground() {
        System.out.println("Drawing bakgoround");
        contentPane.setBackground(new Color(25, 40, 60));

        for (int i = 0; i < 100; i++) {
            int x = randNum(0, 800);
            int y = randNum(0, 600);
            int length = randNum(2, 5);
            int thickness = randNum(1, 4);

            g.setColor(new Color(200, 250, 255));
            g.fillOval(x, y, thickness, length);
        }

        /*         
        sleep(100);
        System.out.println("Drawing objets.");
        drawThings(); 
        */
    }

    public void drawRoad() {
        Polygon road = new Polygon();
        g.setColor(Color.BLACK);
        road.addPoint(50, 600);
        road.addPoint(350, 200);
        road.addPoint(450, 200);
        road.addPoint(750, 600);
        g.fillPolygon(road);

        Polygon line = new Polygon();
        g.setColor(new Color(220, 210, 0));
        line.addPoint(395, 200);
        line.addPoint(405, 200);
        line.addPoint(415, 600);
        line.addPoint(385, 600);
        g.fillPolygon(line);
    }

    public void wiper() {
        for (int deg = 0; deg <= 90; deg++) {
            g.setColor(new Color(25, 40, 60));

            g.fillArc(-800, 25, 1600, 1600, 0, deg);
            System.out.println("squeak");
            
            drawRoad();
            sleep(40);
        }
    }

    //Ending message
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
