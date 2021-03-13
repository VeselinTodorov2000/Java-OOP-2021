package task3;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.Random;

public class RandomProbability
{
    public static int drawRandomNumber()
    {
        Random r = new Random();
        int drawnNumber = Math.abs(r.nextInt() % 100) + 1; //draw a number between 1 and 100
        if(0 <= drawnNumber && drawnNumber <= 20) //if is between 1 and 20 return 1
        {
            return 1;
        }
        if(20 < drawnNumber && drawnNumber <= 50) //if is between 21 and 50 return 2
        {
            return 2;
        }
        else
        {
            return 3; //if is between 51 and 100 return 3
        }
        //in this way probability will be accomplished
    }

    public static void main(String[] args)
    {
        //counters of drawn 1, 2 and 3
        int timesOne = 0;
        int timesTwo = 0;
        int timesThree = 0;

        int current; //current drawn number

        //for 10000 times
        System.out.println("For 10000 times");
        for(int i = 0; i < 10000; i++)
        {
            current = drawRandomNumber();
            switch (current) //check which number we have drawn and increment its counter
            {
                case 1: timesOne++; break;
                case 2: timesTwo++; break;
                case 3: timesThree++; break;
            }
        }

        //number format in percentages
        NumberFormat nf = NumberFormat.getPercentInstance();
        System.out.print("Probability of 1: ");
        System.out.println(nf.format(timesOne/10000.0));
        System.out.print("Probability of 2: ");
        System.out.println(nf.format(timesTwo/10000.0));
        System.out.print("Probability of 3: ");
        System.out.println(nf.format(timesThree/10000.0));


        //for 60000 times

        //we make counters 0 because the contain values for the previous for loop
        timesOne = 0;
        timesTwo = 0;
        timesThree = 0;

        System.out.println("For 60000 times");


        for(int i = 0; i < 60000; i++)
        {
            current = drawRandomNumber(); //check which number we have drawn and increment its counter
            switch (current)
            {
                case 1: timesOne++; break;
                case 2: timesTwo++; break;
                case 3: timesThree++; break;
            }
        }

        //number format in percentages
        System.out.print("Probability of 1: ");
        System.out.println(nf.format(timesOne/60000.0));
        System.out.print("Probability of 2: ");
        System.out.println(nf.format(timesTwo/60000.0));
        System.out.print("Probability of 3: ");
        System.out.println(nf.format(timesThree/60000.0));
    }
}
