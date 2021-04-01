package swap;

import java.util.Random;

public class ShuffleRows {
    public static void shuffle(int[][] m)
    {
        Random r = new Random();

        int first, second;
        for(int i = 0; i < 100; i++)
        {
            first = Math.abs(r.nextInt()) % m.length;
            second = Math.abs(r.nextInt()) % m.length;
            if(first != second)
            {
                for (int col = 0; col < m[first].length; col++)
                {
                    int temp = m[first][col];
                    m[first][col] = m[second][col];
                    m[second][col] = temp;
                }
            }
        }
    }

    public static void print(int[][] m)
    {
        for(int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m[i].length; j++)
            {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        System.out.println("Before: ");
        print(m);

        shuffle(m);
        System.out.println("After: ");
        print(m);
    }
}
