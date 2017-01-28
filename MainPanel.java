import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Author: Ryan Chan
// January 2019

public class MainPanel extends JPanel implements ActionListener {
    static JPanel panel = null;
    static Grid g = null;

    static JButton closeButton = null;
    static JButton rectangleButton = null;
    static JButton polygonButton = null;
    static JButton resetButton = null;
    static JButton playButton = null;


    public MainPanel(Grid newG) {
        closeButton = new JButton("Close");
        rectangleButton = new JButton("Rectangles");
        polygonButton = new JButton("Tessellated Circles");
        resetButton = new JButton("Reset");
        playButton = new JButton("Pause");

        closeButton.addActionListener(this);
        rectangleButton.addActionListener(this);
        polygonButton.addActionListener(this);
        resetButton.addActionListener(this);
        playButton.addActionListener(this);

        panel = new JPanel();
        add(closeButton);
        add(rectangleButton);
        add(polygonButton);
        add(resetButton);
        add(playButton);

        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 500, 50);
        panel.setSize(500, 100);
        panel.setVisible(true);

        g = newG;

        MyPolygon a = new MyRectangle();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand() == "Close")
        {
            System.exit(0);
        }
        else if(e.getActionCommand() == "Reset")
        {
            if(g.getType() == 0)
            {
                g.setType(0);
            }
            else if(g.getType() == 1)
            {
                g.setType(1);
            }
        }
        else if(e.getActionCommand() == "Rectangles")
        {
            g.setType(0);
        }
        else if(e.getActionCommand() == "Tessellated Circles")
        {
            g.setType(1);
        }
        else if((e.getActionCommand() == "Play") || (e.getActionCommand() == "Pause")){
            if(g.getClockRun()){
                g.changeClock();
                playButton.setText("Play");
            }
            else{
                g.changeClock();
                playButton.setText("Pause");
            }
        }
    }
}
