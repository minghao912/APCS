import javax.swing.JOptionPane;

public class Error {
    public static void displayError(String errorType, String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage + "\nBattleship will now exit.", errorType, JOptionPane.ERROR_MESSAGE);
        
        if (errorType.contains("Fatal Error")) System.exit(128);
        else return;
    }
}