package UI;

import Game.Grid;
import Game.Location.Direction;
import Exceptions.ExceptionHandler;

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
    
        try {
            switch (e.getKeyCode()) {
                case (KeyEvent.VK_F1):  grid.spawnNewBlock();
                                        break;
                case (KeyEvent.VK_F2):  grid.moveBlock(null, Direction.LEFT);
                                        break;
                case (KeyEvent.VK_F3):  grid.moveBlock(null, Direction.RIGHT);
                                        break;
            }
        } catch (Throwable err) {
            ExceptionHandler.showError(err);
        }

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