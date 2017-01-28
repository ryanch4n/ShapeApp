import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Author: Ryan Chan
// January 2019

public class Grid extends JPanel implements MouseListener, ActionListener
{
    Graphics g;
    private int carousel = 0;
    private int numObjects = 15;
    private int createdObjects = 0;
    private int type = 0;
    private int width = 550;
    private int height = 400;
    private Timer clock;
    private int clockSpeed = 50;
    private boolean clockRun = true;

    MyPolygon shapes[];

    public Grid()
    {
        setBackground(Color.gray);
        addMouseListener(this);
        setSize(width,height);

        shapes = new MyRectangle[numObjects];
        type = 0;

        for(int i = 0; i < numObjects; i++)
        {
            shapes[i] = new MyRectangle();
        }

        clock = new Timer(clockSpeed,this);
        clock.start();
    }

    public void paintShapes(Point coordinate)
    {
        if(carousel == 15)
        {
            carousel = 0;
        }

        if(createdObjects < numObjects)
        {
            createdObjects++;
        }

        //Reset background
        g.setColor(Color.gray);
        g.fillRect(0,0,width,height);

        shapes[carousel].create(coordinate);
        carousel++;

        for(int i = 0; i < createdObjects; i++)
        {
            shapes[i].draw(g);
        }

    }

    public void repaintShapes()
    {
        //Reset background
        g = getGraphics();

        if(g != null)
        {
            g.setColor(Color.gray);
            g.fillRect(0,0,width,height);

            for(int i = 0; i < createdObjects; i++)
            {
                shapes[i].draw(g);
            }
        }
    }

    public void changeSize(int sizeOption)
    {
        if(sizeOption == 1)
        {
            for(int i = 0; i < createdObjects; i++)
            {
                shapes[i].increaseRadius();
            }
        }
        else if(sizeOption == 2)
        {
            for(int i = 0; i < createdObjects; i++)
            {
                shapes[i].decreaseRadius();
            }
        }
        else if(sizeOption == 3)
        {
            for(int i = 0; i < createdObjects; i++)
            {
                shapes[i].increaseTess();
            }
        }
        else if(sizeOption == 4)
        {
            for(int i = 0; i < createdObjects; i++)
            {
                shapes[i].decreaseTess();
            }
        }
        repaintShapes();
    }

    public int getType()
    {
        return type;
    }

    public void setType(int newType)
    {
        g = getGraphics();
        g.setColor(Color.gray);
        g.fillRect(0,0,width,height);

        createdObjects = 0;
        carousel = 0;

        if(newType == 0)
        {
            shapes = new MyRectangle[numObjects];
            type = 0;

            for(int i = 0; i < numObjects; i++)
            {
                shapes[i] = new MyRectangle();
            }
        }
        else if(newType == 1)
        {
            shapes = new TessCircle[numObjects];
            type = 1;

            for(int i = 0; i < numObjects; i++)
            {
                shapes[i] = new TessCircle();
            }
        }
    }


    public boolean checkMoveDown(MyPolygon shape)
    {
        return (shape.getBottomY() < 400 && shape.getBottomY() + 3 < 400);
    }

    public boolean getClockRun()
    {
        return clockRun;
    }

    public void changeClock()
    {
        if(clockRun == true)
        {
            clock.stop();
            clockRun = false;
        }
        else if(clockRun == false)
        {
            clock.start();
            clockRun = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i < createdObjects; i++){
            if(checkMoveDown(shapes[i]))
            {
                if(shapes[i].readyToDrop() == true){
                    shapes[i].moveDown(g);
                }
            }
            else
            {
                shapes[i].shiftToBottom(height);
                shapes[i].setBottomColor();
            }
        }

        repaintShapes();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        g = getGraphics();

        Point coordinate = new Point(e.getX(), e.getY());
        paintShapes(coordinate);
    }

    @Override
    public void mousePressed(MouseEvent e){ }

    @Override
    public void mouseReleased(MouseEvent e){ }

    @Override
    public void mouseEntered(MouseEvent e){ }

    @Override
    public void mouseExited(MouseEvent e){ }
}
