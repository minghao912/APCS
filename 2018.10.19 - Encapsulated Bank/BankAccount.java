public class BankAccount {
    private double balance;
    private String name;

    public BankAccount() {}

    public void setBalance(double balanceToSet)
    {
        balance = balanceToSet;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void setName(String nameToSet)
    {
        name = nameToSet;
    }

    public String getName() 
    {
        return name;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }
}