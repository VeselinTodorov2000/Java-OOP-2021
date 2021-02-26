package zad3;

import java.util.Scanner;

public class Encrypt
{
    public static void main(String[] args)
    {
        int number;
        Scanner input = new Scanner(System.in);

        //encrypt
        System.out.print("Input a four-digit number: ");
        number = input.nextInt();

        int digit1, digit2, digit3, digit4;
        int originalNumber = number;

        digit4 = number % 10;
        number /= 10;
        digit3 = number % 10;
        number /= 10;
        digit2 = number % 10;
        digit1 = number / 10;

        digit1 = (digit1 + 7) % 10;
        digit2 = (digit2 + 7) % 10;
        digit3 = (digit3 + 7) % 10;
        digit4 = (digit4 + 7) % 10;

        int encryptedNumber = digit3 * 1000 + digit4 * 100 + digit1 * 10 + digit2;

        System.out.printf("Encrypted number of %04d is %04d\n", originalNumber, encryptedNumber);

        //decrypt
        System.out.print("Input a four-digit number: ");
        encryptedNumber = input.nextInt();
        originalNumber = encryptedNumber;

        digit4 = encryptedNumber % 10;
        encryptedNumber /= 10;
        digit3 = encryptedNumber % 10;
        encryptedNumber /= 10;
        digit2 = encryptedNumber % 10;
        encryptedNumber /= 10;
        digit1 = encryptedNumber / 10;

        digit1 = decrypt(digit1);
        digit2 = decrypt(digit2);
        digit3 = decrypt(digit3);
        digit4 = decrypt(digit4);

        number = digit3 * 1000 + digit4 * 100 + digit1 * 10 + digit2;

        System.out.printf("Decrypted number of %04d is %04d\n", originalNumber, number);
    }

    public static int decrypt(int digit)
    {
        return (digit + 3) % 10;
    }
}
