import java.util.Scanner;

public class Thingy {

    private static Scanner a;

    public static void main(String[] args) {
        a = new Scanner(System.in);
        
        do {
            System.out.println();
            playGame();
        } while (askRestart());

        a.close();
        System.exit(0);
    }

    public static char getInput() {
        System.out.print("Rock-Paper-Scissors - pick your weapon[R, P, S]:: ");
        return a.nextLine().toLowerCase().charAt(0);
    }

    public static boolean askRestart() {
        System.out.print("\nPlay again? ");
        String input = a.nextLine();

        if (!input.matches("[yn]")) {
            System.out.println("Please enter a valid input.\n");
            System.exit(0);
        }

        if (input.equals("y")) return true;
        else return false;
    }

    public static void playGame() {
        char userInput = getInput();

        if (!(userInput + "").matches("[rps]")) {
            System.out.println("Uh-oh! Please enter something valid!\n");
            System.exit(0);
        }

        String choice = "";
        switch (userInput) {
        case 'r':
            choice = "Rock";
            break;
        case 'p':
            choice = "Paper";
            break;
        case 's':
            choice = "Scissors";
            break;
        }

        RockPaperScissors game = new RockPaperScissors(choice);
        System.out.println(game);
        System.out.println(game.determineWinner());
    }
}

//15/01/2019 14:24