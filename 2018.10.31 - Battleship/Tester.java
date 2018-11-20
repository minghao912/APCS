import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;

public class Tester {
    public static void main(String[] args) {
        
        new Tester().hello();
    }

    void hello() {
        String[] elements = {"a: 5", "b: 777", "c: a320"};

        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(Box.createVerticalGlue());
        for (String leaderboardElement : elements) {
            JLabel elementLabel = new JLabel(leaderboardElement, SwingConstants.CENTER);
            elementLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            box.add(Box.createRigidArea(new Dimension(0, 10)));
            box.add(elementLabel);
        }
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