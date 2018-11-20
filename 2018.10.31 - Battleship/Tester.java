import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;

public class Tester {
    public static void main(String[] args) {
        
        new Tester().hello();
    }

    void hello() {
        String[] elements = {"a: 5", "b: 777", "c: a320"};

        JPanel leaderboardPanel = new JPanel();
        leaderboardPanel.setPreferredSize(new Dimension(680, 480));
        
        leaderboardPanel.setLayout(new BoxLayout(leaderboardPanel, BoxLayout.Y_AXIS));
        for (String leaderboardElement : elements) {
            leaderboardPanel.add(new JLabel(leaderboardElement, SwingConstants.CENTER));
        }

        Box box = new Box(BoxLayout.Y_AXIS);
        box.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        box.add(Box.createVerticalGlue());
        box.add(leaderboardPanel);
        box.add(Box.createVerticalGlue());
    
        JFrame leaderboardInternalFrame = new JFrame("Leaderboard");
        leaderboardInternalFrame.setPreferredSize(new Dimension(680, 480));
        leaderboardInternalFrame.getContentPane().add(box);
        //leaderboardInternalFrame.addWindowListener(this);
        leaderboardInternalFrame.pack();
        leaderboardInternalFrame.setLocationRelativeTo(null);
        leaderboardInternalFrame.setVisible(true);
    }
}