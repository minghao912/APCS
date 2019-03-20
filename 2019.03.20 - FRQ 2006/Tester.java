public class Tester {
    public static void main(String[] args) {
        Vehicle car = new Vehicle(20000, 2500, 0.10);
        System.out.println("List Price: " + car.getListPrice() + " Purchase Price: " + car.purchasePrice());
        
        car.changeMarkup(1000);
        System.out.println("List Price: " + car.getListPrice() + " Purchase Price: " + car.purchasePrice());
    }
}