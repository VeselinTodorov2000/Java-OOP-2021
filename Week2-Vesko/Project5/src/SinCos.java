public class SinCos
{
    private static int factorial(int x)
    {
        if(x == 0)
        {
            return 1;
        }
        return x * factorial(x-1);
    }

    public static double sin(double x)
    {
        double sinSum = 0;
        double currentMember = 0;
        double nextMember = x;
        for(int n = 1; ; n++)
        {
            currentMember = nextMember;
            nextMember = (Math.pow(-1, n) / factorial(2*n + 1)) * Math.pow(x, 2*n + 1);

            sinSum += currentMember;
            System.out.println(sinSum);
            if(Math.abs(currentMember - (-1)*nextMember) < 0.01)
            {
                break;
            }
        }
        return sinSum;
    }

    public static void main(String[] args) {
        System.out.println(sin(5));
    }
}
