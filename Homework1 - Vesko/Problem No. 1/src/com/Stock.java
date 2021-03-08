package com;

public class Stock
{
    //data fields
    private String symbol; //The symbol of this stock
    private String name; //The name of this stock
    private double previousClosingPrice; //The previous closing price of this stock
    private double currentPrice; //The current price of this stock

    public Stock(String symbol, String name) //Constructs a stock with specified symbol and name
    {
        this.symbol = symbol != null ? symbol : "Undefined symbol"; //Initializes symbol
        this.name = name != null ? name : "Undefined name"; //Initializes name
    } //End of constructor

    public String getSymbol() //Returns the symbol of this stock
    {
        return symbol; //returns symbol data field
    } //End of method getSymbol

    public String getName() //Returns the name of this stock
    {
        return name; //returns name data field
    } //End of method getName

    public double getPreviousClosingPrice() //Returns the previous closing price of this stock
    {
        return previousClosingPrice; //returns previousClosingPrice data field
    } //End of method getPreviousClosingPrice

    public double getCurrentPrice() //Returns the current price of this stock
    {
        return currentPrice; //returns currentPrice data field
    } //End of method getCurrentPrice

    public void setPreviousClosingPrice(double price) //Sets the previous closing price of this stock
    {
        previousClosingPrice = price >= 0 ? price : 1.0; //Initializes previousClosingPrice
    } //End of method setPreviousClosingPrice

    public void setCurrentPrice(double price) //Sets the current price of this stock
    {
        currentPrice = price >= 0 ? price : 1.0; //Initializes currentPrice
    } //End of method setCurrentPrice


    public double changePercent() //Returns the percentage of change of this stock
    {
        return 100 * (currentPrice - previousClosingPrice) / previousClosingPrice;
    } //End of method changePercent

} //End of class Stock
