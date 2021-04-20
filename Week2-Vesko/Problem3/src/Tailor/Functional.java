package Tailor;

import java.util.Scanner;

public class Functional {
    public static int factorial(int x) //method that finds factorial of x
    {
        int fact = 1; //variable to hold factorial

        while(x >= 1) //iterate through x to 1
        {
            fact *= x; //multiply current factorial by x
            x--; //decrease x by 1
        }
        return fact; //return the calculated factorial
    } //end of method factorial

    public static void main(String[] args) {
        double x; //variable to hold x
        double currentMember; //holds current member of sequence
        double nextMember; //holds next member of sequence
        double result = 0; //holds the e^x


        Scanner input = new Scanner(System.in); //declare Scanner
        System.out.print("Enter x: "); //prompt for x
        x = input.nextDouble(); //read x from scanner

        currentMember = 1; //set currentMember a value of x^0 / 0!
        nextMember = x; //set nextMember a value of x^1 / 1!
        result = currentMember; //set result to the first member

        int i = 2; //create counting variable

        while(true) //infinite loop with emergency break
        {
            currentMember = nextMember; //the next member is now current member
            nextMember = Math.pow(x, i) / factorial(i); //calculate and set the value of the next member
            result += currentMember; //add new member to the result

            if(Math.abs(currentMember - nextMember) < 0.001) //check if difference between two members is less than 0,001
            {
                result += nextMember;
                break; //if true break
            }

            i++; //increase counting variable
        }

        System.out.printf("x = %.2f, e^x = %f", x, result); //print result
    }
}
