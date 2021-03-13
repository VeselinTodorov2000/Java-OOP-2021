package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group group = new Group();
        Scene scene = new Scene(group, 400, 400);
        Line l;

        double width = scene.getWidth();
        double height = scene.getHeight();

        double startX = width / 2;
        double startY = height / 2;

        double startLenght = 30;
        double originalLenght = startLenght;

        for(int i = 0; i < 5; i++)
        {
            l = new Line(startX, startY, startX, startY + startLenght);
            l.setStroke(Color.RED);
            group.getChildren().add(l);
            startY += startLenght;

            l = new Line(startX, startY, startX - startLenght, startY);
            l.setStroke(Color.RED);
            group.getChildren().add(l);
            startX -= startLenght;

            startLenght += originalLenght;

            l = new Line(startX, startY, startX, startY - startLenght);
            l.setStroke(Color.RED);
            group.getChildren().add(l);
            startY -= startLenght;

            l = new Line(startX, startY, startX + startLenght, startY);
            l.setStroke(Color.RED);
            group.getChildren().add(l);
            startX += startLenght;

            startLenght += originalLenght;
        }

        primaryStage.setTitle("Draw square shaped spiral");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
