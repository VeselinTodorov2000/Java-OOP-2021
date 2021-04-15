import java.util.Random;

public class SquareMatrixTest {
    private static Random r = new Random();

    public static int[][] createMatrix(int matrixSize)
    {
        int[][] newMatrix = new int[matrixSize][matrixSize];

        for(int row = 0; row < newMatrix.length; row++)
        {
            for(int col = 0; col < newMatrix[row].length; col++)
            {
                newMatrix[row][col] = Math.abs(r.nextInt() % 9);
            }
        }

        return newMatrix;
    }

    public static void main(String[] args) {

        final int matrixSize = Math.abs(r.nextInt() % 11) + 2;
        System.out.println(matrixSize);
        int[][] dataArray = createMatrix(matrixSize);
        SquareMatrix sm = new SquareMatrix(dataArray);

        System.out.println(sm.toString());
        System.out.println("Print all test:");
        sm.printAll();
    }
}
