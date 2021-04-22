public class IntBits {
    private Boolean[] array = new Boolean[32];

    public IntBits(int adapted)
    {
        for(int i = 0; i < array.length; i++)
        {
            int power = (int)Math.pow(2, array.length - i - 1);
            if(power <= adapted)
            {
                array[i] = true;
                adapted -= power;
            }
            else
            {
                array[i] = false;
            }
        }
    }

    public void set(int pos, boolean value)
    {
        array[array.length - pos - 1] = value;
    }

    public boolean get(int pos)
    {
        return array[array.length - pos - 1];
    }

    public static void main(String[] args) {
        IntBits hello = new IntBits(7);
        hello.set(0, false);
        System.out.println(hello.get(2));
    }
}
