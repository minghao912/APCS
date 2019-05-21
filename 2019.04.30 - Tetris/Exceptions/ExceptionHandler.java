package Exceptions;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ExceptionHandler {
    public static <T extends Throwable> void showError(T e) {
        display(e);

        if (e instanceof Error) System.exit(1); //Exit if error
    }

    private static <Q extends Throwable> void display(Q e) {
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