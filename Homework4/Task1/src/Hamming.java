import java.util.Scanner;

public class Hamming
{
    private static int hammingDistance(byte firstNumber, byte secondNumber) {
        byte comparison = (byte)(firstNumber & secondNumber);
        int distance = 0;

        while(comparison != 0)
        {
            distance += (comparison & 1) == 1 ? 1 : 0;
            comparison >>= 1;
        }

        return distance;
    }

    private static void print(byte n)
    {
        int mask = 1 << 8;
        for(int i = 0; i < 8; i++)
        {
            System.out.print((n & mask) == 0 ? '0' : '1');
            n <<= 1;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        byte firstNumber, secondNumber;

        //prompt
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        firstNumber = input.nextByte();
        System.out.print("Enter second number: ");
        secondNumber = input.nextByte();

        System.out.println(hammingDistance(firstNumber, secondNumber));
        System.out.print("First number in binary: ");
        print(firstNumber);
        System.out.print("Second number in binary: ");
        print(secondNumber);
    }


}
