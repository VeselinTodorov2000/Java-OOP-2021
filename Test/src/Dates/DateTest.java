package Dates;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.util.Locale;
import java.util.Scanner;

public class DateTest
{
    public static void main(String[] args) {
        /*LocalDate today = LocalDate.now();
        LocalDate firstDayTogether = LocalDate.of( 2018, 12, 9 );
        LocalDate birthday = LocalDate.of( 2001, Month.FEBRUARY, 21 );
        NumberFormat nf = NumberFormat.getPercentInstance(Locale.ENGLISH);
        System.out.println( nf.format((double)firstDayTogether.datesUntil(today).count() / birthday.datesUntil(today).count()));*/

        Scanner dateInput = new Scanner(System.in);
        int month, year;
        System.out.print("Enter month: ");
        month = dateInput.nextInt();

        System.out.print("Enter year: ");
        year = dateInput.nextInt();

        LocalDate calendar = LocalDate.of(year, month, 1).with(TemporalAdjuster)
    }
}
