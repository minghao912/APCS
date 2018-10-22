public class asciiart {
    public static void main(String[] args) {
        writingUtensil();

        System.out.println("");
        System.out.println("");

        attemptedHouse();

        System.out.println("");
        System.out.println("");

        tree();
    }

    public static void writingUtensil() {
        String sidees = "       |      |        ";
        String bottom = "       |______|        ";

        System.out.println("          /\\          ");
        System.out.println("         /  \\         ");
        System.out.println("        /____\\        ");
        
        for(int i = 0; i <= 10; i++) {
            System.out.println(sidees);
        }

        System.out.println(bottom);
        System.out.println(sidees);
        System.out.println(bottom);
    }

    public static void attemptedHouse() {
        String side = "| |          |";
        String bottom = "| |__________|";
        String roof = "_\\_\\_\\_\\_\\";

        System.out.println(" _____________");
        System.out.println("/ \\_\\" + roof);
        System.out.println(side);
        System.out.println(side);
        System.out.println(bottom);

    }

    public static void tree() {
        System.out.println("       oo888ooo       ");
        System.out.println("   OOOOQOOOOOOOP8     ");
        System.out.println("O8O8083OQQ   UQQ388   ");
        System.out.println("  \\\\\\\\\\//    ////");
        System.out.println("     \\\\\\\\\\  ///  ");
        System.out.println("        \\\\||||      ");
        System.out.println("          \\|||       ");
        System.out.println("           |||        ");
        System.out.println("           |||        ");
        System.out.println("          /|||\\      ");
    }
}