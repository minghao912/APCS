public abstract class TaxableItem {
    private double taxRate;
    
    public abstract double getListPrice();

    public TaxableItem(double rate) {
        taxRate = rate;
    }

    //returns the price of the item including the tax
    public double purchasePrice() {
        return getListPrice() * (1 + taxRate);
    }
}