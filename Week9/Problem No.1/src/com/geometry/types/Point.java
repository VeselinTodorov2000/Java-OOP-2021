package com.geometry.types;

public class Point implements Comparable{
    private int x;
    private int y;

    public Point() {
        this.setX(0);
        this.setY(0);
    }

    public Point(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public Point(Point other) {
        this.setX(other.x);
        this.setY(other.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x > 0 ? x : 0;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y > 0 ? y : 0;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null)
            return 1;
        if(!(o instanceof Point))
            return 1;
        Point p = (Point) o;
        if(x == p.x)
            return y - p.y;
        return x - p.x;
    }

    @Override
    public String toString() {
        return String.format("(%d; %d)", x, y);
    }
}
