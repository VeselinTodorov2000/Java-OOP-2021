package com.providers;

import java.util.Arrays;

public class Result {
    private char[] chars;
    private int data;

    public Result(char[] chars, int data) {
        this.setChars(chars);
        this.setData(data);
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        if(chars == null)
        {
            this.chars = null;
        }
        else
        {
            this.chars = new char[chars.length + 1];
            for(int i = 0; i < chars.length; i++)
            {
                this.chars[i] = chars[i];
            }
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data >= 0 ? data : 0;
    }

    @Override
    public String toString() {
        return String.format("Chars: %s%nResult: %d", Arrays.toString(this.chars), this.data);
    }
}
