package test;

import com.Functions;
import com.Tabulate;

public class TabulateTest {
    public static void main(String[] args) {
        Functions functions = new Functions();
        Tabulate tabulate = new Tabulate(functions.getSinFunction());

        tabulate.tabulate(2, 50, 1);

        Tabulate.tabulateFunction(2, 50, 1, functions.getExpFunction());
    }
}
