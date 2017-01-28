import javax.swing.*;
import java.awt.*;

// Author: Ryan Chan
// January 2019

public class ShapeApp extends JFrame
{
    static Grid grid;

    public static void main(String[] args)
    {
        ShapeApp app = new ShapeApp();
    }

    public ShapeApp()
    {
        grid = new Grid();
        add(grid, BorderLayout.CENTER);

        MainPanel mainPanel = new MainPanel(grid);
        SizePanel sizePanel = new SizePanel(grid);

        add(mainPanel, BorderLayout.PAGE_START);
        add(sizePanel, BorderLayout.PAGE_END);

        setTitle("ShapeApp");
        setSize(550, 500);
        setBounds(0, 0, 550, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
