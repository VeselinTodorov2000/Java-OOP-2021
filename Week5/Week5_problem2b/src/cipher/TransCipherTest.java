package cipher;

import java.util.Scanner;

public class TransCipherTest {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Key text: ");
        String keyText = input.next();
        TransCipher t = new TransCipher(keyText);

        System.out.print("Plain text: ");
        String toEncrypt = input.next();
        System.out.println(t.encrypt(toEncrypt));

        System.out.print("Encrypted text: ");
        String toDecrypt = input.next();
        System.out.println(t.decrypt(toDecrypt));
    }
}
