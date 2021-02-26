package zad2;

import java.util.Scanner;

public class Palindrome
{
    public static void main(String[] args)
    {
        int number;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 5 digit number: ");
        number = input.nextInt();

        if(9_999 < number && number < 100_000)
        {
            int originalNumber = number;
            int digit5 = number % 10;
            number /= 10;
            int digit4 = number % 10;
            number /= 100;
            int digit2 = number % 10;
            int digit1 = number / 10;

            String resultString;
            if(digit1 == digit5 && digit2 == digit4)
            {
                resultString = String.format("The number %d is a palindrome", originalNumber);
                System.out.println(resultString);
            }
            else
            {
                resultString = String.format("The number %d is NOT a palindrome", originalNumber);
                System.out.println(resultString);
            }
        }
        else
        {
            System.out.printf("The number %d is NOT " +
                              "a five digit number", number);
        }
    }
}
