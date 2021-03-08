package patterns;

import java.util.Scanner;

public class Pattern4
{
    public static void main(String[] args)
    {
        int x;
        Scanner input = new Scanner(System.in);
        x = input.nextInt();

        for(int row = 1; row <= x; row++)
        {
            for (int spaces = 0; spaces < 2 * (x - row); spaces++)
            {
                System.out.print(' ');
            }

            for (int digits = 1; digits <= row; digits++)
            {
                System.out.printf("%d ", digits);
            }

            for(int digits = row - 1; digits >= 1; digits--)
            {
                System.out.printf("%d ", digits);
            }

            System.out.println();
        }
    }
}
