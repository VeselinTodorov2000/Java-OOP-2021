package cipher;

public class RouteCipher {
    private int key;

    public RouteCipher(int key) {
        setKey(key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String encrypt(String plainText) {
        if (key == 0) return plainText; //if the key is 0, there are no changes in the text

        char[] plainTextChars = plainText.toCharArray();    //converting from string to char array
        int columns = Math.abs(key);
        int rows =
          plainTextChars.length % columns == 0 ? plainTextChars.length / columns : (plainTextChars.length / columns) + 1;
        char[][] plainTextMatrix = new char[rows][columns];
        //writing elements in plainTextMatrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i == rows - 1) && (j >= plainTextChars.length % key))  //if there are empty positions on the last row
                    plainTextMatrix[i][j] = 'X';    //completing to a rectangular matrix
                else
                    plainTextMatrix[i][j] = plainTextChars[i * columns + j];    //copying from plainTextChars
            }
        }

        char[] cipherTextChars = new char[rows*columns];
        int maxLevel =        //max level of going into the matrix in spiral
                (Math.min(rows, columns) % 2 == 0) ? Math.min(rows, columns) / 2 : Math.min(rows, columns) / 2 + 1;
        int index = 0;  //position in cipherTextChars for writing in it

        //encrypting
        if (key > 0) {      //starting from the top left corner and moving counterclockwise
            for (int level = 0; level < maxLevel; level++, rows -= 2, columns -= 2) {   //going inside in the matrix
                for (int i = 0; i < rows && index < cipherTextChars.length; i++, index++) {                 //copying the first column
                    cipherTextChars[index] = plainTextMatrix[i + level][level];
                }

                for (int i = 1; i < columns && index < cipherTextChars.length; i++, index++) {              //copying the last row
                    cipherTextChars[index] = plainTextMatrix[rows - 1 + level][i + level];
                }

                for (int i = rows - 2; i >= 0 && index < cipherTextChars.length; i--, index++) {            //copying the last column
                    cipherTextChars[index] = plainTextMatrix[i + level][columns - 1 + level];
                }

                for (int i = columns - 2; i >= 1 && index < cipherTextChars.length; i--, index++) {         //copying the first row
                    cipherTextChars[index] = plainTextMatrix[level][i + level];
                }
            }
        } else {            //starting from the bottom right corner and moving counterclockwise
            for (int level = 0; level < maxLevel; level++, rows -= 2, columns -= 2) {   //going inside in the matrix
                for (int i = rows - 1; i >= 0 && index < cipherTextChars.length; i--, index++) {            //copying the last column
                    cipherTextChars[index] = plainTextMatrix[i + level][columns - 1 + level];
                }

                for (int i = columns - 2; i >= 0 && index < cipherTextChars.length; i--, index++) {         //copying the first row
                    cipherTextChars[index] = plainTextMatrix[level][i + level];
                }

                for (int i = 1; i < rows && index < cipherTextChars.length; i++, index++) {                 //copying the first column
                    cipherTextChars[index] = plainTextMatrix[i + level][level];
                }

                for (int i = 1; i < columns - 1 && index < cipherTextChars.length; i++, index++) {          //copying the last row
                    cipherTextChars[index] = plainTextMatrix[rows - 1 + level][i + level];
                }
            }
        }

        return new String(cipherTextChars);
    }

