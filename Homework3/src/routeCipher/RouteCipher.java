package routeCipher;

public class RouteCipher {
    //data fields
    private int key;

    //method for encrypt with a positive key
    private String encryptPositive(char[][] grid, int startX, int startY, int rows, int cols, String encrypted)
    {
        //base case
        if(startX >= rows || startY >= cols)
        {
            return encrypted;
        }

        //first column
        for (int i = startY; i < rows; i++)
            encrypted = String.format("%s%c", encrypted, grid[i][startX]);

        //last row
        for (int i = startX + 1; i < cols; i++)
            encrypted = String.format("%s%c", encrypted ,grid[rows - 1][i]);

        //last column if possible
        if ((cols - 1) != startX)
            for (int i = rows - 2; i >= startY; i--)
                encrypted = String.format("%s%c", encrypted, grid[i][cols - 1]);

        //first row if possible
        if ((rows - 1) != startY)
            for (int i = cols - 2; i > startX; i--)
                encrypted = String.format("%s%c", encrypted, grid[startY][i]);

        return encryptPositive(grid, startX + 1, startY + 1, rows - 1, cols - 1, encrypted);
    }

    //method for encrypt with a negative key
    String encryptNegative(char[][] grid, int startX, int startY, int upX, int upY, String encrypted)
    {
        //base case
        if(startX < upX || startY < upY)
        {
            return encrypted;
        }

        //last column
        for (int i = startY; i >= upY; i--)
            encrypted = String.format("%s%c", encrypted, grid[i][startX]);

        //first row
        for (int i = startX - 1; i >= upX; i--)
            encrypted = String.format("%s%c", encrypted, grid[upY][i]);

        //first column if possible
        if (upX != startX)
            for (int i = upY + 1; i < startY; i++)
                encrypted = String.format("%s%c", encrypted, grid[i][upX]);

        //last row if possible
        if (upY != startY)
            for (int i = upX; i < startX; i++) {
                encrypted = String.format("%s%c", encrypted, grid[startY][i]);
            }

        return encryptNegative(grid, startX - 1, startY - 1, upX + 1, upY + 1, encrypted);
    }

    //method to decrypt if key is positive
    private char[][] decryptGridPositive(char[][] grid, int startX, int startY, int rows, int cols, char[] cipher, int index)
    {
        //base case
        if(index == cipher.length)
        {
            return grid;
        }

        for (int i = startY; i < rows; i++)
        {
            grid[i][startX] = cipher[index];
            index++;
        }

        for (int i = startX + 1; i < cols; i++)
        {
            grid[rows - 1][i] = cipher[index];
            index++;
        }

        if ((cols - 1) != startX)
            for (int i = rows - 2; i >= startY; i--)
            {
                grid[i][cols - 1] = cipher[index];
                index++;
            }

        if ((rows - 1) != startY)
            for (int i = cols - 2; i > startX; i--)
            {
                grid[startY][i] = cipher[index];
                index++;
            }

        return decryptGridPositive(grid, startX + 1, startY + 1, rows - 1, cols - 1, cipher, index);
    }

    //method to decrypt if key is negative
    private char[][] decryptGridNegative(char[][] grid, int startX, int startY, int upX, int upY, char[] cipher, int index)
    {
        if(index == cipher.length)
        {
            return grid;
        }

        for (int i = startY; i >= upY; i--) {
            grid[i][startX] = cipher[index];
            index++;
        }

        for (int i = startX - 1; i >= upX; i--)
        {
            grid[upY][i] = cipher[index];
            index++;
        }

        if (upX != startX)
            for (int i = upY + 1; i < startY; i++) {
                grid[i][upX] = cipher[index];
                index++;
            }

        if (upY != startY)
            for (int i = upX; i < startX; i++) {
                grid[startY][i] = cipher[index];
                index++;
            }

        return decryptGridNegative(grid, startX - 1, startY - 1, upX + 1, upY + 1, cipher, index);
    }

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
        this.key = key;
    }

    public String encrypt(String plainText) {
        char[] plainTextIntoChars = plainText.toCharArray();
        char grid[][] = new char[(int) Math.ceil(plainText.length()/ (double) Math.abs(key))][Math.abs(key)];
        int index = 0; //marks the index of symbol in plainText array
        for(int row = 0; row < grid.length; row++)
                {
                    for(int col = 0; col < grid[row].length; col++)
                    {
                        if(index >= plainTextIntoChars.length)
                        {
                            grid[row][col] = 'X';
                        }
                        else {
                            grid[row][col] = plainTextIntoChars[index];
                            index++;
                        }
                    }
        }

        if(key > 0)
        {
            return encryptPositive(grid, 0, 0, grid.length, grid[0].length,"");
        }
        else
        {
            return encryptNegative(grid, grid[0].length-1, grid.length-1, 0, 0, "");
        }
    }

    public String decrypt(String cipherText) {
        char[] cipherTextIntoChars = cipherText.toCharArray();
        char grid[][] = new char[(int) Math.ceil(cipherText.length()/ (double) Math.abs(key))][Math.abs(key)];
        if(key > 0)
        {
            grid = decryptGridPositive(grid, 0, 0, grid.length, grid[0].length, cipherTextIntoChars, 0);
        }
        else
        {
            grid = decryptGridNegative(grid, grid[0].length - 1, grid.length - 1, 0, 0, cipherTextIntoChars, 0);
        }
        String decrypted = "";

        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[row].length; col++)
            {
                if(grid[row][col] == 'X')
                {
                    return decrypted;
                }
                else {
                    decrypted = String.format("%s%c", decrypted ,grid[row][col]);
                }
            }
        }

        return decrypted;
    }

    public String toString()
    {
        return String.format("The key is %d", key);
    }
}
