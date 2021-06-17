package problem6;

import java.util.Random;
import java.util.function.Predicate;

public class ArrayUtils {
    static void filterNumbers(Predicate<Integer> condition, int[] array)
    {
        if(array == null || array.length == 0 || condition == null)
        {
            return;
        }

        for(int i = 0; i < array.length; i++)
        {
            if(condition.test(array[i])){
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = new int[20];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = random.nextInt(41) + 10;
        }

        System.out.println("Even: ");
        Predicate<Integer> even = a -> a % 2 == 0;
        filterNumbers(even, numbers);

        Predicate<Integer> interval = a -> (30 <= a && a <= 40);
        filterNumbers(interval, numbers);

        Predicate<Integer> prime = a -> {
            if(a < 2)
            {
                return false;
            }
            for (int i = 2; i < Math.sqrt(a); i++)
            {
                if(a % i == 0)
                {
                    return false;
                }
            }
            return true;
        };
        filterNumbers(prime, numbers);
    }
}