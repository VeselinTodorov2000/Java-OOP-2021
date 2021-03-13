package zad1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Geometry extends Application
{
    private Group root;
    private Scene scene;
    private Alert alert;
    private TextInputDialog prompt;
    private double x;

    private void showErrorDialog()
    {
        alert.setTitle("Input error");
        alert.setHeaderText("No intersection points");
        alert.setContentText(null);
        alert.showAndWait();
    }

    private void readInput()
    {
        prompt.setTitle("Input data");
        prompt.setHeaderText(null);
        prompt.setContentText("Enter x: ");

        do {
            x = Double.parseDouble(prompt.showAndWait().get());
        } while(x < 0 || x > scene.getWidth());

    }

    private void drawCircleAndText(double yCrossPoint)
    {
        Circle smallCircle = new Circle(x, yCrossPoint, 5);
        //intersection point
        smallCircle.setStroke(Color.BLACK);

        Text text = new Text(x + 10, yCrossPoint, String.format("(%.2f; %.2f)", x, yCrossPoint));

        root.getChildren().add(smallCircle);
        root.getChildren().add(text);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        double centerX, centerY, radius;
        double leg; // CH^2

        alert = new Alert(Alert.AlertType.ERROR);
        prompt = new TextInputDialog();
        root = new Group();
        scene = new Scene(root, 600, 500);

        readInput();

        centerX = scene.getWidth() / 2;
        centerY = scene.getHeight() / 2;
        radius = Math.min(scene.getWidth(), scene.getHeight()) / 3.0;
        leg = radius * radius - (centerX - x) * (centerX - x);

        Circle circle = new Circle(centerX, centerY, radius);
        circle.setStroke(Color.BLUE);
        circle.setFill(null);

        Line lineAB = new Line(x, 0, x, scene.getHeight());
        lineAB.setStroke(Color.RED);
        root.getChildren().addAll(circle, lineAB);

        if(leg >= 0)
        {
            double ch = Math.sqrt(leg);
            double yCrossPoint = centerY - ch;
            drawCircleAndText(yCrossPoint);
            if(leg > 0)
            {
                double yCrossPointTwo = centerY + ch;
                drawCircleAndText(yCrossPointTwo);
            }
        }
        else
        {
            showErrorDialog();
            Platform.exit();
        }

        stage.setTitle("Circle Line Intersection");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
