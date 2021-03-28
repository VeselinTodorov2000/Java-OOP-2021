package cipher;

public class TransCipher 
{
    private int key;

    public TransCipher(String keyText)
    {
        this.key = keyText.toCharArray().length;
    } //end of constructor

    public String encrypt(String plainText)
    {
        char[] plainTextArray = plainText.toCharArray();
        char[][] cipherArray = new char[(int) Math.ceil ((double)plainTextArray.length / this.key)][this.key];

        for(int row = 0, col = 0, i = 0; i < plainTextArray.length; i++)
        {
            cipherArray[row][col++] = plainTextArray[i];

            if(col == this.key)
            {
                row++;
                col = 0;
            }
        }

        String encryptedText = "";

        for(int col = 0; col < cipherArray[0].length; col++)
        {
            for(int row = 0; row < cipherArray.length; row++)
            {
                encryptedText += cipherArray[row][col];
            }
        }

        return encryptedText;
    }

    public String decrypt(String encryptedText)
    {
        char[] encryptedTextArray = encryptedText.toCharArray();
        char[][] cipherArray = new char[this.key][(int) Math.ceil ((double)encryptedTextArray.length / this.key)];

        for(int i = 0, row = 0; row < cipherArray.length; row++)
        {
            for(int col = 0; col < cipherArray[row].length; col++)
            {
                cipherArray[row][col] = encryptedTextArray[i];
                i++;
            }
        }

        String decryptedArray = "";

        for(int col = 0; col < cipherArray[0].length; col++)
        {
            for(int row = 0; row < cipherArray.length; row++)
            {
                decryptedArray += cipherArray[row][col];
            }
        }

        return decryptedArray;
    }
} //end of class TransCipher
