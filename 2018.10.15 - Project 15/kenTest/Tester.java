import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner kboard = new Scanner(System.in);

        System.out.println("What is your name?");
        String accName = kboard.nextLine();
        System.out.println("How much do you have in your account");
        double userBalance = kboard.nextDouble();

        BankAccount myAccount = new BankAccount(userBalance, accName);

        myAccount.deposit(505.22);
        System.out.println("The " + myAccount.name + " account balance is, $" + myAccount.balance);
        myAccount.withdraw(100);
        System.out.println("The " + myAccount.name + " account balance is, $" + myAccount.balance);

    }
}