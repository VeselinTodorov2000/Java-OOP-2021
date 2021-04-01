package matrix;

import java.util.Scanner;

public class MatrixMultiplicator
{
    public static void printMatrix(double[][] a)
    {
        for(int row = 0; row < a.length; row++)
        {
            for(int col = 0; col < a[row].length; col++)
            {
                System.out.printf("%.1f ", a[row][col]);
            }
            System.out.println();
        }
    }
    public static double[][] multiplyMatrix(double[][] a, double[][] b)
    {
        double[][] c = new double[3][3];

        c[0][0] = a[0][0]*b[0][0] + a[0][1]*b[1][0] + a[0][2]*b[2][0];
        c[0][1] = a[0][0]*b[0][1] + a[0][1]*b[1][1] + a[0][2]*b[2][1];
        c[0][2] = a[0][0]*b[0][2] + a[0][1]*b[1][2] + a[0][2]*b[2][2];
        c[1][0] = a[1][0]*b[0][0] + a[1][1]*b[1][0] + a[1][2]*b[2][0];
        c[1][1] = a[1][0]*b[0][1] + a[1][1]*b[1][1] + a[1][2]*b[2][1];
        c[1][2] = a[1][0]*b[0][2] + a[1][1]*b[1][2] + a[1][2]*b[2][2];
        c[2][0] = a[2][0]*b[0][0] + a[2][1]*b[1][0] + a[2][2]*b[2][0];
        c[2][1] = a[2][0]*b[0][1] + a[2][1]*b[1][1] + a[2][2]*b[2][1];
        c[2][2] = a[2][0]*b[0][2] + a[2][1]*b[1][2] + a[2][2]*b[2][2];

        return c;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a[][] = new double[3][3];
        System.out.println("Enter matrix a");
        for(int row = 0; row < a.length; row++)
        {
            for(int col = 0; col < a[row].length; col++)
            {
                a[row][col] = input.nextDouble();
            }
        }

        double b[][] = new double[3][3];
        System.out.println("Enter matrix b");
        for(int row = 0; row < a.length; row++)
        {
            for(int col = 0; col < b[row].length; col++)
            {
                b[row][col] = input.nextDouble();
            }
        }

        System.out.println("Result is:");
        printMatrix(multiplyMatrix(a, b));
    }
}
