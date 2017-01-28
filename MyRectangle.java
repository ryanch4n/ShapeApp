import java.awt.*;

// Author: Ryan Chan
// January 2019

public class MyRectangle extends MyPolygon
{
    private int width;
    private int height;
    private Point center;
    private Graphics g = null;
    private int gravityFactor = 3;
    private boolean initialized;
    private Color color;
    private int[] xPoints;
    private int[] yPoints;

    public MyRectangle()
    {
        width = 50;
        height = 30;
        xPoints = new int[4];
        yPoints = new int[4];
    }

    public void create(Point newCoordinate)
    {
        center = newCoordinate;
        initialized = true;
        color = Color.BLUE;
    }

    public void calcPoints()
    {
        xPoints[0] = center.x + (width / 2);
        yPoints[0] = center.y + (height / 2);

        xPoints[1] = center.x + (width / 2);
        yPoints[1] = center.y - (height / 2);

        xPoints[2] = center.x - (width / 2);
        yPoints[2] = center.y - (height / 2);

        xPoints[3] = center.x - (width / 2);
        yPoints[3] = center.y + (height / 2);
    }

    public void draw(Graphics g)
    {
        calcPoints();
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, 4);
    }

    public boolean readyToDrop()
    {
        return initialized;
    }

    public void moveDown(Graphics g)
    {
        center.y = center.y + gravityFactor;
    }

    public void shiftToBottom(int height)
    {
        while(getBottomY() < height)
        {
            center.y += 1;
        }
    }

    public int getBottomY()
    {
        return center.y + (height/2);
    }

    public void setBottomColor()
    {
        color = Color.green;
    }

    void increaseRadius() { }
    void decreaseRadius() { }
    void increaseTess() { }
    void decreaseTess() { }
}
