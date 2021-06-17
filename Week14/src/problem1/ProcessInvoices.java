package problem1;// Exercise 17.11: ProcessInvoices.java
// Processing Invoices with lambdas and streams.
import problem1.Invoice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class ProcessInvoices {
   public static void main(String[] args) {
      Invoice[] invoices = {
              new Invoice(83, "Electric sander", 7, 57.98),
              new Invoice(24, "Power saw", 18, 99.99),
              new Invoice(7, "Sledge hammer", 11, 21.50),
              new Invoice(77, "Hammer", 76, 11.99),
              new Invoice(39, "Lawn mower", 3, 79.50),
              new Invoice(68, "Screwdriver", 106, 6.99),
              new Invoice(56, "Jig saw", 21, 11.00),
              new Invoice(3, "Wrench", 34, 7.50)
      };

      System.out.println("Invoices sorted by part description:");
      //Invoice[] sorted = (Invoice[]) Arrays.stream(invoices).sorted((a, b) -> b.getPartDescription().compareTo(a.getPartDescription())).toArray();

      //System.out.println(Arrays.toString(sorted));

      System.out.printf("%nInvoices sorted by price:%n");
      Invoice[] sorted = Arrays.stream(invoices).sorted(Comparator.comparing(Invoice::getPrice)).toArray(Invoice[]::new);
      System.out.println(Arrays.toString(sorted));

      System.out.printf("%nInvoices mapped to description and quantity:%n");
      Arrays.stream(invoices).collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity)).entrySet().stream().sorted(comparingByValue()).forEach(entry -> System.out.printf("%-20s%-10d\n", entry.getKey(), entry.getValue()));

      System.out.printf("%nInvoices mapped to description and invoice amount:%n");
      Arrays.stream(invoices).collect(Collectors.toMap(Invoice::getPartDescription, invoice -> invoice.getPrice() * invoice.getQuantity())).entrySet().stream().sorted(comparingByValue()).forEach(entry -> System.out.printf("%-20s%-.2f\n", entry.getKey(), entry.getValue()));



      System.out.printf("%nInvoices mapped to description and invoice amount for invoices in the range 200-500:%n");
   }
}


