import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.io.*;
import javax.sound.sampled.*;

<<<<<<< HEAD
public class PlaySound extends JFrame {
    public void play(String sound) {
=======
public class PlaySound {
    public PlaySound() {
>>>>>>> fd0f3c47fcbfa31ee55da59c9f1b3939a4ad492d
        try {
            URL url = this.getClass().getClassLoader().getResource(sound);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
