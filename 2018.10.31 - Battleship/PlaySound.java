import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.io.*;
import javax.sound.sampled.*;

public class PlaySound extends JFrame {
    public PlaySound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("Explosion2.wav");
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