package debugging;

/* Chapter 2 of Java How to Program: Fourth Edition
   Debugging Problem */

import java.util.Scanner;

public class Arithmetic
{
    public static void main(String[] args)
    {
      int num1, num2, num3, sum, product, average;
      Scanner input = new Scanner(System.in); //initialise scanner

      System.out.print("Enter first integer: "); //prompt
      num1 = input.nextInt(); //set num1 from input

      System.out.print("Enter second integer: "); //prompt
      num2 = input.nextInt(); //set num2 from input

      System.out.print("Enter third integer: "); //prompt
      num3 = input.nextInt(); //set num3 from input

      sum = num1 + num2 + num3; //calculate sum
      product = num1 * num2 * num3; //calculate product
      average = ( num1 + num2 + num3 ) / 3; //calculate average

      System.out.printf("The sum is %d\n" +
                       "The product is %d\n" +
                       "The average is %d", sum, product, average); //output from the program
    }//end method main

} // end class Arithmetic

