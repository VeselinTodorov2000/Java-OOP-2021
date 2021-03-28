package zip;

public class BarCode {

    private final static int[][] code = {{0,0,0,1,1},
                                         {0,0,1,0,1},
                                         {0,0,1,1,0},
                                         {0,1,0,0,1},
                                         {0,1,0,1,0},
                                         {0,1,1,0,0},
                                         {1,0,0,0,1},
                                         {1,0,0,1,0},
                                         {1,0,1,0,0},
                                         {1,1,0,0,0}};
    private String digitEncoder(int i) {
        if (i == 0) {
            i = 10;
        }
        String zipDigitCode = "";
        for(int cnt = 0; cnt < code[i-1].length; cnt++)
        {
            zipDigitCode += code[i-1][cnt] == 1 ? '|' : ':';
            zipDigitCode += ' ';
        }
        return zipDigitCode;
    }

    public String decode(int zipCode)
    {
        String decoded = "";
        while(zipCode != 0)
        {
            decoded += digitEncoder(zipCode % 10);
            zipCode /= 10;
        }

        return decoded;
    }
}
