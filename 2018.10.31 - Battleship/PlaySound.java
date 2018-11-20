import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.io.*;
import javax.sound.sampled.*;

/**
 * Plays sounds.
 */
public class PlaySound {
    /**
     * Play a sound.
     * 
     * @param sound - a {@code String} filename of the sound file within
     *              the directory {@code ./Files/Sounds/}
     */
    public void play(String sound, float volume) {
        try {
            //Retreive sound
            URL url = this.getClass().getClassLoader().getResource("Files/Sounds/" + sound);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();

            //Change volume
            clip.open(audioIn);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);

            //Play sound
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

// 20/11/2018 10:03