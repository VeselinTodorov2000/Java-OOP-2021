package probability;

import java.text.NumberFormat;
import java.util.Random;

public class RandomNumberProbability {
    public static int drawRandomNumber() {
        Random generator = new Random();

        //drawing a random number between 1 and 10
        int randomNumber = generator.nextInt(10) + 1;

        //achieving probability
        if (1 <= randomNumber && randomNumber <= 2) //0.2 probability for 1 (P(1) = 0.2)
        {
            return 1;
        }
        else if (3 <= randomNumber && randomNumber <= 5)    //0.3 probability for 2 (P(2) = 0.3)
        {
            return 2;
        }
        else    //0.5 probability for 3 (P(3) = 0.5)
        {
            return 3;
        }
    }

    public static void main(String[] args) {
        int counter1 = 0;   //counter for how many times the drawn number is 1
        int counter2 = 0;   //counter for how many times the drawn number is 2
        int counter3 = 0;   //counter for how many times the drawn number is 3
        NumberFormat nf = NumberFormat.getPercentInstance();

        //test with 10000 draws
        for (int i = 0; i < 10000; i++) {
            switch (drawRandomNumber()) {
                case 1:
                    counter1++;
                    break;
                case 2:
                    counter2++;
                    break;
                case 3:
                    counter3++;
                    break;
            }
        }

        System.out.println("The probability for 1 is " + nf.format(counter1 / 10000.0));
        System.out.println("The probability for 2 is " + nf.format(counter2 / 10000.0));
        System.out.println("The probability for 3 is " + nf.format(counter3 / 10000.0));
    }
}
