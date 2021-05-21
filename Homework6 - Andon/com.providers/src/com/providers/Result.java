package com.providers;

import java.util.Arrays;

public class Result {
    private char[] chars;
    private int data;

    public Result(char[] chars, int data) {
        setChars(chars);
        setData(data);
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            this.chars[i] = chars[i];
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("Chars: %s\nResult: %d", Arrays.toString(chars), this.data);
    }
}
