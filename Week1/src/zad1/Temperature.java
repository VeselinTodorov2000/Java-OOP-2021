package zad1;

import java.util.Scanner;

public class Temperature
{
    public static void main(String[] args)
    {
        double celcius;
        double fahrenheit;

        Scanner input = new Scanner(System.in);

        System.out.print("Input 1 for Fahrenheit to Celcius or 2 for Celcius to Fahrenheit: ");
        int choice = input.nextInt();

        if(choice == 1)
        {
            //to celcius
            System.out.print("Input degrees fahrenheit: ");
            fahrenheit = input.nextDouble();

            celcius = 5.0 / 9.0 * (fahrenheit - 32);
            System.out.printf("Degrees in fahrenheit: %.2f, " + " Degrees in celcius %.2f\n", fahrenheit, celcius);
        }
        if(choice == 2)
        {
            //to fahrenheit

            System.out.print("Input degrees celcius: ");
            celcius = input.nextDouble();

            fahrenheit = 9.0 / 5.0 * (celcius + 32);
            System.out.printf("Degrees in celcius: %.2f, " + " Degrees in fahrenheit %.2f\n", celcius, fahrenheit);
        }
    }
}
