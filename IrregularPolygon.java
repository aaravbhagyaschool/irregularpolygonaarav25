import java.awt.geom.*;
import java.util.ArrayList;

import gpdraw.*;

public class IrregularPolygon 
{
    private ArrayList<Point2D.Double> vertices;

    public IrregularPolygon() 
    {
        vertices = new ArrayList<>();
    }

    public void add(Point2D.Double newPoint) 
    {
        vertices.add(newPoint);
    }

    // shoelace formula (look on google classroom)
    public double area() 
    {
        if (vertices.size() < 3) return 0.0;
        double total = 0.0;
        for (int i = 0; i < vertices.size(); i++) 
        {
            Point2D.Double currentVertex = vertices.get(i);
            Point2D.Double nextVertex = vertices.get((i + 1) % vertices.size());
            total += (currentVertex.getX() * nextVertex.getY()) - (currentVertex.getY() * nextVertex.getX());
        }
        return Math.abs(total) / 2.0;
    }

    public double perimeter() 
    {
        if (vertices.size() < 2) return 0.0;
        double totalPerimeter = 0.0;
        for (int i = 0; i < vertices.size(); i++) 
        {
            totalPerimeter += vertices.get(i).distance(vertices.get((i + 1) % vertices.size()));
        }
        return totalPerimeter;
    }

    public void draw() // USE GETTERS
    {
        DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
        pen.up();
        if (!vertices.isEmpty()) // NOTE aarav check if polygon is empty (use !)
        {
            pen.move(vertices.get(0).getX(), vertices.get(0).getY());
            pen.down();
            for (Point2D.Double vertex : vertices) 
            {
                pen.move(vertex.getX(), vertex.getY());
            }
            pen.move(vertices.get(0).getX(), vertices.get(0).getY());
        }
    }
}