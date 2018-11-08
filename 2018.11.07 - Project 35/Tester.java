public class Tester {
    public static void main(String[] args) {
        int[][] a = { {1, 2, -2, 0}, 
                      {-3, 4, 7, 2},
                      {6, 0, 3, 1}};

        int[][] b = { {-1, 3},
                      {0, 9},
                      {1, - 11},
                      {4, -5} };

        int[][] result = MatrixMult.multiply(a, b);

        for (int[] row : result) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}