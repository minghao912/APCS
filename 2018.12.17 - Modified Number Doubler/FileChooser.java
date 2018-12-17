import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.*;
import java.util.*;

public class FileChooser extends JPanel {
    JButton go;

    JFileChooser chooser;
    String choosertitle;

    public FileChooser(String title) {
        choosertitle = title;
    }

    public String getDir() {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);

        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            return file.getAbsolutePath();
        } else {
            System.out.println("> Directory selection cancelled.");
            System.exit(0);
        }

        return null;
    }
}