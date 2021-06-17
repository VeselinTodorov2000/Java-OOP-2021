package p1a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaDemo
{
    public static void main(String[] args)
    {
        Predicate<Salesperson> predicate1 = salesperson -> salesperson.getNumSales() > 1200;
// да се инициализира
        Predicate<Salesperson> predicate2 = salesperson -> salesperson.getSalary() > 900;
// да се инициализира
        Predicate<Salesperson> predicate = salesperson -> predicate1.test(salesperson) && predicate2.test(salesperson);
// да се инициализира
        Consumer<Salesperson> consumer1 = salesperson -> {salesperson.setSalary(salesperson.getSalary()*1.05);
            System.out.println(salesperson);};

// да се инициализира
        Consumer<Salesperson> consumer2 = salesperson ->
        {
            if(predicate1.test(salesperson)) {
                salesperson.setSalary(salesperson.getSalary() * 1.05);
            }else
            {
                salesperson.setSalary(salesperson.getSalary() * 0.98);
            }

            System.out.println(salesperson);
        };

// да се инициализира
        Comparator<Salesperson> comparator1;
// да се инициализира
        Comparator<Salesperson> comparator2;
// да се инициализира
        Salesperson[] salespersons =
                {
                        new Salesperson("John Doe", 2000, 949),
                        new Salesperson("Jane Doe", 3900, 1500),
                        // да се добавят още 10 обекти от тип Salesperson
                        // или да се инициализират с Random стойности
                };
        List<Salesperson> listOfSalespersons = new
                ArrayList<>();
        // обектите на salespersons да се запишат в listOfSalespersons
        for (Salesperson salesperson: salespersons)
        {
            applyBonus(salesperson, predicate1,
                    consumer1);
            System.out.println(salesperson);
            salesperson.printNumSales(salesperson);

        }
        for (Salesperson salesperson: salespersons)
        {
            applyBonus(salesperson, predicate2, consumer2);
            System.out.println(salesperson);
        }
        sort(listOfSalespersons, comparator1);
        System.out.println(listOfSalespersons); sort(listOfSalespersons, comparator2);
        System.out.println(listOfSalespersons);

    }

    public static void applyBonus(Salesperson salesperson,
                                  Predicate<Salesperson>
                                          predicate,
                                  Consumer<Salesperson>
                                          consumer)
    {
// Напишете if команда, където използвайте predicate
// за да определите дали да изпълните consumer
// Изпълнете consumer, когато условието на if командата е изпълнено
    }
    public static void applyBonus(List<Salesperson>
                                          salespersons,
                                  Predicate<Salesperson>
                                          predicate,
                                  Consumer<Salesperson>
                                          consumer)
    {
// Напишете if команда, където използвайте predicate
// за да определите дали да изпълните consumer
// Изпълнете consumer, когато условието на if командата е изпълнено
    }
    public static void sort(List<Salesperson>
                                    salespersons,
                            Comparator<Salesperson>
                                    comparator)
    {
// Сортирайте salespersons като използвате comparator
    }
    public static void group(List<Salesperson>
                                     salespersons)
    {
// Групирайте имената на salespersons по първата буква в
// името изведете отделните групи на стандартен изход
    }
}