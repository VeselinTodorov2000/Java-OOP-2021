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
        //creating group
        Group group = new Group(); //group used
        //creating scene
        Scene scene = new Scene(group, 600, 500); //scene used

        double width = scene.getWidth(); //variable that holds the width of the scene
        double height = scene.getHeight(); //variable that holds the height of the scene

        double widthPartition = width / 20; //variable that holds the distance between two end line points in width
        double heightPartition = height / 20; //variable that holds the distance between two end line points in height

        //bottom left corner

        //every line starts from x = 0 and y is changing by heightPartition from 0 to height
        //and ends in x changing by widthPartition from widthPartition to width
        //the loop iterates around this dependence
        for(double yStartCoord = 0, xEndCoord = 0; yStartCoord < height && xEndCoord <= width; yStartCoord += heightPartition, xEndCoord += widthPartition)
        {
            Line l = new Line(0,yStartCoord, xEndCoord, height); //create line with the coords we set
            l.setStroke(Color.ORANGE); //set the color of the line to orange
            l.setStrokeWidth(1); //set stroke of the line to 1
            group.getChildren().add(l); //add l to the group
        }

        //top left corner

        //every line starts from y = 0 and x is changing by widthPartition from width to 0
        //and ends in y changing by heightPartition from heightPartition to height
        //the loop iterates around this dependence
        for(double xStartCoord = width, yEndCoord = heightPartition; yEndCoord <= height && xStartCoord >= 0; yEndCoord += heightPartition, xStartCoord -= widthPartition)
        {
            Line l = new Line(xStartCoord, 0, 0, yEndCoord); //create line with the coords we set
            l.setStroke(Color.ORANGE); //set the color of the line to orange
            l.setStrokeWidth(1); //set stroke of the line to 1
            group.getChildren().add(l); //add l to the group
        }

        //top right corner

        //every line starts from y = 0 and x is changing by widthPartition from 0 to width
        //and ends in y changing by heightPartition from heightPartition to height
        //the loop iterates around this dependence
        for(double xStartCoord = 0, yEndCoord = heightPartition; yEndCoord <= height && xStartCoord <= width; yEndCoord += heightPartition, xStartCoord += widthPartition)
        {
            Line l = new Line(xStartCoord, 0, width, yEndCoord); //create line with the coords we set
            l.setStroke(Color.ORANGE); //set the color of the line to orange
            l.setStrokeWidth(1); //set stroke of the line to 1
            group.getChildren().add(l); //add l to the group
        }

        //bottom right corner

        //every line starts from y = 0 and x is changing by widthPartition from 0 to width
        //and ends in y changing by heightPartition from height to 0
        //the loop iterates around this dependence
        for(double xStartCoord = 0, yEndCoord = height; yEndCoord >= 0 && xStartCoord <= width; yEndCoord -= heightPartition, xStartCoord += widthPartition)
        {
            Line l = new Line(xStartCoord, height, width, yEndCoord); //create line with the coords we set
            l.setStroke(Color.ORANGE); //set the color of the line to orange
            l.setStrokeWidth(1); //set stroke of the line to 1
            group.getChildren().add(l); //add l to the group
        }

        //setting scene
        primaryStage.setScene(scene);//set the scene to scene

        //setting title
        primaryStage.setTitle("Canvas Demo"); //sets the title to Canvas Demo

        primaryStage.show(); //shows the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
