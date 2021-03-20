package com;

import java.util.Scanner;   //the program uses Scanner

public class StockTest
{
    public static void main(String[] args) {

        //creating Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);

        System.out.print("Enter stock symbol: ");   // prompt for input
        String symbol = input.next();   //read the symbol of the stock

        System.out.print("Enter stock name: "); // prompt for input
        input.nextLine();
        String name = input.nextLine(); //read the name of the stock

        System.out.print("Enter previous closing price: "); // prompt for input
        double previousClosingPrice = input.nextDouble();   //read the previous closing price of the stock

        System.out.print("Enter current price: ");  // prompt for input
        double currentPrice = input.nextDouble();   //read the current price of the stock

        Stock stock = new Stock(symbol, name);
        stock.setPreviousClosingPrice(previousClosingPrice);
        stock.setCurrentPrice(currentPrice);

        //output the result on standard output
        System.out.printf("Stock symbol: %s\nStock name: %s\n" +
                "Stock previous closing price: %.2f\nStock current price: %.2f\nChange percent: %.2f\n",
                stock.getSymbol(), stock.getName(),
                stock.getPreviousClosingPrice(), stock.getCurrentPrice(), stock.changePercent());
    }   //end method main
}   //end class StockTest
