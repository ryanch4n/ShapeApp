import java.awt.*;

// Author: Ryan Chan
// January 2019

public abstract class MyPolygon
{
    abstract void create(Point newCoordinate);
    abstract void draw(Graphics g);
    abstract void increaseRadius();
    abstract void decreaseRadius();
    abstract void increaseTess();
    abstract void decreaseTess();
    abstract void moveDown(Graphics g);
    abstract boolean readyToDrop();
    abstract int getBottomY();
    abstract void setBottomColor();
    abstract void shiftToBottom(int height);
}
