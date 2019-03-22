public class BankAccount implements Comparable{
    public BankAccount(String nm, double amt) {
        name = nm;
        balance = amt;
    }

    public void deposit(double dp) {
        balance = balance + dp;
    }

    public void withdraw(double wd) {
        balance = balance - wd;
    }

    public int compareTo(Object anotherObject) {
        BankAccount otherAccount = (BankAccount) anotherObject;

        if (balance < otherAccount.balance) return -1;
        else if (balance > otherAccount.balance) return 1;
        else return 0;
    }

    public String name;
    public double balance;
}