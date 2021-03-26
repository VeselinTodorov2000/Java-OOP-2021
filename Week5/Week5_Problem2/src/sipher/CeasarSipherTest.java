package sipher;

import java.util.Locale;
import java.util.Scanner;

public class CeasarSipherTest
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice; //1 encrypt : 2 decrypt

        do {
            System.out.print("Write 1 to encrypt or 2 do decrypt: ");
            choice = input.nextInt();
        }while(choice != 1 && choice != 2);

        System.out.print("Write code shift length: ");
        int code = input.nextInt();

        System.out.println("Write plain text: ");
        String plainText = input.next();
        plainText = plainText.toUpperCase();

        CeasarSipher cipher = new CeasarSipher(code);
        if(choice == 1)
        {
            System.out.printf("Encrypted version of %s is %s", plainText, cipher.encrypt(plainText));
        }
        if(choice == 2)
        {
            System.out.printf("Decrypted version of %s is %s", plainText, cipher.decrypt(plainText));
        }
    }
}
