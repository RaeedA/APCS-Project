package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Room extends JPanel
{    
    public Room(int size)
    {
        Map map = new Map(size);
        int[][] layout = map.getLayout();
        makeLayout(size, layout);
    }
    
    public void makeLayout(int size, int[][] layout)
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        Images images;
        try
        {
            images = new Images();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            return;
        }
        
        for (int col = 2; col<size-2; col++)
        {
            for (int r = 2; r<size-2; r++)
            {
                if (layout[col][r] == 0)
                {
                    c.gridx = col;
                    c.gridy = r;
                    add( new JLabel(images.getFloor()[(int)(Math.random()*8)]) ,c);
                }
            }
        }
        for (int i = 1; i<size-2; i++)
        {
            c.gridx=1;
            c.gridy=i;
            add(new JLabel(images.getLeft()[(int)(Math.random()*4)]),c);
            c.gridx=size-2;
            add(new JLabel(images.getRight()[(int)(Math.random()*4)]),c);
        }
        ImageIcon[] corners = images.getCorners();
        c.gridx=1;
        c.gridy=size-2;
        add(new JLabel(corners[0]),c);
        c.gridx=size-2;
        add(new JLabel(corners[1]),c);
        
        for (int i = 2; i<size-2; i++)
        {
            c.gridx=i;
            c.gridy=1;
            add(new JLabel(images.getBottom()[(int)(Math.random()*4)]),c);
            c.gridy=size-2;
            add(new JLabel(images.getBottom()[(int)(Math.random()*4)]),c);
        }
        for (int col = 0; col<size; col++)
        {
            for (int r = 0; r< size; r++)
            {
                if(col ==0 || r ==0 || col == size-1 || r == size-1)
                {
                    c.gridx = col;
                    c.gridy = r;
                    add(new JLabel(images.getEmpty()), c);
                }
            }
        }
    }
}
