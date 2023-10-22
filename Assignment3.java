import java.util.Random;

public class Assignment3 {
    private static final int MAX_RANDOM_VALUE = 10;

    public static void main(String[] args) {
        int m = 3; // Number of rows in the first matrix
        int n = 3; // Number of columns in the first matrix / Number of rows in the second matrix
        int p = 3; // Number of columns in the second matrix

        int[][] matrixA = generateRandomMatrix(m, n);
        int[][] matrixB = generateRandomMatrix(n, p);

        long startTime = System.currentTimeMillis();
        int[][] result = multiplyMatricesParallel(matrixA, matrixB);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        System.out.println("Result:");
        printMatrix(result);

        System.out.println("Execution Time: " + executionTime + " milliseconds.");
    }

    public static int[][] generateRandomMatrix(int rows, int columns) {
        Random random = new Random();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_VALUE);
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] multiplyMatricesParallel(int[][] matrixA, int[][] matrixB) {
        int m = matrixA.length;
        int n = matrixA[0].length;
        int p = matrixB[0].length;

        int[][] result = new int[m][p];
        Thread[] threads = new Thread[m];

        for (int i = 0; i < m; i++) {
            threads[i] = new Thread(new MatrixMultiplicationTask(matrixA, matrixB, result, i));
            threads[i].start();
        }

        try {
            for (int i = 0; i < m; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    static class MatrixMultiplicationTask implements Runnable {
        private final int[][] matrixA;
        private final int[][] matrixB;
        private final int[][] result;
        private final int row;

        public MatrixMultiplicationTask(int[][] matrixA, int[][] matrixB, int[][] result, int row) {
            this.matrixA = matrixA;
            this.matrixB = matrixB;
            this.result = result;
            this.row = row;
        }

        @Override
        public void run() {
            int n = matrixA[0].length;
            int p = matrixB[0].length;

            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[row][j] += matrixA[row][k] * matrixB[k][j];
                }
            }
        }
    }
}