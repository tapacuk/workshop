import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 3;
        int[][] matrix = new int[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }

        System.out.println("Datsenko T.O. | Variant #10");
        System.out.println("-----------------------------");
        printMatrix(matrix);
        System.out.println("-----------------------------");
        System.out.println("sum of main diagonal: " + calcMainDiagonal(matrix));
        System.out.println("sum of side diagonal: " + calcSideDiagonal(matrix));
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int e : rows) {
                System.out.printf("  " + e);
            }
            System.out.println();
        }
    }

    public static int calcMainDiagonal(int[][] matrix){
        int sum = 0;

        int minDimension = matrix.length;
        if (matrix.length > matrix[0].length){
            minDimension = matrix[0].length;
        }

        for (int i = 0; i < minDimension; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int calcSideDiagonal(int[][] matrix){
        int sum = 0;

        int minDimension = matrix.length;
        if (matrix.length > matrix[0].length){
            minDimension = matrix[0].length;
        }

        for (int i = 0; i < minDimension; i++) {
            sum += matrix[i][minDimension - 1 - i];
        }
        return sum;
    }
}