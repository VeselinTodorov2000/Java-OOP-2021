public class Bits {
    private byte integer;

    public Bits(byte adapted)
    {
        integer = adapted;
    }

    public byte reverseBits()
    {
        byte reversed = 0;
        int cnt = 8;
        while(integer != 0)
        {
            reversed += (byte)Math.pow((integer & 1) * 2, cnt--);
            System.out.println(integer&1);
            integer >>= 1;
        }

        return reversed;
    }

    public static void main(String[] args) {
        Bits b = new Bits((byte)11);
        System.out.println(b.reverseBits());
    }
}
