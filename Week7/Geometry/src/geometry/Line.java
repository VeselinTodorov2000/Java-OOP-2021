package geometry;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Line {
    private Point sPoint;
    private Point ePoint;

    public Line(Point sPoint, Point ePoint) {
        setsPoint(sPoint);
        setePoint(ePoint);
    }

    public Line() {
        this(new Point(), new Point(new double[]{5, 10}));
    }

    public Line(Line l) {
        this(l.getsPoint(), l.getePoint());
    }

    public Point getsPoint() {
        return new Point(sPoint);
    }

    public void setsPoint(Point sPoint) {
        this.sPoint = sPoint != null ? sPoint : new Point();
    }

    public Point getePoint() {
        return new Point(ePoint);
    }

    public void setePoint(Point ePoint) {
        this.ePoint = ePoint != null ? ePoint : new Point();
    }

    @Override
    public String toString() {
        return String.format("Starting point: %s, Ending point: %s", sPoint.toString(), ePoint.toString());
    }

    public void draw(Group pane)
    {
        javafx.scene.shape.Line line = new javafx.scene.shape.Line(sPoint.getCoords()[0], sPoint.getCoords()[1], ePoint.getCoords()[0], ePoint.getCoords()[1]);
        line.setStroke(Color.BLACK);
        pane.getChildren().add(line);
    }
}
