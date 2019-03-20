public class Vehicle extends TaxableItem {
    private double dealerCost, dealerMarkup;

    public Vehicle(double dCost, double dMarkup, double taxRate) {
        super(taxRate);
        dealerCost = dCost;
        dealerMarkup = dMarkup;
    }

    public void changeMarkup(double dMarkup) {
        dealerMarkup = dMarkup;
    }

    public double getListPrice() {
        return dealerCost + dealerMarkup;
    }
}