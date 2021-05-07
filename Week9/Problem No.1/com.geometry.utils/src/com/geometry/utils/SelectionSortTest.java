package com.geometry.utils;

import com.geometry.types.Circle;
import com.geometry.types.Cylinder;
import com.geometry.types.Point;

import java.util.Random;

public class SelectionSortTest {
    private static Comparable[] arrComparable = new Comparable[9];

    public static void main(String[] args) {
        Random rand = new Random();
        for(int i = 0; i < 3; i++)
        {
            arrComparable[i] = new Point(rand.nextInt(41) + 10, rand.nextInt(41) + 10);
        }
        for(int i = 3; i < 6; i++)
        {
            arrComparable[i] = new Circle((Point)arrComparable[i - 3], rand.nextInt(21) + 10);
        }
        for(int i = 6; i < 9; i++)
        {
            arrComparable[i] = new Cylinder((Circle)arrComparable[i - 3], rand.nextInt(51) + 10);
        }

        for(int i = 0; i < arrComparable.length; i++)
        {
            System.out.println(arrComparable[i].toString());
        }
        SelectionSort.sortArray(arrComparable);
        for(int i = 0; i < arrComparable.length; i++)
        {
            System.out.println(arrComparable[i].toString());
        }
    }
}
