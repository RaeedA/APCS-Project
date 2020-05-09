package gui;

import java.awt.GridBagLayout;
import java.awt.Point;

public class TorchThread extends Thread
{
    private int num;
    private Torch[] torches;
    private Room room;
    private GridBagLayout layout;
    
    public TorchThread(Tile[][] layout, Point[] places, Images image)
    {
        torches = new Torch[places.length];
        for (int i = 0; i<places.length; i++)
        {
            Torch torch = new Torch(image);
            torches[i] = torch;
            layout[places[i].x][places[i].y] = new Tile(false, torch.getLabel(), "walltorch");
        }
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                sleep( 200 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
            update();
        }
        
    }
    
    private void update()
    {        
        for (int i = 0; i < torches.length; i++)
        {
            torches[i].update();
        }
    }
}