    public String decrypt(String cipherText) {
        if (key == 0) return cipherText;     //if the key is 0, there are no changes in the text

        char[] cipherTextChars = cipherText.toCharArray();  //converting from string to char array
        int columns = Math.abs(key);
        int rows = cipherTextChars.length / columns;
        char[][] cipherTextMatrix = new char[rows][columns];

        //writing elements in cipherTextMatrix
        int maxLevel =        //max level of going into the matrix
                (Math.min(rows, columns) % 2 == 0) ? Math.min(rows, columns) / 2 : Math.min(rows, columns) / 2 + 1;
        int index = 0;  //position in cipherTextChars for reading from it

        if (key > 0) {      //starting from the top left corner and moving counterclockwise
            for (int level = 0; level < maxLevel; level++, rows -= 2, columns -= 2) {   //going inside in the matrix
                for (int i = 0; i < rows && index < cipherTextChars.length; i++, index++) {                 //copying the first column
                    cipherTextMatrix[i + level][level] = cipherTextChars[index];
                }

                for (int i = 1; i < columns && index < cipherTextChars.length; i++, index++) {              //copying the last row
                    cipherTextMatrix[rows - 1 + level][i + level] = cipherTextChars[index];
                }

                for (int i = rows - 2; i >= 0 && index < cipherTextChars.length; i--, index++) {            //copying the last column
                    cipherTextMatrix[i + level][columns - 1 + level] = cipherTextChars[index];
                }

                for (int i = columns - 2; i >= 1 && index < cipherTextChars.length; i--, index++) {         //copying the first row
                    cipherTextMatrix[level][i + level] = cipherTextChars[index];
                }
            }
        } else {            //starting from the bottom right corner and moving counterclockwise
            for (int level = 0; level < maxLevel; level++, rows -= 2, columns -= 2) {   //going inside in the matrix
                for (int i = rows - 1; i >= 0 && index < cipherTextChars.length; i--, index++) {            //copying the last column
                    cipherTextMatrix[i + level][columns - 1 + level] = cipherTextChars[index];
                }

                for (int i = columns - 2; i >= 0 && index < cipherTextChars.length; i--, index++) {         //copying the first row
                    cipherTextMatrix[level][i + level] = cipherTextChars[index];
                }

                for (int i = 1; i < rows && index < cipherTextChars.length; i++, index++) {                 //copying the first column
                    cipherTextMatrix[i + level][level] = cipherTextChars[index];
                }

                for (int i = 1; i < columns - 1 && index < cipherTextChars.length; i++, index++) {              //copying the last row
                    cipherTextMatrix[rows - 1 + level][i + level] = cipherTextChars[index];
                }
            }
        }

        //resetting the values of rows and columns as in the beginning
        columns = Math.abs(key);
        rows = cipherTextChars.length / columns;

        int bufferSymbols = 0;  //symbols that are inserted in the end to complete the rectangular matrix
        for (int i = 1; i < columns; i++){  //counting the buffer symbols in the last row (at least the first letter is from the plain text)
            if (cipherTextMatrix[rows-1][i] == 'X') //check if it is the symbol used for buffer symbols
                bufferSymbols++;
        }

        char[] plainTextChars = new char[cipherTextChars.length - bufferSymbols];   //allocating memory for the plain text without the buffer symbols
        index = 0;  //resetting the value to begin writing in plainTextChars from position 0
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (index == plainTextChars.length) break;  //if we reach the end of the plain text, break
                plainTextChars[index] = cipherTextMatrix[i][j];
                index++;
            }
        }

        return new String(plainTextChars);
    }

    public static String prepareString(String text){
        text = text.toUpperCase();  //converting to uppercase
        char[] textChars = text.toCharArray();  //converting from string to char array

        int validatedLength = 0;    //length of the text when non-letter symbols are removed
        for (int i = 0; i < textChars.length; i++){
            if (Character.isLetter(textChars[i]))
                validatedLength++;
        }

        char[] validatedText = new char[validatedLength];
        for (int i = 0, nonLetters = 0; i < textChars.length; i++){
            if (Character.isLetter(textChars[i]))   //if the current element is a letter, copy it in the validatedText
                validatedText[i - nonLetters] = textChars[i];
            else                                    //if the current element is not a letter, continue to next element
                nonLetters++;
        }

        return new String(validatedText);
    }

    @Override
    public String toString() {
        return String.format("Route cipher key: %d", key);
    }
}
