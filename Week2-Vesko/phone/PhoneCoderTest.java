package phone;

import java.util.Scanner;

public class PhoneCoderTest
{
    public static void main(String[] args) {
        PhoneCoder phoneCoder = new PhoneCoder(5);
        Scanner input = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phoneNumber = input.nextLine();
        System.out.printf("Encoded phone number: %s\n", phoneCoder.encode(phoneNumber));

        System.out.print("Enter encoded phone number: ");
        String codedPhoneNumber = input.nextLine();
        System.out.printf("Phone number: %s\n", phoneCoder.decode(codedPhoneNumber));
    }
}
