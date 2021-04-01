package sort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort
{
    public static int[] merge(int[] list1, int[] list2)
    {
        int[] mergeSorted = new int[list1.length + list2.length];
        int cnt1 = 0, cnt2 = 0;
        int i = 0;
        for(;cnt1 < list1.length && cnt2 < list2.length; i++)
        {
            if(list1[cnt1] < list2[cnt2])
            {
                mergeSorted[i] = list1[cnt1];
                cnt1++;
            }
            else
            {
                mergeSorted[i] = list2[cnt2];
                cnt2++;
            }
        }

        while(cnt1 < list1.length)
        {
            mergeSorted[i] = list1[cnt1];
            i++;
            cnt1++;
        }

        while(cnt2 < list2.length)
        {
            mergeSorted[i] = list2[cnt2];
            i++;
            cnt2++;
        }

        return mergeSorted;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //input list 1
        int sizeList1;
        System.out.print("Enter list 1: ");
        sizeList1 = input.nextInt();
        int[] list1 = new int[sizeList1];
        for(int i = 0; i < list1.length; i++)
        {
            list1[i] = input.nextInt();
        }

        //input list 2
        int sizeList2;
        System.out.print("Enter list 2: ");
        sizeList2 = input.nextInt();
        int[] list2 = new int[sizeList2];
        for(int i = 0; i < list2.length; i++)
        {
            list2[i] = input.nextInt();
        }

        int merged[] = merge(list1, list2);
        System.out.print("Merge sorted list is: ");
        for(int i = 0; i < merged.length; i++)
        {
            System.out.printf("%d ", merged[i]);
        }
    }
}
