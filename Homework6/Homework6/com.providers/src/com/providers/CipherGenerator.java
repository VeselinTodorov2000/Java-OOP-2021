package com.providers;

import com.services.Cipherable;

public class CipherGenerator {
    public static Result countDistinct(Cipherable cipher, int seed)
    {
        char[] randomGeneratedSymbols = cipher.getSecretChars(seed);
        int uniqueSymbolsCount = 0;
        boolean unique;

        for(int i = 0; i < randomGeneratedSymbols.length; i++) {
            unique = true;
            for(int j = 0; j < randomGeneratedSymbols.length; j++){
                if(randomGeneratedSymbols[i] == randomGeneratedSymbols[j] && i != j){
                    unique = false;
                    break;
                }
            }

            if(unique){
                uniqueSymbolsCount++;
            }
        }

        return new Result(randomGeneratedSymbols, uniqueSymbolsCount);
    }
}
