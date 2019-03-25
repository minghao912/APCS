public class Customer
{
    // constructs a Customer with given name and ID number
    public Customer(String name, int idNum)
    {
        customerName = name;
        customerID = idNum;
    }

    // returns the customer's name
    public String getName() 
    {return customerName;}

    // returns the customer's id
    public int getID() 
    {return customerID;}

    // returns 0 when this customer is equal to other;
    // a positive integer when this customer is greater than other;
    // a negative integer when this customer is less than other
    public int compareCustomer(Customer other)
    {
        int nameComp = this.getName().compareTo(other.getName());
        if (nameComp != 0) return nameComp;
        else return this.getID() - other.getID();
    }
    
    private String customerName;
    private int customerID;

    //Additon
    public String toString() {
        return this.getName() + ", " + this.getID();
    }
}
