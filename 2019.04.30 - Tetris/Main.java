import java.awt.Color;
import Blocks.*;
import UI.*;
import Exceptions.*;

public class Main {
    public static void main(String[] args) {
        Square[][] sampleBlock = {
            {new Square(Color.RED), new Square(Color.RED), new Square(Color.RED)},
            {new Square(Color.RED), null,                  null}
        };

        Block sample = new Block(sampleBlock);
        System.out.println(sample);

        Grid game = new Grid(20, 10);
        game.addBlock(sample, new Location(7, 5));
    }
}