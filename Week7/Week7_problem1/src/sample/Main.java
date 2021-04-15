package sample;

import geometry.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group pane = new Group();
        Scene scene = new Scene(pane, 500, 300);
        Random r = new Random();

        double xCoord = r.nextInt(50001) / 100.0;
        double yCoord = r.nextInt(50001) / 100.0;
        Point p1 = new Point(new double[] {xCoord, yCoord});

        xCoord = r.nextInt(50001) / 100.0;
        yCoord = r.nextInt(30001) / 100.0;
        Point p2 = new Point(new double[] {xCoord, yCoord});

        Rectangle firstRectangle = new Rectangle(p1, 50, 30);
        Rectangle secondRectangle = new Rectangle(p2, 40, 40);

        Line diagonal1 = new Line(p1, new Point(new double[]{p1.getCoords()[0] + 50,
                p1.getCoords()[1] + 30}));
        Line diagonal2 = new Line(p2, new Point(new double[]{p2.getCoords()[0] + 40,
                p2.getCoords()[1] + 40}));
        Line diagonal3 = new Line(new Point(new double[]{p1.getCoords()[0],
                p1.getCoords()[1] + 30}), new Point(new double[]{p1.getCoords()[0] + 50,
                p1.getCoords()[1]}));
        Line diagonal4 = new Line(new Point(new double[]{p2.getCoords()[0],
                p2.getCoords()[1] + 40}), new Point(new double[]{p2.getCoords()[0] + 40,
                p2.getCoords()[1]}));

        firstRectangle.draw(pane);
        secondRectangle.draw(pane);
        diagonal1.draw(pane);
        diagonal2.draw(pane);
        diagonal3.draw(pane);
        diagonal4.draw(pane);

        primaryStage.setTitle("Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
