package com;

import java.util.Scanner;

public class StockTest
{
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in); //Declare scanner to read data

        //Declare and initialize variables to construct Stock object

        String symbol; //The symbol we will use for our Stock object
        String name; //The name we will use for our Stock object
        double previousClosingPrice; //The previousClosingPrice we will use for our Stock object
        double currentPrice; //The currentPrice we will use for our Stock object

        //symbol initialization
        System.out.print("Enter symbol: "); //prompt for symbol entry
        symbol = input.nextLine(); //initialize symbol from entry

        //name initialization
        System.out.print("Enter name: "); //prompt for name entry
        name = input.nextLine(); //initialize name from entry

        //previousClosingPrice initialization
        System.out.print("Enter previous closing price: "); //prompt for previousClosingPrice entry
        previousClosingPrice = input.nextDouble(); //initialize previousClosingPrice from entry

        //currentPrice initialization
        System.out.print("Enter current price: "); //prompt for currentPrice entry
        currentPrice = input.nextDouble(); //initialize currentPrice from entry

        //Construct Stock object
        Stock myStock = new Stock(symbol, name); //Declare Stock object and initialize it by constructor
        myStock.setPreviousClosingPrice(previousClosingPrice); //set the previousClosingPrice
        myStock.setCurrentPrice(currentPrice); //set the currentPrice

        //Test get methods
        System.out.printf("symbol: %s, name: %s, previous closing price: %.2f, current price: %.2f, percent of change: %.2f",
                           myStock.getSymbol(),
                           myStock.getName(),
                           myStock.getPreviousClosingPrice(),
                           myStock.getCurrentPrice(),
                           myStock.changePercent()); //prints with getters
    }
}
