package routeCipher;

public class RouteCipher {
    private int key;

    public RouteCipher(int key)
    {
        setKey(key);
    }

    public int getKey()
    {
        return this.key;
    }

    public void setKey(int key)
    {
        this.key = key >= 1 ? key : 1;
    }

    public String encrypt(String plainText) {
        char grid[][] = new char[(int) Math.ceil(plainText.length()/ (double) key)][key];
        String encrypted = "";
        return encrypted;
    }

    public String decrypt(String cipherText) {
        return null;
    }

    public String toString()
    {
        return null;
    }
}
