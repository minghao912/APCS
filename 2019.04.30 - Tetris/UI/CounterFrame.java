package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Game.Grid;
import Game.Counter;
import Exceptions.ExceptionHandler;

public class CounterPanel extends JFrame {
    private Grid grid;
    private JSplitPane sp;
    private JLabel lines;
    private JLabel time;
    private int min, sec;

    public CounterPanel(String str, Grid grid) {
        super(str);

        this.grid = grid;
        lines = new JLabel("<html><div style='text-align: center;'>Lines Cleared\n" + Counter.linesCleared + "</div></html>");
        time = new JLabel("<html><div style='text-align: center;'>Time Elapsed\n00:00</div></html>");

        init();
    }

    public void init() {
        while(!grid.isGameOver()) {
            int totalSecElapsed = (min * 60) + sec;
            min = totalSecElapsed / 60;
            sec = totalSecElapsed % 60;

            lines.setText("<html><div style='text-align: center;'>Lines Cleared\n" + Counter.linesCleared + "</div></html>");
            time.setText("<html><div style='text-align: center;'>Time Elapsed\n" + min + ":" + sec + "</div></html>");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                ExceptionHandler.showError(e);
            }
        }
    }
}