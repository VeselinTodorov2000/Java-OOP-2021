package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;


public class Main extends Application {

    private TextInputDialog input;
    private int year;
    private int month;
    private Group group;
    private Scene scene;
    private int offset;

    private void monthYearInput() //method that prompt for month and year
    {
        //input for month
        input = new TextInputDialog();
        input.setTitle("Month input");
        input.setHeaderText("Enter month: ");
        do {
            month = Integer.parseInt(input.showAndWait().get());
        } while(month < 1 || month > 12);

        //input for year
        input = new TextInputDialog();
        input.setTitle("Year input");
        input.setHeaderText("Enter year: ");
        do {
            year = Integer.parseInt(input.showAndWait().get());
        } while(year < 0);
    }

    public void drawDaysOfWeekWithText() //method that draws days of week with words
    {
        //add days of week
        String[] daysOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        Text text;
        for(int i = 0; i < 7; i++)
        {
            text = new Text((i+1)*offset , 30, daysOfWeek[i]); //on same y, but different offset
            group.getChildren().add(text);
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        group = new Group();
        scene = new Scene(group, 350, 250);
        offset = 40; //marks the distance between two elements

        monthYearInput(); //call of monthYearInput
        drawDaysOfWeekWithText(); //call of drawDaysOfWeekWithText

        LocalDate neededMonth = LocalDate.of(year, month, 1); //start of month we are creating calendar on
        LocalDate nextMonth = neededMonth.plusMonths(1); //start of the next month
        primaryStage.setTitle(String.format("Calendar for %s %d", neededMonth.getMonth().name(), year)); //set the title

        int row = 1; //week counter
        while(!neededMonth.equals(nextMonth)) //check if we changed to the next month
        {
            //create text to a certain place depending on the day of week it is
            Text t = new Text(neededMonth.getDayOfWeek().getValue()*offset, 20 + row * offset, String.format("%d", neededMonth.getDayOfMonth()));
            //check for current day
            if(neededMonth.equals(LocalDate.now()))
            {
                t.setStroke(Color.RED);
            }
            group.getChildren().add(t);
            //increment days
            neededMonth = neededMonth.plusDays(1);

            //if we start a new week
            if(neededMonth.getDayOfWeek().getValue() == 1)
            {
                row++;
            }
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
