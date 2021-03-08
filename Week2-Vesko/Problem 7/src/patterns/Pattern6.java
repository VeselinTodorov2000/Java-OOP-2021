package patterns;

import java.util.Scanner;

public class Pattern6
{
    public static void main(String[] args) {
        int x;
        Scanner input = new Scanner(System.in);
        x = input.nextInt();

        for(int row = 1; row <= x; row++)
        {
            for (int spaces = 0; spaces < 2 * (x - row); spaces++)
            {
                System.out.print(' ');
            }

            for (int digits = x - row + 1; digits <= x; digits++)
            {
                System.out.printf("%d ", digits);
            }

            for(int digits = x - 1; digits > x - row; digits--)
            {
                System.out.printf("%d ", digits);
            }

            System.out.println();
        }
    }
}
