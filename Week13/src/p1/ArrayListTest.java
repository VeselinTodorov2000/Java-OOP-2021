package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

public class ArrayListTest {
    public static <E extends Comparable<E>> E max(E[][] list)
    {
        if(list == null || list.length == 0)
        {
            return null;
        }

        ArrayList<E> elements = new ArrayList<>();
        for (int i = 0; i < list.length; i++)
        {
            elements.addAll(Arrays.asList(list[i]));
        }

        return Collections.max(elements);
    }

    public static <E> void shuffle(ArrayList<E> list)
    {
        if(list == null)
        {
            return;
        }
        Collections.shuffle(list);
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list)
    {
        if(list == null)
        {
            return null;
        }
        return Collections.max(list);
    }

    public static <E> ArrayList<E> removeDublicates(ArrayList<E> list)
    {
        if(list == null)
        {
            return null;
        }

        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] args) {
        //a)
        Integer[][] array = new Integer[][]
                {
                        {5, 10, 15, 25},
                        {12, 6, 33, 14},
                        {1, 1, 1, 47}
                };

        int max = max(array);
        System.out.println("Max: " + max);
        
        //b)
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 20; i++)
        {
            list.add("s" + i);
        }

        System.out.println("List: " + list);
        shuffle(list);
        System.out.println("Shuffled list" + list);

        //c)
        System.out.println("Max of list: " + max(list));

        //d)
        ArrayList<Integer> dublicatesList = new ArrayList<>();
        for(int i = 0; i < 20; i++)
        {
            dublicatesList.add(i % 5);
        }
        System.out.println("Non removed: " + dublicatesList);
        System.out.println("Removed: " + removeDublicates(dublicatesList));
    }
}
