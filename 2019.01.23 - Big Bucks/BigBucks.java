import java.io.*;
import java.util.*;
import java.text.*;

public class BigBucks {
    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        String name;

        ArrayList<BankAccount> aryList = new ArrayList<BankAccount>();

        do {
            Scanner kb = new Scanner(System.in);
            System.out.print("Please enter the name to whom the account belongs. (\"Exit\" to abort) ");

            name = kb.nextLine();

            if (!name.equalsIgnoreCase("EXIT")) {
                System.out.print("Please enter the amount of the deposit. ");
                double amount = kb.nextDouble();
                System.out.println();

                BankAccount account = new BankAccount(name, amount);
                aryList.add(account);
            } 
        } while (!name.equalsIgnoreCase("EXIT"));

        //Search aryList and print out the name and amount of the largest bank account
        BankAccount bigBaller = aryList.get(0);
        double maxBalance = bigBaller.balance;
        String maxName = bigBaller.name;
        for (int j = 1; j< aryList.size(); j++) {
            BankAccount biggerBaller = aryList.get(j);
            if (biggerBaller.balance > maxBalance) {
                maxBalance = biggerBaller.balance;
                maxName = biggerBaller.name;
            }
        }

        System.out.println("The account with the largest balance belongs to " + maxName + ".");
        System.out.println("The amount is $" + maxBalance + ".");
    }
}