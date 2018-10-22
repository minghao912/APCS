public class Lab14d {
    public static void main(String[] args) {
        Double[] values = {100.0, 90.0, 85.0, 72.5, 95.6};
        
        Double sum = 0.0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];

            System.out.println("grade " + i + " :: ");
            System.out.printf("%-5.3s", values[i]);
            System.out.println();
        }

        System.out.println("\naverage = " + sum / values.length);
    }
}