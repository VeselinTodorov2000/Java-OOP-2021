package menu;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class ComputeByMenu
{
    private double x;

    public ComputeByMenu(double x) 
    {
        this.x = x;
    }

    public void displayMenu() 
    {
        for(int i = 1; i < 60; i++)
        {
            System.out.println();
        }
        System.out.println("1. Update the floating point number\n" +
                           "2. Compute and display exp(x)\n" +
                           "3. Compute and display sin(x0\n" +
                           "4. Compute and display floor(x)\n" +
                           "5. Exit");
    }

    public void doSelection(int choice)
    {
        switch (choice)
        {
            case 1: System.out.println(x*x); break;
            case 2: System.out.println(Math.exp(x)); break;
            case 3: System.out.println(Math.sin(x)); break;
            case 4: System.out.println(Math.floor(x)); break;
            default:  break;
        }
    }

    public void getUserChoice()
    {
        displayMenu();
        Scanner input = new Scanner(System.in);
        int x;
        do {
            System.out.print("Enter operation 1-5: ");
            x = input.nextInt();
        } while(x < 1 || x > 5);
        doSelection(x);
    }
}
