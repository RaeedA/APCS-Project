package entities;

import java.awt.Point;
import gui.Images;
import gui.Room;

public class Enemy extends Entity
{
    public Enemy(Room room, Point p)
    {
        super(room, p, "enemy", new Images().getBottom()[0]);
    }

    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        
    }

}
