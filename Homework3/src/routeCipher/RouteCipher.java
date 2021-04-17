package routeCipher;

public class RouteCipher {
    //data fields
    private int key;

    //method for encrypt with a positive key
    private String encryptPositive(char[][] grid, int startX, int startY, int rows, int cols, char[] encrypted, int index)
    {
        //base case
        if(startX >= rows || startY >= cols)
        {
            return new String(encrypted);
        }

        //first column
        for (int i = startY; i < rows; i++)
            encrypted[index++] = grid[i][startX];

        //last row
        for (int i = startX + 1; i < cols; i++)
            encrypted[index++] = grid[rows - 1][i];

        //last column if possible
        if ((cols - 1) != startX)
            for (int i = rows - 2; i >= startY; i--)
                encrypted[index++] = grid[i][cols - 1];

        //first row if possible
        if ((rows - 1) != startY)
            for (int i = cols - 2; i > startX; i--)
                encrypted[index++] = grid[startY][i];

        return encryptPositive(grid, startX + 1, startY + 1, rows - 1, cols - 1, encrypted, index);
    }

    //method for encrypt with a negative key
    private String encryptNegative(char[][] grid, int startX, int startY, int upX, int upY, char[] encrypted, int index)
    {
        //base case
        if(startX < upX || startY < upY)
        {
            return new String(encrypted);
        }

        //last column
        for (int i = startY; i >= upY; i--)
            encrypted[index++] = grid[i][startX];

        //first row
        for (int i = startX - 1; i >= upX; i--)
            encrypted[index++] = grid[upY][i];

        //first column if possible
        if (upX != startX)
            for (int i = upY + 1; i < startY; i++)
                encrypted[index++] = grid[i][upX];

        //last row if possible
        if (upY != startY)
            for (int i = upX; i < startX; i++) {
                encrypted[index++] = grid[startY][i];
            }

        return encryptNegative(grid, startX - 1, startY - 1, upX + 1, upY + 1, encrypted, index);
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

    //constructor
    public RouteCipher(int key)
    {
        setKey(key);
    }

    //getter for key
    public int getKey()
    {
        return this.key;
    }

    //setter for key
    public void setKey(int key)
    {
        this.key = key != 0 ? key : 1;
    }

    //encrypt method
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
            return encryptPositive(grid, 0, 0, grid.length, grid[0].length, new char[grid.length * grid[0].length],0);
        }
        else
        {
            return encryptNegative(grid, grid[0].length-1, grid.length-1, 0, 0, new char[grid.length * grid[0].length], 0);
        }
    }

    //decrypt method
    public String decrypt(String cipherText)
    {
        char[] cipherTextIntoChars = cipherText.toCharArray();
        char grid[][] = new char[(int) Math.ceil(cipherText.length()/ (double) Math.abs(key))][Math.abs(key)];

        //create grid from ciphertext
        if(key > 0)
        {
            grid = decryptGridPositive(grid, 0, 0, grid.length, grid[0].length, cipherTextIntoChars, 0);
        }
        else
        {
            grid = decryptGridNegative(grid, grid[0].length - 1, grid.length - 1, 0, 0, cipherTextIntoChars, 0);
        }

        //create container for decrypted text
        char[] decrypted = new char[grid.length * grid[0].length];
        int index = 0;

        //fill container and return it as a string
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[row].length; col++)
            {
                if(grid[row][col] == 'X')
                {
                    return new String(decrypted);
                }
                else
                    {
                    decrypted[index++] = grid[row][col];
                }
            }
        }

        return new String(decrypted);
    }

    //toString method
    public String toString()
    {
        return new String("The key is " + key);
    }
}
