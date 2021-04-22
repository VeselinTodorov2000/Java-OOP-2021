public class Main {
    private static double series(int i)
    {
        if(i == 1)
        {
            return (double) i / (2*i + 1);
        }
        return (double) i / (2*i + 1) + Main.series(i-1);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++)
        {
            System.out.printf("i = %d, series[i] = %.2f\n", i, Main.series(i));
        }
    }
}
