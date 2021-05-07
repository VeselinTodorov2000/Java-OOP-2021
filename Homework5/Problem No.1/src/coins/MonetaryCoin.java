package coins;

public class MonetaryCoin extends Coin
{
    private int value;

    public MonetaryCoin(Face face, int faceValue) {
        super(face);
        this.value = faceValue;
    }

    public MonetaryCoin(int faceValue) {
        this(Face.HEAD, faceValue);
    }

    public MonetaryCoin() {
        this(Face.HEAD, 10);
    }

    public int getFaceValue() {
        return value;
    }

    public void setFaceValue(int faceValue) {
        this.value = faceValue;
    }

    @Override
    public String toString() {
        return String.format("Value %d ", value) + super.toString();
    }
}
