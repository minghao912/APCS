package Exceptions;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 * Handles all {@code Exception}s within the game.
 */
public class ExceptionHandler {
    /**
     * Shows the error message and stack trace to the
     * screen via message box.
     */
    public static <Q extends Throwable> void showError(Q e) {
        String errorMessage = e + "\n";
        for (StackTraceElement traceE : e.getStackTrace()) {
            errorMessage += traceE + "\n";
        }
        JTextArea ta = new JTextArea(errorMessage);
        JScrollPane sp = new JScrollPane(ta);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        sp.setPreferredSize(new Dimension(400, 100));

        JOptionPane.showMessageDialog(null, sp, "Error", JOptionPane.ERROR_MESSAGE);
    }
}