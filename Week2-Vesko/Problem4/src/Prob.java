public class Prob
{
    public static void main(String[] args) {
        int numberOfProbableDigits = 0;
        int numberOfDigits = 0;

        for (int firstDigit = 3; firstDigit <= 9; firstDigit++)
        {
            for(int secondDigit = 2; secondDigit <= 8; secondDigit++)
            {
                for(int thirdDigit = 4; thirdDigit <= 9; thirdDigit++)
                {
                    for (int fourthDigit = 1; fourthDigit <= 6; fourthDigit++)
                    {
                        for (int fifthDigit = 6; fifthDigit <= 9; fifthDigit++)
                        {
                            numberOfDigits++;
                            int current = firstDigit*10000 + secondDigit*1000 + thirdDigit*100 + fourthDigit*10 + fifthDigit;
                            if(current % 12 == 0)
                            {
                                numberOfProbableDigits++;
                                System.out.println(current);
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("Probability is: %.2f", (double)numberOfProbableDigits / numberOfDigits);
    }
}
