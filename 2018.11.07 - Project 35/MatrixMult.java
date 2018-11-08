public class MatrixMult {
    public static int[][] multiply(int[][] a, int[][] b) {
        int aRows = a.length;
        int aColumns = a[0].length;
        int bRows = b.length;
        int bColumns = b[0].length;

        if (aColumns != bRows) {
            return null;
        }

        int[][] c = new int[aRows][bColumns];
        for (int rows = 0; rows < c.length; rows++) {
            for (int columns = 0; columns < c[0].length; columns++) {
                int y = rows;
                int x = columns;
                int sum = 0;

                for (int i = 0; i < aColumns; i++) {
                    sum += a[y][i] * b[i][x];
                }

                c[rows][columns] = sum;
            }
        }

        return c;
    }
}