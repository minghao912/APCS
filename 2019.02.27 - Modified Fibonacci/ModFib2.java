public class ModFib2 {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    public static int fibonacci(int n) {
        return (n == 0) ? 3 : (n == 1) ? 5 : (n == 2) ? 8 : fibonacci(n - 1) + fibonacci(n - 2) + fibonacci(n - 3);
    }
}