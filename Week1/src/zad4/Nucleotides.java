package zad4;

import java.util.Scanner;

public class Nucleotides
{
    public static void main(String[] args)
    {
        int number;

        //read 4 digit number
        Scanner input = new Scanner(System.in);
        System.out.print("Input a four-digit number: ");
        number = input.nextInt();
        int originalNumber = number; //holds the entered number copy

        //validation
        if(1_000 <= number && number <= 9_999)
        {
            //additional variables
            String resultRepresentation = ""; //holds the result string
            int currentModule; //temp variable to hold the module at every step

            while(number != 0)
            {
                currentModule = number%4;
                number /= 4;

                if(currentModule == 0) //creck if module is 0
                {
                    resultRepresentation = "A" + resultRepresentation; //add A to the result
                }
                if(currentModule == 1) //creck if module is 1
                {
                    resultRepresentation = "C" + resultRepresentation; //add C to the result
                }
                if(currentModule == 2) //creck if module is 2
                {
                    resultRepresentation = "G" + resultRepresentation; //add G to the result
                }
                if(currentModule == 3) //creck if module is 3
                {
                    resultRepresentation = "T" + resultRepresentation; //add T to the result
                }
            } //end of while loop
            //print the result
            System.out.printf("Number: %d, " +
                              "Nucleotide representation: %s\n", originalNumber, resultRepresentation);
        }
        else
        {
            System.out.printf("Number %d is NOT a four-digit number\n", number);
        }

    } //end of method main
} //end of class Nucleotides
