public class Terst {
    public static void main(String[] args) {
        /*
        NicholasChan nick = new NicholasChan("Sweatie", "Bot", "Isn't it Sunday in Amsterdam?");
        Yoda yoda = new Yoda("Yoda", "Yoda", "The dark side I sense in you.", "Powerful you have become");
        Elizabethan shakespeare = new Elizabethan("Will", "Shakespeare", "To be or not to be?");
        NormalDude dude = new NormalDude("John", "Doe", "Howdy there pardner!");
        */
        
        FamousPerson[] dudesAndDudettes = new FamousPerson[4];
        dudesAndDudettes[0] = new NicholasChan("Sweatie", "Bot", "Isn't it Sunday in Amsterdam?");
        dudesAndDudettes[1] = new Yoda("Yoda", "Yoda", "The dark side I sense in you.", "Powerful you have become");
        dudesAndDudettes[2] = new Elizabethan("Will", "Shakespeare", "To be or not to be?");
        dudesAndDudettes[3] = new NormalDude("John", "Doe", "Howdy there pardner!");

        for (FamousPerson person : dudesAndDudettes)
           person.speak();
    }
}