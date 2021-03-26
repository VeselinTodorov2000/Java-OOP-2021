package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {
    private Group group;
    private Scene scene;
    private double offset;  //distance between the different levels of the spiral
    private int scalar;     //scalar for multiplying the offset to get the coordinates of the new level of the spiral

    private void drawSquaredSpiral() {
        double width = scene.getWidth();
        double height = scene.getHeight();

        //startX and startY define the point where we start drawing, in this case it is the center of the scene
        double startX = width / 2;
        double startY = height / 2;

        //drawing the spiral
        while (scalar * offset < (height/2) && scalar * offset < (width/2))
        {
            //each iteration of the loop draws 4 lines
            Line line1 = new Line(startX + (scalar - 1) * offset, startY - (scalar - 1) * offset,
                    startX + (scalar - 1) * offset, startY + scalar * offset);
            line1.setStrokeWidth(2);
            line1.setStroke(Color.CORAL);

            Line line2 = new Line(startX + (scalar - 1) * offset, startY + scalar * offset,
                    startX - scalar * offset, startY + scalar * offset);
            line2.setStrokeWidth(2);
            line2.setStroke(Color.CORAL);

            Line line3 = new Line(startX - scalar * offset, startY + scalar * offset,
                    startX - scalar * offset, startY - scalar * offset);
            line3.setStrokeWidth(2);
            line3.setStroke(Color.CORAL);

            Line line4 = new Line(startX - scalar * offset, startY - scalar * offset,
                    startX + scalar * offset, startY - scalar * offset);
            line4.setStrokeWidth(2);
            line4.setStroke(Color.CORAL);

            group.getChildren().addAll(line1, line2, line3, line4);

            scalar++;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        group = new Group();
        scene = new Scene(group, 400, 400);
        offset = 30;
        scalar = 1; //scalar always starts from 1

        drawSquaredSpiral();

        primaryStage.setTitle("Drawing a rectangular spiral");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
