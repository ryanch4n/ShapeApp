import java.awt.*;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

// Author: Ryan Chan
// January 2019

public class TessCircle extends MyPolygon
{
    private Point center;
    private static int vertices = 15;
    private static int radius = 30;
    int[] xPoints;
    int[] yPoints;
    Color color;

    private int gravityFactor = 3;
    private boolean initialized;

    public void create(Point newCenter)
    {
        center = newCenter;
        calcPoints();
        initialized = true;
        color = Color.red;
    }

    private void calcPoints()
    {
        xPoints = new int[vertices];
        yPoints = new int[vertices];
        double radians = Math.toRadians(360.0 / vertices);

        for(int i = 0; i < vertices; i++)
        {
            xPoints[i] = (int) (radius * cos(radians * i)) + center.x;
            yPoints[i] = (int) (radius * sin(radians * i)) + center.y;
        }
    }

    public void draw(Graphics g)
    {
        calcPoints();

        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, vertices);
    }

    public void increaseRadius()
    {
        radius += 2;
    }

    public void decreaseRadius()
    {
        if(radius > 5){
            radius -= 2;
        }
    }

    public void increaseTess()
    {
        vertices++;
        xPoints = new int[vertices];
        yPoints = new int[vertices];
    }

    public void decreaseTess()
    {
        if(vertices > 3){
            vertices--;
            xPoints = new int[vertices];
            yPoints = new int[vertices];
        }
    }

    public void moveDown(Graphics g)
    {
        center.y = center.y + gravityFactor;
    }

    public boolean readyToDrop()
    {
        return initialized;
    }

    public int getBottomY()
    {
        return center.y + radius;
    }

    public void setBottomColor()
    {
        color = Color.green;
    }

    public void shiftToBottom(int height)
    {
        while(getBottomY() < height)
        {
            center.y += 1;
        }
    }
}
