import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please input the bank account's initial balance, in USD: ");
        double initialBalance = keyboard.nextDouble();
        keyboard.nextLine();

        System.out.print("Please input the bank account holder's name: ");
        String accountHolder = keyboard.nextLine();

        //new bank account
        BankAccount koolAccount = new BankAccount();
        koolAccount.setBalance(initialBalance);
        koolAccount.setName(accountHolder);

        //deposit $505.22, then print balance
        koolAccount.deposit(505.22);
        System.out.println("The " + koolAccount.getName() + " account balance is, $" + koolAccount.getBalance());

        //withdraw $100, then print final balance
        koolAccount.withdraw(100);
        System.out.println("The " + koolAccount.getName() + " account balance is, $" + koolAccount.getBalance());
    }
}