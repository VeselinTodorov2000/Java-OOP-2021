package geometry;

import java.util.Arrays;

public class Point {
    private double[] coords;


    public Point()
    {
        this(new double[2]);
    }

    public Point(double[] coords) {
        setCoords(coords);
    }

    public Point(Point other)
    {
        this(other.getCoords());
    }

    public void setCoords(double[] coords) {
        if(coords != null && coords.length == 2)
        {
            this.coords = new double[coords.length];
            for(int i = 0; i < coords.length; i++)
            {
                this.coords[i] = coords[i];
            }
        }
        else
        {
            this.coords = new double[]{0,0};
        }
    }

    public double[] getCoords() {
        double[] copy = new double[coords.length];
        for (int i = 0; i < copy.length; i++)
        {
            copy[i] = coords[i];
        }
        return coords;
    }

    @Override
    public String toString() {
        return String.format("%.2p %.2f", coords[0], coords[1]);
    }
}
