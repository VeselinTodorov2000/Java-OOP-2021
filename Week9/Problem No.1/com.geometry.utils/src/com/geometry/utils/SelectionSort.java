package com.geometry.utils;

public class SelectionSort {
    public static void sortArray(Comparable[] arr) {
        int indexMin = 0;
        for(int i = 0; i < arr.length - 1; i++)
        {
            indexMin = i;
            for(int j = i + 1; j < arr.length - 1; j++)
            {
                if(arr[j].compareTo(arr[indexMin]) < 0)
                {
                    indexMin = j;
                }
            }
            Comparable temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
        }
    }
}
