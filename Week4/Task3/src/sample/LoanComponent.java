package sample;

public class LoanComponent
{
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;

    public LoanComponent(double annualInterestRate, int numberOfYears, double loanAmount) {
        setAnnualInterestRate(annualInterestRate);
        setNumberOfYears(numberOfYears);
        setLoanAmount(loanAmount);
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate =(5.0 < annualInterestRate && annualInterestRate < 8.0) ? annualInterestRate : 5.0;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = Math.abs(numberOfYears);
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount > 0 ? loanAmount : 500;
    }

    public double computeMonthly()
    {
        return (loanAmount * (annualInterestRate/100)/12) / (1 - Math.pow((1/(1+annualInterestRate/100/12)),12*numberOfYears));
    }

    public double computeTotal()
    {
        return this.computeMonthly() * 12 * numberOfYears;
    }
}
