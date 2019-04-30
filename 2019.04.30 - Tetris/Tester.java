import Blocks.*;
import java.awt.Color;

public class Tester {
    public static void main(String[] args) {
        Square[][] sampleBlock = {
            {new Square(Color.RED), new Square(Color.RED), new Square(Color.RED)},
            {new Square(Color.RED), null,                  null}
        };

        Block sample = new Block(sampleBlock);
        System.out.println(sample);
    }
}