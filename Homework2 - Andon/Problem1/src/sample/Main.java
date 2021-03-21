package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {
    private Group group;
    private Scene scene;
    private TextInputDialog dlg;
    private int month;
    private int year;
    private double space;

    private void readInputMonthAndYear() {
        //input month number
        dlg = new TextInputDialog();
        dlg.setTitle("Input month");
        dlg.setHeaderText(null);
        dlg.setContentText("Enter number of month: ");
        do {
            month = Integer.parseInt(dlg.showAndWait().get());  //getting value from the dialog
        } while (month < 1 || 12 < month);

        //input year number
        dlg = new TextInputDialog();
        dlg.setTitle("Input year");
        dlg.setHeaderText(null);
        dlg.setContentText("Enter year: ");
        do {
            year = Integer.parseInt(dlg.showAndWait().get());   //getting value from the dialog
        } while (year < 0);
    }

    private void printDaysOfWeek() {    //printing names of the days in the week
        String daysOfWeek[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (int i = 0; i < daysOfWeek.length; i++) {
            Text dayOfWeek = new Text(space * (i + 1), space, daysOfWeek[i]);
            dayOfWeek.setStrokeWidth(1);
            dayOfWeek.setStroke(Color.BLACK);
            group.getChildren().add(dayOfWeek);
        }
    }

    private void printChosenMonth() {
        LocalDate dateToPrint = LocalDate.of(year, month, 1);   //first date of the month from the input
        int weekOfMonth = 1;    //number of week of the month
        while (dateToPrint.getMonthValue() == month)    //iterating through each day of the month
        {
            Text date = new Text(space * dateToPrint.getDayOfWeek().getValue(), space * (weekOfMonth + 1),  //setting coordinates for the number in the scene
                    String.format("%d", dateToPrint.getDayOfMonth()));

            //setting the color of the number of the date
            if (dateToPrint.equals(LocalDate.now()))
                date.setStroke(Color.RED);
            else
                date.setStroke(Color.BLACK);

            date.setStrokeWidth(2);
            group.getChildren().add(date);  //adding the date number in the scene

            if (dateToPrint.getDayOfWeek().getValue() == 7) //if it is sunday
                weekOfMonth++;  //go to next week

            dateToPrint = dateToPrint.plusDays(1);  //going on the next day
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        group = new Group();
        scene = new Scene(group, 450, 300);
        space = 40; //distance between numbers of days and names of the days in the week in the calendar

        readInputMonthAndYear();    //reading input
        printDaysOfWeek();
        printChosenMonth();

        primaryStage.setTitle("Calendar for the chosen month");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
