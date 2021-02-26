package lab1;

import java.util.Scanner;

//Program breaks apart a five-digit number
public class Five
{
    public static void main(String args[])
    {
        int originalNumber;
        int number;
        String inputString;

        // read five-digit number from standard input and store in var originalNumber
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a five-digit number: ");
        originalNumber = input.nextInt(); //set originalNumber from input

        // determine the 5 digits
        int digit1; // first digit of number
        int digit2; // second digit of number
        int digit3; // third digit of number
        int digit4; // fourth digit of number
        int digit5; // fifth digit of number

        digit1 = originalNumber / 10000; // get leftmost digit
        number = originalNumber % 10000; // get rightmost four digits
        digit2 = number / 1000; //get second digit
        number = originalNumber % 1000; // get rightmost three digits
        digit3 = number / 100; //get third digit
        number = originalNumber % 100; // get rightmost two digits
        digit4 = number / 10; //get fourth digit
        number = originalNumber % 10; // get rightmost digit
        digit5 = number; //get last digit

        // create the result string
        String resultString = String.format("%d\t%d\t%d\t%d\t%d", digit1, digit2, digit3, digit4, digit5);
        // output results on standard output
        showMessageDialog(resultString);

    } //end method main

    public static void showMessageDialog(String resultString)
    {
        System.out.println(resultString);
    } //end method showMessageDialog

} // end class Five

