package p3;

import java.util.ArrayList;

public class NoDublicates {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(-3);
        list.add(12);
        list.add(3);
        list.add(2);

        ArrayList<Integer> noDublicates = removeDublicate(list);
        System.out.println("list: ");
        for (Integer e: noDublicates)
        {
            System.out.println(e);
        }
    }
    public static <E> ArrayList<E> removeDublicate(ArrayList<E> list)
    {
        if(list == null)
        {
            return null;
        }
        ArrayList<E> noDublicates = new ArrayList<>();

        for (E e: list)
        {
            if(!noDublicates.contains(e))
            {
                noDublicates.add(e);
            }
        }
        return noDublicates;
    }
}
