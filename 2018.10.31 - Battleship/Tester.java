import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;

public class Tester {
    public static void main(String[] args) {
        JFrame anAbsoluteUnit = new JFrame("BS");
        anAbsoluteUnit.add(new JButton("Button"));
        anAbsoluteUnit.pack();
        anAbsoluteUnit.setVisible(true);

        String[] elements = {"a", "b", "c", "d", "e"};
        JPanel leaderboardPanel = new JPanel();
             for (String leaderboardElement : elements) {
            leaderboardPanel.add(new JLabel(leaderboardElement));
        }

        JInternalFrame leaderboardInternalFrame = new JInternalFrame("Leaderboard");
        JComponent compPane = (JComponent) leaderboardInternalFrame.getContentPane();

        Dimension largeFrameSize = anAbsoluteUnit.getSize();
        Dimension smallFrameSize = leaderboardInternalFrame.getSize();
        leaderboardInternalFrame.setLocation((largeFrameSize.width - smallFrameSize.width)/2, (largeFrameSize.height - smallFrameSize.height)/2);
  
                  
        compPane.add(leaderboardPanel);
        leaderboardInternalFrame.pack();
        anAbsoluteUnit.add(leaderboardInternalFrame);
        leaderboardInternalFrame.show();
        leaderboardInternalFrame.toFront();
    }
}