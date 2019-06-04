package UI;

import Game.Grid;
import Game.Counter;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;  // ☎11

public class CounterFrame extends JFrame implements Runnable {
    private Grid grid;
    private JSplitPane sp;
    private JLabel lines;
    private JLabel time;
    private int min, sec;

    public CounterFrame(String str, Grid grid) {
        super(str);

        this.grid = grid;
        lines = new JLabel("<html><div style='text-align: center;'>Lines Cleared<br/>" + Counter.linesCleared + "</div></html>");
        time = new JLabel("<html><div style='text-align: center;'>Time Elapsed<br/>00:00</div></html>");

        sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        sp.setLeftComponent(lines);
        sp.setRightComponent(time);
        sp.setDividerLocation(60);
        this.add(sp);

        System.out.println("> Counter frame setup done");
    }

    @Override
    public void run() {
        if (grid.isGameOver()) return;

        int totalSecElapsed = (min * 60) + sec;
        min = totalSecElapsed / 60;
        sec = totalSecElapsed % 60;

        //JLabel text ☎5
        lines.setText("<html><div style='text-align: center;'>Score\n" + Counter.linesCleared + "</div></html>");
        time.setText("<html><div style='text-align: center;'>Time Elapsed\n" + String.format("%02d", min) + ":" + String.format("%02d", sec) + "</div></html>");    //Formatting text - ☎12

        sec++;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 90);
    }
}