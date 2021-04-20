package Task5a;

public class Esponent {
    public static long factorial(long number)
    {
        if(number == 0)
        {
            return 1;
        }
        return number * factorial(number-1);
    }

    public static void main(String[] args) {
        double e = 0;
        for(int i = 0; ; i++)
        {
            double member = 1.0 / factorial((long)i);
            if(member < 0.0000000001)
            {
                break;
            }
            e += member;
        }
        System.out.printf("e is %.5f", e);
    }
}
