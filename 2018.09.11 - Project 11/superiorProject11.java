import java.util.Scanner; public class superiorProject11 { public static void main(String[] args) { Scanner kboard = new Scanner(System.in); System.out.print("Please enter your name. "); String name = kboard.nextLine(); for (int i = name.length(); i > 0; i--) {System.out.print(name.substring(i - 1, i).toLowerCase());} System.out.println();}}

//11 September 2018, 17:56