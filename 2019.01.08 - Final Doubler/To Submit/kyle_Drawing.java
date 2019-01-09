import javax.swing.*;  // for JFrame
import java.awt.*;     // for Graphics and Container

public class Drawing
{  
    public static void main (String[] args)
    {
        JFrame win;                 // JFrame Graphics setup
        Container contentPane;
        Graphics g;
      
        win = new JFrame("My First Graphics");  // window setup
        win.setSize(1366 , 768);
        win.setLocation(500,400);
        win.setVisible(true);
      
        contentPane = win.getContentPane();   // activates graphics in window
        g = contentPane.getGraphics();
      
        //  If you get a blank window, your computer's speed (lack thereof?)
        //  requires this delay in order to give the window time to appear
        //  before attempting to draw on it
         try {Thread.sleep(400);} catch (Exception e) {}
        g.setColor(new Color(23, 27, 48));
        g.fillRect(0,0,1366,768);   

        g.setColor(new Color(160, 137, 94));
        g.fillRect(633,600,50,200);   // draws outline rectangle
        g.setColor(new Color(178, 151, 101));
        g.fillRect(683,600,50,200);
      
        // set color to any RGB value
        g.setColor(new Color(110, 214, 109));
       
        // draw a triangle
        Polygon tri1 = new Polygon();
        tri1.addPoint(683,600);
        tri1.addPoint(683,200);
        tri1.addPoint(483,600);
        g.fillPolygon(tri1);       // drawPolygon() would create outline only

        // draw a triangle
        g.setColor(new Color(142, 244, 141));
        Polygon tri2 = new Polygon();
        tri2.addPoint(883,600);
        tri2.addPoint(683,200);
        tri2.addPoint(683,600);
        g.fillPolygon(tri2);   

        //g.setStroke(3);
        //g.fillOval(550,200,350,350);
        g.setColor(new Color(255, 255, 255));
        //g.fillOval(575,225,300,300);
        for (int i = 350; i<380; i++)
        {
            g.drawOval(570-(i/2),310-(i/2),i,i);
        }

        for (int i = 350; i<380; i++)
        {
            g.drawOval(700-(i/2),375-(i/2),i,i);
        }

        for (int i = 300; i<330; i++)
        {
            g.drawOval(775-(i/2),250-(i/2),i,i);
        }

        //g.setColor(new Color(23, 27, 48));
        g.setColor(new Color(23, 27, 48));
        Polygon tri3 = new Polygon();
        tri3.addPoint(883,600);
        tri3.addPoint(683,200);
        tri3.addPoint(1366,600);
        g.fillPolygon(tri3); 

        Polygon tri4 = new Polygon();
        tri4.addPoint(483,600);
        tri4.addPoint(683,200);
        tri4.addPoint(0,600);
        g.fillPolygon(tri4);

        Polygon tri5 = new Polygon();
        tri5.addPoint(0,600);
        tri5.addPoint(683,200);
        tri5.addPoint(0,200);
        g.fillPolygon(tri5);

        Polygon tri6 = new Polygon();
        tri6.addPoint(1366,600);
        tri6.addPoint(683,200);
        tri6.addPoint(1366,200);
        g.fillPolygon(tri6);

        g.fillRect(0,0,1366,200); 
        //g.fillRect(0,0,1366,768); 
        g.fillRect(733,600,1366,200);
        g.fillRect(0,600,633,200);

        g.setColor(new Color(219, 92, 92));
       
        g.fillOval(600,500,25,25);  // draws solid ovals and circles
        g.fillOval(700,450,25,25);

        g.setColor(new Color(224, 182, 85));

        Polygon tri7 = new Polygon();
        tri7.addPoint(703,168);
        tri7.addPoint(683,208);
        tri7.addPoint(663,168);
        g.fillPolygon(tri7);

        Polygon tri8 = new Polygon();
        tri8.addPoint(703,192);
        tri8.addPoint(683,152);
        tri8.addPoint(663,192);
        g.fillPolygon(tri8);

   }
}