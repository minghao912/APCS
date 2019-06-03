package UI;

import Game.GameRunner;
import Game.Lock;
import Game.Grid;
import Game.Location.Direction;
import Exceptions.ExceptionHandler;

import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * Serves as the middleman between the game
 * and the user.
 */
public class KeyEventHandler implements KeyListener{
    private static Grid grid;
    private static JPanel panel;
    private static GameRunner runner;   //So the stepping is paused when the block is moved
    private static volatile Lock lock;

    /**
     * Sets all necessary {@code KeyEventHandler} info.
     * @param grid0 the game's {@code Grid}
     * @param panel0 the game's {@code JPanel}
     * @param runner0 the game's {@code GameRunner}
     * @param lock0 the game's {@code Lock}
     */
    public static void setHandlerInfo(Grid grid0, JPanel panel0, GameRunner runner0, Lock lock0) {
        grid = grid0;
        panel = panel0;
        runner = runner0;
        lock = lock0;
    }

    /**
     * Handles the events.
     * @param <T> extends {@code KeyEvent}
     * @param str the {@code String} to display [NO LONGER USED]
     * @param e the {@code KeyEvent}
     */
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
                case (KeyEvent.VK_UP):
                    rotateBlock(Direction.COUNTERCLOCKWISE);
                    break;
                case (KeyEvent.VK_SPACE):
                    quickDrop();
                    break;
                case (KeyEvent.VK_C):
                    holdBlock();
                    break;
                
                //Debug use only (Simulation still runs in background)
                case (KeyEvent.VK_F5):
                    runner.pause();
                    break;
                case (KeyEvent.VK_F6):
                    runner.resume();
                    break;
            }
        } catch (Throwable err) {
            ExceptionHandler.showError(err);
        }
    }

    private static synchronized void quickDrop() {
        runner.pause();
        synchronized (lock) {
            grid.quickDrop(null);
            panel.repaint();
        }
        runner.resume();
    }

    private static void holdBlock() {
        runner.pause();
        synchronized (lock) {
            grid.holdBlock(null, true);
            panel.repaint();
        }
        runner.resume();
    }

    private static void rotateBlock(Direction dir) {
        runner.pause();
        synchronized (lock) {
            grid.rotateBlock(null, dir);
            panel.repaint();
        }
        runner.resume();
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