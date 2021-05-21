package com.providers;

import com.services.Cipherable;

public class CipherGenerator {
    public static Result countDistinct(Cipherable cipher, int seed) {
        int countDistinct = 0;
        char[] generatedChars = cipher.getSecretChars(seed);

        boolean isDistinct;

        for (int i = 0; i < generatedChars.length; i++) {
            isDistinct = true;

            for (int j = 0; j < generatedChars.length; j++) {
                if (i != j && generatedChars[i] == generatedChars[j]) {
                    isDistinct = false;
                    break;
                }
            }

            if (isDistinct)
                countDistinct++;
        }

        return new Result(generatedChars, countDistinct);
    }
}
