package com;

public class Stock {
    private String symbol;  //The symbol of this stock
    private String name;    //The name of this stock
    private double previousClosingPrice;    //The previous closing price of this stock
    private double currentPrice;            //The current price of this stock


    public Stock(String symbol, String name) {
        this.symbol = symbol != null ? symbol : "No symbol";
        this.name = name != null ? name : "No name";
        setCurrentPrice(0);
        setPreviousClosingPrice(0);
    }

    public String getSymbol() { return symbol; }

    public String getName() {
        return name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setPreviousClosingPrice(double price) {
        this.previousClosingPrice = price >= 0 ? price : 0;
    }

    public void setCurrentPrice(double price) {
        this.currentPrice = price >= 0 ? price : 0;
    }

    //calculating the change of the price of the stock in percents
    public double changePercent() {
        return 100 * ((currentPrice - previousClosingPrice) / previousClosingPrice);
    }
}
