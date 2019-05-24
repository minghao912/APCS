package UI;

import Game.GameRunner;
import Game.Lock;
import Game.Grid;
import Game.Location.Direction;
import Exceptions.ExceptionHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class KeyEventHandler implements KeyListener{
    private static Grid grid;
    private static JPanel panel;
    private static GameRunner runner;   //So the stepping is paused when the block is moved
    private static Lock lock;

    public static void setHandlerInfo(Grid grid0, JPanel panel0, GameRunner runner0, Lock lock0) {
        grid = grid0;
        panel = panel0;
        runner = runner0;
        lock = lock0;
    }

    public static <T extends KeyEvent> void handleEvent(String str, T e) {
        //String message = "str\nCode: " + KeyEvent.getKeyText(e.getKeyCode()) + "\nChar: " + e.getKeyChar() + "\nMods: " + KeyEvent.getModifiersExText(e.getModifiersEx()) + "\nAction: " + e.isActionKey();
        //JOptionPane.showMessageDialog(null, message, "KeyEvent Detected", JOptionPane.INFORMATION_MESSAGE);

        try {
            switch (e.getKeyCode()) {
                case (KeyEvent.VK_LEFT):
                case (KeyEvent.VK_F2): 
                    moveBlock(Direction.LEFT);
                    break;
                case (KeyEvent.VK_RIGHT):
                case (KeyEvent.VK_F3): 
                    moveBlock(Direction.RIGHT);
                    break;
            }
        } catch (Throwable err) {
            ExceptionHandler.showError(err);
        }
    }

    private static void moveBlock(Direction dir) {
        runner.pause();
        synchronized (lock) {
            grid.moveBlock(null, dir);
            panel.repaint();
        }
        runner.resume();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //KeyEventHandler.printEventInfo("Key Pressed", e);   //test only
    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyEventHandler.handleEvent("Key Released", e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //KeyEventHandler.printEventInfo("Key Typed", e);   //test only
    }
}