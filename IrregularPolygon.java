import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import java.util.concurrent.TimeUnit;

import gpdraw.*; // for DrawingTool


public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    public void add(Point2D.Double aPoint) 
    {
        myPolygon.add(aPoint);
    }
    
    public double perimeter() 
    {
        if (myPolygon.size() < 2) 
        {
            return 0.0;
        }
        double perimeter = 0.0;

        for (int i = 0; i < myPolygon.size(); i++) 
        {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());
            double distance = current.distance(next);
            perimeter += distance;
        }
        return perimeter;
    }
    

    public double area() {
        if (myPolygon.size() < 3) {
            return 0.0;
        }
        double sum1 = 0.0;
        double sum2 = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());
            sum1 += current.x * next.y;
            sum2 += current.y * next.x;
        }
        return Math.abs(sum1 - sum2) / 2.0;
    }
    

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
            pen.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }
}
