package com.providers;

import com.services.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;

    public Wrapper(int size) {
        this.setSize(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size >= 0 ? size : 0;
    }

    //private classes FixedRandom and FixedSelection
    private class FixedRandom implements Cipherable {

        @Override
        public char[] getSecretChars(int seed) {
            Random rand = new Random(seed);
            char digits[] = new char[size];
            for(int i = 0; i < digits.length; i++){
                digits[i] = (char)(rand.nextInt(26) + 65);
            }
            return digits;
        }
    }

    private class FixedSelection implements Cipherable
    {

        @Override
        public char[] getSecretChars(int seed) {
            Random rand = new Random();
            int randomIndex;
            char[] randomSymbolsResult = new char[size];
            char[] randomGeneratedSymbols = new char[seed];

            for(int i = 0; i < randomGeneratedSymbols.length; i++){
                randomGeneratedSymbols[i] = (char)(rand.nextInt(26) + 65);
            }
            for(int i = 0; i < randomSymbolsResult.length; i++){
                randomIndex = rand.nextInt(seed);
                randomSymbolsResult[i] = randomGeneratedSymbols[randomIndex];
            }

            return randomSymbolsResult;
        }
    }

    public Cipherable makeFixedSelection(){
        return new FixedRandom();
    }

    public Cipherable makeFixedRandom(){
        return new FixedSelection();
    }

}
