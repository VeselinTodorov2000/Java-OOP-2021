package com.geometry.types;

public class Circle extends Point
{
    private int radius;

    public Circle(Point other, int radius) {
        super(other);
        this.setRadius(radius);
    }

    public Circle() {
        this(new Point(), 1);
    }

    public Circle(Circle other) {
        this(new Point(other), 1);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius > 0 ? radius : 1;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null)
            return 1;
        if(!(o instanceof Circle))
            return 1;
        Circle c = (Circle) o;
        int larger = super.compareTo((Point) c);
        if(larger == 0) return radius - c.radius;
        return larger;
    }

    @Override
    public String toString() {
        return String.format("Center: %s, R: %d", super.toString(), radius);
    }
}
