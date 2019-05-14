package UI;

import Game.Grid;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class KeyEventHandler {
    private static Grid grid;

    public static void setGrid(Grid grid0) {
        grid = grid0;
    }

    public static <T extends KeyEvent> void printEventInfo(String str, T e) {
        //String message = "str\nCode: " + KeyEvent.getKeyText(e.getKeyCode()) + "\nChar: " + e.getKeyChar() + "\nMods: " + KeyEvent.getModifiersExText(e.getModifiersEx()) + "\nAction: " + e.isActionKey();
        //JOptionPane.showMessageDialog(null, message, "KeyEvent Detected", JOptionPane.INFORMATION_MESSAGE);
    
        if (e.getKeyCode() == KeyEvent.VK_F1) 
            grid.spawnNewBlock();
    }
}