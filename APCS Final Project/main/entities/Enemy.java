package entities;

import java.awt.Point;
import gui.Images;
import gui.Room;

public class Enemy extends Character
{
    public Enemy(Room room, Point p)
    {
        super(room, p);
        image = Images.getSkeleton()[0];
        type = "enemy";
        room.addEntity(this);
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                sleep( 1000 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
            move(new Point(location.x+1, location.y));
        }
    }

}
