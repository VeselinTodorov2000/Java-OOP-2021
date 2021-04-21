public class ComplexNumber
{
    private double imaginaryPart;
    private double realPart;

    public ComplexNumber(double imaginaryPart, double realPart) {
        this.imaginaryPart = imaginaryPart;
        this.realPart = realPart;
    }

    public ComplexNumber add(ComplexNumber other)
    {
        return new ComplexNumber(this.imaginaryPart + other.getImaginaryPart(), this.realPart + other.getRealPart());
    }

    public double getAngle()
    {
        return Math.atan2(imaginaryPart, realPart);
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public double getMagnitude()
    {
        return Math.sqrt(imaginaryPart * imaginaryPart + realPart * realPart);
    }

    public double getRealPart() {
        return realPart;
    }
}
