package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();  // Create a layout Panel
        Scene scene = new Scene(group, 500, 500);   // Create the Scene

        double width = scene.getWidth(); // total width of the scene
        double height = scene.getHeight(); // total width of the scene

        drawSlopedLines(group, width, height);

        // Set the title of the Stage(the application window)
        primaryStage.setTitle("Problem No. 2");
        // Add the Scene to the Stage
        primaryStage.setScene(scene);
        // Show the Stage (the application window)
        primaryStage.show();
    }

    private void drawSlopedLines(Group group, double width, double height) {

        //scalars for increasing counters
        double widthScalar = width / 20.0;
        double heightScalar = height / 20.0;

        for (int i = 0, j = 0; i <= width && j <= height; i += widthScalar, j += heightScalar) {
            //drawing the line at the bottom-left corner
            Line bottomLeftLine = new Line(0, j, i, height);
            bottomLeftLine.setStrokeWidth(2);
            bottomLeftLine.setStroke(Color.CORAL);

            //drawing the line at the top-left corner
            Line topLeftLine = new Line(0, height - j, i, 0);
            topLeftLine.setStrokeWidth(2);
            topLeftLine.setStroke(Color.CORAL);

            //drawing the line at the top-right corner
            Line topRightLine = new Line(width - i, 0, width, height - j);
            topRightLine.setStrokeWidth(2);
            topRightLine.setStroke(Color.CORAL);

            //drawing the line at the bottom-right corner
            Line bottomRightLine = new Line(i, height, width, height - j);
            bottomRightLine.setStrokeWidth(2);
            bottomRightLine.setStroke(Color.CORAL);

            //adding all 4 lines in the group
            group.getChildren().addAll(bottomLeftLine, bottomRightLine, topLeftLine, topRightLine);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}