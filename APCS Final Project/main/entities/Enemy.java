package entities;

import java.awt.Point;
import gui.Images;
import gui.Room;

public class Enemy extends Character
{
    public Enemy(Room room, Point p)
    {
<<<<<<< HEAD
        super(room, p);
        image = new Images().getSkeleton()[0];
        type = "enemy";
=======
        super(room, p, "enemy", new Images().getSkeleton()[0]);
>>>>>>> branch 'master' of https://github.com/RaeedA/APCS-Project.git
    }

    @Override
    public void run()
    {
        
        
    }

}
