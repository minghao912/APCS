package Game;

import javax.swing.JPanel;

/**
 * A {@code GameRunner} is a {@code TimerTask}
 * that steps the current game instance forward.
 */
public class GameRunner implements Runnable {
    private Grid grid;
    private JPanel panel;

    private volatile boolean running = true;
    private volatile boolean paused = false;
    private final Object pauseLock = new Object();

    /**
     * Creates a {@code GameRunner} to work with
     * the given {@code Grid} and {@code JPanel}.
     * @param grid the game's {@code Grid}
     * @param jpanel the game's {@code JPanel}
     */
    public GameRunner(Grid grid, JPanel jpanel) {
        this.grid = grid;
        this.panel = jpanel;
    }

    @Override
    public void run() {
        //Do checks to see if it should be paused
        synchronized (pauseLock) {
            if (!running) {
                System.out.println("> Game is paused; not stepping");
                return;
            }

            if (paused) {
                try {
                    synchronized (pauseLock) {
                        pauseLock.wait();
                    }
                } catch (InterruptedException ex) {
                    return;
                }

                if (!running) 
                    return;
            }
        }

        if (grid.isGameOver())  //Don't do anything if in game over state
            return;

        //Actually do the thing
        grid.regularStep();
        panel.repaint();
    }

    /**
     * Stops the running of the game.
     */
    public void stop() {
        running = false;
        resume();
    }

    /**
     * Pauses the running of the game
     * until {@code resume()} is called.
     * @throws IllegalStateException when the
     *         {@code Thread} is not currently running
     */
    public void pause() {
        if (!running)
            throw new IllegalStateException("Thread is not running; cannot be paused");
        paused = true;
    }

    /**
     * Resumes the running of the game.
     */
    public void resume() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll();
        }
    }
}

//https://stackoverflow.com/questions/16758346/how-pause-and-then-resume-a-thread