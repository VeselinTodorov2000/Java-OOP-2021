package p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>();
        aList.addAll(Arrays.asList(new String[]{"Лили", "Мария", "Георги", "Илия", "Цвета", "Георги"}));
        ArrayList<String> bList = new ArrayList<>(Arrays.asList(new String[]{"Лили", "Георги"}));

        Iterator<String> aIterator = aList.iterator();
        Iterator<String> bIterator;

        String aText;
        StringBuilder common = new StringBuilder();
        while(aIterator.hasNext())
        {
            bIterator = bList.iterator();
            aText = aIterator.next();
            while(bIterator.hasNext())
            {
                if(aText.equals(bIterator.next()))
                {
                    common.append(aText).append(", ");
                }
            }
        }

        System.out.printf("Common elements: %s\n", common.length() == 0 ? "none" : common.toString());

        //e
        ArrayList<String> list = new ArrayList<>(Arrays.asList(new String[]{"Лили", "Георги"}));
        ListIterator<String> nameIterator = list.listIterator();
        System.out.println(list);
        while(nameIterator.hasNext())
        {
            if(nameIterator.next().equals("Георги"))
            {
                list.add(nameIterator.nextIndex(), "Симеон");
                break;
            }
        }
        System.out.println(list);

    }
}
