package UI;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

import Game.Grid;
import Game.Counter;

public class CounterFrame extends JFrame implements Runnable{
    private Grid grid;
    private JSplitPane sp;
    private JLabel lines;
    private JLabel time;
    private int min, sec;

    public CounterFrame(String str, Grid grid) {
        super(str);

        this.grid = grid;
        lines = new JLabel("<html><div style='text-align: center;'>Lines Cleared<br>" + Counter.linesCleared + "</div></html>");
        time = new JLabel("<html><div style='text-align: center;'>Time Elapsed<br>00:00</div></html>");

        sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        sp.setLeftComponent(lines);
        sp.setRightComponent(time);
        this.add(sp);

        System.out.println("> Counter frame setup done");
    }

    @Override
    public void run() {
        if (grid.isGameOver()) return;

        int totalSecElapsed = (min * 60) + sec;
        min = totalSecElapsed / 60;
        sec = totalSecElapsed % 60;

        lines.setText("<html><div style='text-align: center;'>Lines Cleared\n" + Counter.linesCleared + "</div></html>");
        time.setText("<html><div style='text-align: center;'>Time Elapsed\n" + min + ":" + sec + "</div></html>");

        sec++;
    }
}