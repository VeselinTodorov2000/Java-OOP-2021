package cipher;

import java.util.Scanner;

public class CipherTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice; //1 -> encrypt, 2 -> decrypt

        do {
            System.out.print("Write 1 for encrypt or 2 for decrypt: ");
            choice = input.nextInt();
        } while (choice != 1 && choice != 2);

        System.out.print("Write the encoding key: ");
        int key = input.nextInt();
        System.out.print("Write a text to encrypt/decrypt: ");
        input.nextLine();
        String text = input.nextLine();

        text = RouteCipher.prepareString(text);

        RouteCipher cipher = new RouteCipher(key);
        if (choice == 1) {
            System.out.printf("Encrypted: %s\n", cipher.encrypt(text));
        } else {
            System.out.printf("Decrypted: %s\n", cipher.decrypt(text));
        }

    }
}
