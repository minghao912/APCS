import javax.swing.*;  // for JFrame
import java.awt.*;     // for Graphics and Container

public class kyle_Drawingx2
{  
    public static void main (String[] args)
    {
        JFrame win;                 // JFrame Graphics setup
        Container contentPane;
        Graphics g;
      
        win = new JFrame("My First Graphics");  // window setup
        win.setSize(2732 , 1536);
        win.setLocation(1000,800);
        win.setVisible(true);
      
        contentPane = win.getContentPane();   // activates graphics in window
        g = contentPane.getGraphics();
      
        //  If you get a blank window, your computer's speed (lack thereof?)
        //  requires this delay in order to give the window time to appear
        //  before attempting to draw on it
         try {Thread.sleep(400);} catch (Exception e) {}
        g.setColor(new Color(23, 27, 48));
        g.fillRect(0,0,2732,1536);   

        g.setColor(new Color(160, 137, 94));
        g.fillRect(1266,1200,100,400);   // draws outline rectangle
        g.setColor(new Color(178, 151, 101));
        g.fillRect(1366,1200,100,400);
      
        // set color to any RGB value
        g.setColor(new Color(110, 214, 109));
       
        // draw a triangle
        Polygon tri2 = new Polygon();
        tri2.addPoint(1366,1200);
        tri2.addPoint(1366,400);
        tri2.addPoint(966,1200);
        g.fillPolygon(tri2);       // drawPolygon() would create outline only

        // draw a triangle
        g.setColor(new Color(142, 244, 141));
        Polygon tri4 = new Polygon();
        tri4.addPoint(1766,1200);
        tri4.addPoint(1366,400);
        tri4.addPoint(1366,1200);
        g.fillPolygon(tri4);   

        //g.setStroke(3);
        //g.fillOval(1100,400,700,700);
        g.setColor(new Color(255, 255, 255));
        //g.fillOval(1150,450,600,600);
        for (int i = 350; i<380; i++)
        {
            g.drawOval(1140-(i/4),620-(i/4),i,i);
        }

        for (int i = 350; i<380; i++)
        {
            g.drawOval(1400-(i/4),750-(i/4),i,i);
        }

        for (int i = 300; i<330; i++)
        {
            g.drawOval(1550-(i/4),500-(i/4),i,i);
        }

        //g.setColor(new Color(23, 27, 48));
        g.setColor(new Color(23, 27, 48));
        Polygon tri6 = new Polygon();
        tri6.addPoint(1766,1200);
        tri6.addPoint(1366,400);
        tri6.addPoint(2732,1200);
        g.fillPolygon(tri6); 

        Polygon tri8 = new Polygon();
        tri8.addPoint(966,1200);
        tri8.addPoint(1366,400);
        tri8.addPoint(0,1200);
        g.fillPolygon(tri8);

        Polygon tri10 = new Polygon();
        tri10.addPoint(0,1200);
        tri10.addPoint(1366,400);
        tri10.addPoint(0,400);
        g.fillPolygon(tri10);

        Polygon tri12 = new Polygon();
        tri12.addPoint(2732,1200);
        tri12.addPoint(1366,400);
        tri12.addPoint(2732,400);
        g.fillPolygon(tri12);

        g.fillRect(0,0,2732,400); 
        //g.fillRect(0,0,2732,1536); 
        g.fillRect(1466,1200,2732,400);
        g.fillRect(0,1200,1266,400);

        g.setColor(new Color(219, 92, 92));
       
        g.fillOval(1200,1000,50,50);  // draws solid ovals and circles
        g.fillOval(1400,900,50,50);

        g.setColor(new Color(224, 182, 85));

        Polygon tri14 = new Polygon();
        tri14.addPoint(1406,336);
        tri14.addPoint(1366,416);
        tri14.addPoint(1326,336);
        g.fillPolygon(tri14);

        Polygon tri16 = new Polygon();
        tri16.addPoint(1406,384);
        tri16.addPoint(1366,304);
        tri16.addPoint(1326,384);
        g.fillPolygon(tri16);

   }
}
