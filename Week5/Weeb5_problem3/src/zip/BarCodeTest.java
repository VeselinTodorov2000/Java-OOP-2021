package zip;

import java.util.Scanner;

public class BarCodeTest
{
    public static void main(String[] args) {

        BarCode b = new BarCode();
        Scanner input = new Scanner(System.in);

        int zipCode;
        System.out.print("Enter your zip code: ");
        zipCode = input.nextInt();

        System.out.printf("The barcode for zip code %d is %s", zipCode, b.decode(zipCode));
    }
}
