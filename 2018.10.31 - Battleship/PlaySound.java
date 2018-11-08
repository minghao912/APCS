import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.io.*;
import javax.sound.sampled.*;


public class PlaySound {
    public void play(String sound) {
        try {
            URL url = this.getClass().getClassLoader().getResource("Files/Sounds/" + sound);
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
