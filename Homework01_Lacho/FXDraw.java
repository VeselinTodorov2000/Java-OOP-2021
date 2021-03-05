package task2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class FXDraw extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //initializing variables
        short   widthWindow = 600,  //window width in pixels
                heightWindow = 500, //window height in pixels
                numberOfLines = 20; //number of lines

        Group group = new Group();

        //calculating lines coordinates and adding them to the group

        for(int i = 0; i < numberOfLines; ++i)
        {
            Line line = new Line(0, i * (heightWindow / numberOfLines), i * (widthWindow / numberOfLines), heightWindow);
            line.setStroke(Color.ORANGE);
            line.setStrokeWidth(1);

            group.getChildren().add(line);
        }

        for(int i = 0; i < numberOfLines; ++i)
        {
            Line line = new Line(widthWindow, i * (heightWindow / numberOfLines), i * (widthWindow / numberOfLines), 0);
            line.setStroke(Color.ORANGE);
            line.setStrokeWidth(1);

            group.getChildren().add(line);
        }

        for(int i = 0; i < numberOfLines; ++i)
        {
            Line line = new Line((numberOfLines - i) * (widthWindow / numberOfLines), 0, 0, i * (heightWindow / numberOfLines));
            line.setStroke(Color.ORANGE);
            line.setStrokeWidth(1);

            group.getChildren().add(line);
        }

        for(int i = 0; i < numberOfLines; ++i)
        {
            Line line = new Line((numberOfLines - i) * (widthWindow / numberOfLines), heightWindow, widthWindow, i * (heightWindow / numberOfLines));
            line.setStroke(Color.ORANGE);
            line.setStrokeWidth(1);

            group.getChildren().add(line);
        }

        //setting the Stage
        primaryStage.setTitle("Canvas demo");
        primaryStage.setScene(new Scene(group, widthWindow, heightWindow));
        primaryStage.show();
    }


    public static void main(String[] args) { launch(args); }
}