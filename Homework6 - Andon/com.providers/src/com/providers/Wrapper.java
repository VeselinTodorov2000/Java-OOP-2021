package com.providers;

import com.services.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;

    private class FixedRandom implements Cipherable {
        @Override
        public char[] getSecretChars(int seed) {
            Random random = new Random((long) seed);
            char[] secretChars = new char[size];
            for(int i = 0; i < size; i++){
                secretChars[i] = (char)(random.nextInt((int) ('Z' - 'A')) + (int) 'A');
            }
            return secretChars;
        }
    }

    private class FixedSelection implements Cipherable {
        @Override
        public char[] getSecretChars(int seed) {
            Random random = new Random();
            char[] secretCharsToGenerate = new char[seed];
            char[] secretCharsToReturn = new char[size];
            for(int i = 0; i < seed; i++){
                secretCharsToGenerate[i] = (char)(random.nextInt((int) ('Z' - 'A')) + (int) 'A');
            }

            //int smallerSize = Math.min(size, seed);
            for (int i = 0; i < size; i++) {
                secretCharsToReturn[i] = secretCharsToGenerate[i % seed];
            }

            return secretCharsToReturn;
        }
    }

    public Cipherable makeFixedSelection() {
        return new FixedRandom();
    }

    public Cipherable makeFixedRandom() {
        return new FixedSelection();
    }

    public Wrapper(int size) {
        setSize(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size > 0 ? size : 0;
    }
}
