package routeCipher;

import java.util.Scanner;

public class RouteCipherTest {
    public static void main(String[] args) {
        //scanner declaration
        Scanner input = new Scanner(System.in);

        //prompt and input
        System.out.print("Enter key value: ");
        int key = input.nextInt();

        //create routecipher object
        RouteCipher r = new RouteCipher(key);

        //prompt encrypt or decrypt
        int choice = 0;
        do {
            System.out.print("Enter 1 for encrypt or 2 for decrypt: ");
            choice = input.nextInt();

            //encrypt
            if(choice == 1)
            {
                System.out.print("Enter plain text: ");
                String plainText = input.next();
                System.out.printf("Encrypted version of %s is %s", plainText, r.encrypt(plainText));
            }

            //decrypt
            if(choice == 2)
            {
                System.out.print("Enter cipher text: ");
                String cipherText = input.next();
                System.out.printf("Decrypted version of %s is %s", cipherText, r.decrypt(cipherText));
            }
        } while(choice != 1 && choice != 2);

    }
}
