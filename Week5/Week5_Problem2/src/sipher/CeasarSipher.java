package sipher;

public class CeasarSipher
{
    private int SHIFT_LENGHT;

    public CeasarSipher() {
        setSHIFT_LENGHT(3);
    }

    public CeasarSipher(int SHIFT_LENGHT) {
        setSHIFT_LENGHT(SHIFT_LENGHT);
    }

    public int getSHIFT_LENGHT() {
        return SHIFT_LENGHT;
    }

    public void setSHIFT_LENGHT(int SHIFT_LENGHT) {
        if(SHIFT_LENGHT > 26 || SHIFT_LENGHT < -26)
        {
            SHIFT_LENGHT = SHIFT_LENGHT % 26;
        }
        if(SHIFT_LENGHT != 0)
        {
            this.SHIFT_LENGHT = SHIFT_LENGHT;
        }
        else
        {
            this.SHIFT_LENGHT = 3;
        }
    }

    public String encrypt(String plainText)
    {
        char[] plainTextChars = plainText.toCharArray();
        char[] cipherTextChars = new char[plainTextChars.length];

        for(int i = 0; i < plainTextChars.length; i++)
        {
            cipherTextChars[i] = (char)((plainTextChars[i] - 'A' + SHIFT_LENGHT + 26) % 26 + 'A');
        }

        return new String(cipherTextChars);
    }

    public String decrypt(String cipherText)
    {
        char[] cipherTextChars = cipherText.toCharArray();
        char[] plainTextChars = new char[cipherTextChars.length];

        for(int i = 0; i < plainTextChars.length; i++)
        {
            plainTextChars[i] = (char)((cipherTextChars[i] - 'A' - SHIFT_LENGHT + 26) % 26 + 'A');
        }

        return new String(plainTextChars);
    }

    @Override
    public String toString() {
        return String.format("Caesar sipher lenght is %d", SHIFT_LENGHT);
    }
}
