package UI;

import Game.Grid;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventHandler implements KeyListener{
    private static Grid grid;

    public static void setGrid(Grid grid0) {
        grid = grid0;
    }

    public static <T extends KeyEvent> void handleEvent(String str, T e) {
        //String message = "str\nCode: " + KeyEvent.getKeyText(e.getKeyCode()) + "\nChar: " + e.getKeyChar() + "\nMods: " + KeyEvent.getModifiersExText(e.getModifiersEx()) + "\nAction: " + e.isActionKey();
        //JOptionPane.showMessageDialog(null, message, "KeyEvent Detected", JOptionPane.INFORMATION_MESSAGE);
    
        if (e.getKeyCode() == KeyEvent.VK_F1) 
            grid.spawnNewBlock();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyEventHandler.handleEvent("Key Pressed", e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //KeyEventHandler.printEventInfo("Key Released", e);    //test only
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //KeyEventHandler.printEventInfo("Key Typed", e);   //test only
    }
}