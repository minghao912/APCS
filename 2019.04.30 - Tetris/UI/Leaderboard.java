package UI;

import Game.Counter;
import Game.FileReadWrite;
import Exceptions.ExceptionHandler;

import java.util.List;
import java.util.Arrays;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.SimpleAttributeSet;

public class Leaderboard extends JFrame {
    private String icon;

    public Leaderboard(String header) {
        super(header);
    }

    public void show(String leaderboardFilepath, String iconFilepath) {
        icon = iconFilepath;

        // Leaderboard stuff
        // Start the leaderboard/scoring stuff - all taken from Battleship project
        JOptionPane.showMessageDialog(null, "Game over!\nYour score: " + Counter.linesCleared, "Leaderboard",
                JOptionPane.INFORMATION_MESSAGE);
        String username = JOptionPane.showInputDialog(null, "Please enter your name:");

        List<String> leaderboard = new FileReadWrite().read(leaderboardFilepath);

        if (leaderboard == null) {
            System.out.println("Fatal Error\nAn unknown error has occured: null returned by FileReadWrite");
            return;
        }

        leaderboard.add(String.format("%02d", Counter.linesCleared) + ": " + username);

        String[] sortedLeaderboard = leaderboard.toArray(new String[0]);
        Arrays.sort(sortedLeaderboard);

        new FileReadWrite().write(leaderboardFilepath, sortedLeaderboard);

        showLeaderboard(sortedLeaderboard);

        // "Debug" the leaderboard info
        System.out.println("> New Leaderboard Info:");
        System.out.println("> " + Arrays.toString(sortedLeaderboard));
    }

    private void showLeaderboard(String[] elements) {
        JTextPane ta = new JTextPane();
        JScrollPane sp = new JScrollPane(ta);
        sp.setSize(new Dimension(400, 200));

        // Center text ☎13
        StyledDocument doc = ta.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        //Make text non-readable
        ta.setEditable(false);

        // Styling ☎14
        Style style = ta.addStyle("Color Style", null);
        Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

        ta.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        try { // Do bolded first line
            doc.insertString(doc.getLength(), elements[elements.length - 1] + "\n", style);
        } catch (Throwable e) {
            ExceptionHandler.showError(e);
        }

        ta.setFont(f); // Do the rest
        for (int i = elements.length - 2; i >= 0; i--) {
            try {
                doc.insertString(doc.getLength(), elements[i] + "\n", style);
            } catch (Throwable e) {
                ExceptionHandler.showError(e);
            }
        }

        this.setIconImage(new ImageIcon(icon).getImage());
        this.getContentPane().add(sp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(680, 480));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}