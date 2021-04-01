import java.util.Scanner;

public class CreditCards
{
    public static int seconds(long number)
    {
        int sum = 0;

        while(number != 0)
        {
            sum += number % 10;
            number /= 100;
        }

        return sum;
    }

    public static int doubledSeconds(long number)
    {
        int sum = 0;
        number /= 10;

        while(number != 0)
        {
            int temp = (int) (number % 10) * 2;
            sum += temp % 10 + temp / 10;
            number /= 100;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a credit number: ");
        long number = input.nextLong();

        int sum1 = doubledSeconds(number);
        int sum2 = seconds(number);

        System.out.println(sum1 + " " + sum2);
    }
}
