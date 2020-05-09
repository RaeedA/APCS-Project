package gui;

import java.awt.Point;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Map
{
    private Tile[][] layout;
    
    public Map(int size, int torchDistance)
    {
        makeLayout(size, torchDistance);
    }
    
    private void makeLayout(int size, int torchDistance)
    {
        //Adjust size
        while (size%torchDistance != 0)
        {
            size++;
        }
        if (size <= torchDistance)
        {
            size = torchDistance+1;
        }
        size += 3;

        //Making layout
        layout = new Tile[size][size];
        
        //Getting images
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
        
        //Making floor
        ImageIcon[] floor = images.getFloor();
        for (int col = 1; col<size-1; col++)
        {
            for (int r = 1; r<size-1; r++)
            {
                layout[col][r] = new Tile(true, new JLabel(floor[(int)(Math.random()*8)]), "floor");
            }
        }
        
        //Side Walls
        ImageIcon[] rwall = images.getRight();
        ImageIcon[] lwall = images.getLeft();
        for (int r = 0; r<size-1; r++)
        {
            layout[0][r] = new Tile(false, new JLabel(lwall[(int)(Math.random()*4)]), "leftwall");
            layout[size-1][r] = new Tile(false, new JLabel(rwall[(int)(Math.random()*4)]), "rightwall");
        }
        
        //Corners
        ImageIcon[] corners = images.getCorners();
        layout[0][size-1] = new Tile(false, new JLabel(corners[0]), "cornerwall");
        layout[size-1][size-1] = new Tile(false, new JLabel(corners[1]), "cornerwall");
        
        //Top and bottom walls minus torches
        ImageIcon[] top = images.getTop();
        ImageIcon[] bottom = images.getBottom();
        for (int c = 1; c<size-1; c++)
        {
            if ((c-1)%torchDistance != 0)
            {
                layout[c][0] = new Tile(false, new JLabel(top[(int)(Math.random()*4)]), "topwall");
            }
            layout[c][size-1] = new Tile(false, new JLabel(bottom[(int)(Math.random()*4)]), "bottomwall");
        }
        
        //Making torches on top walls
        int wallSize = size-2;
        Point[] torches = new Point[wallSize/torchDistance+1];
        int num = 0;
        for (int i = 0; i <= wallSize; i+=torchDistance)
        {
            torches[num] = new Point(i+1, 0);
            num++;
        }
        TorchThread torch = new TorchThread(layout, torches, images);
        torch.start();
    }
    
    public Tile[][] getLayout()
    {
        return layout;
    }
}
