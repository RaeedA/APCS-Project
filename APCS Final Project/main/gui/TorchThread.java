package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TorchThread extends Thread
{
    int num;
    Torch[] torches;
    Room room;
    GridBagLayout layout;
    
    public TorchThread(Room r, Point[] places)
    {
        Images image;
        try
        {
            image = new Images();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            return;
        }
        
        room = r;
        layout = (GridBagLayout)room.getLayout();
        torches = new Torch[places.length];
        for (int i = 0; i<places.length; i++)
        {
            GridBagConstraints constraint = new GridBagConstraints();
            constraint.fill = GridBagConstraints.BOTH;
            constraint.gridx = places[i].x;
            constraint.gridy = places[i].y;
            Torch torch = new Torch(image, constraint);
            torches[i] = torch;
            room.add(torch.getLabel(), constraint );
            torch.update();
        }
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                sleep( 900 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
            update();
        }
        
    }
    
    public void update()
    {        
        for (int i = 0; i < torches.length; i++)
        {
            torches[i].update();
        }
    }
}
