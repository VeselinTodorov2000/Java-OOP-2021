package problem2;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListSort {
    public static void main(String[] args) {
        Random random = new Random();

        List<Character> list = IntStream.range(0, 30)
                .mapToObj(number -> (char) ('a' + random.nextInt(26)))
                .collect(Collectors.toList());

        //a)
        List<Character> sorted = list.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Ascending: " + sorted);

        //b)
        sorted = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Descending: " + sorted);

        //c)
        sorted = list.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Ascending and distinct: " + sorted);
    }
}
