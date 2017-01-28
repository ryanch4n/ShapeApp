import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Author: Ryan Chan
// January 2019

public class SizePanel extends JPanel implements ActionListener {
    static JPanel panel = null;

    static JButton incRadButton = null;
    static JButton decRadButton = null;
    static JButton incTessButton = null;
    static JButton decTessButton = null;

    Grid g = null;

    public SizePanel(Grid importG) {
        incRadButton = new JButton("▲ Radius");
        decRadButton = new JButton("▼ Radius");
        incTessButton = new JButton("▲ Tessell");
        decTessButton = new JButton("▼ Tessell");

        incRadButton.addActionListener(this);
        decRadButton.addActionListener(this);
        incTessButton.addActionListener(this);
        decTessButton.addActionListener(this);

        panel = new JPanel();

        add(decRadButton);
        add(incRadButton);
        add(decTessButton);
        add(incTessButton);

        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 500, 50);
        panel.setSize(500, 100);
        panel.setVisible(true);

        g = importG;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(g.getType() == 1)
        {
            if (e.getActionCommand() == "▲ Radius")
            {
                g.changeSize(1);
            }
            else if(e.getActionCommand() == "▼ Radius")
            {
                g.changeSize(2);
            }
            else if(e.getActionCommand() == "▲ Tessell")
            {
                g.changeSize(3);
            }
            else if(e.getActionCommand() == "▼ Tessell")
            {
                g.changeSize(4);
            }
        }
    }
}
