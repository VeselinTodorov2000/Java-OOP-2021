package com.geometry.types;

public class Cylinder extends Circle{
    private int height;

    public Cylinder(Circle other, int height) {
        super(other);
        this.setHeight(height);
    }

    public Cylinder()
    {
        this(new Circle(), 1);
    }

    public Cylinder(Cylinder other)
    {
        this(new Circle(other), other.height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height > 0 ? height : 1;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null)
            return 1;
        if(!(o instanceof Cylinder))
            return 1;
        Cylinder c = (Cylinder) o;
        int larger = super.compareTo((Circle) c);
        if(larger == 0) return height - c.height;
        return larger;
    }

    @Override
    public String toString() {
        return String.format("Circle: %s, Height: %d", super.toString(), height);
    }
}
