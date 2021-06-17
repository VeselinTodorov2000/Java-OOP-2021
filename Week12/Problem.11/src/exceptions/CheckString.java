package exceptions;

import java.util.Scanner;

public class CheckString {
    public static void main(String[] args) throws StringTooLongException {
        final int MAX_LENGTH = 20;
        Scanner input = new Scanner(System.in);

        StringTooLongException stringTooLongException = new StringTooLongException("String has more 20 characters");

        String userInput = "";
        while(!userInput.equals("DONE"))
        {
            userInput = input.next();
            if(!userInput.equals("DONE"))
            {
                if(userInput.length() > MAX_LENGTH)
                {
                    throw stringTooLongException;
                }
            }
        }

        System.out.println("Program completed");
    }
}
