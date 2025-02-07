import java.awt.geom.*; 
import java.util.ArrayList;

import gpdraw.*;

public class IrregularPolygon 
{
    private ArrayList<Point2D.Double> myPolygon;

    public IrregularPolygon() 
    {
        myPolygon = new ArrayList<>();
    }

    public void add(Point2D.Double point) 
    {
        myPolygon.add(point);
    }

    public double perimeter() 
    {
        if (myPolygon.size() < 2) return 0.0;
        double perimeter = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) 
        {
            perimeter += myPolygon.get(i).distance(myPolygon.get((i + 1) % myPolygon.size()));
        }
        return perimeter;
    }

//shoelace formula below
public double area() 
{
    if (myPolygon.size() < 3) return 0.0;
    double sum = 0.0;
    for (int i = 0; i < myPolygon.size(); i++) 
    {
        Point2D.Double current = myPolygon.get(i);
        Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());
        sum += (current.x * next.y) - (current.y * next.x);
    }
    return Math.abs(sum) / 2.0;
}

    public void draw() 
    {

    }
}

