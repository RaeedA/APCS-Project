package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Entity;

public class Room extends JPanel
{
    Tile[][] layout;
    ArrayList<Entity> entities;
    
    public Room(int size)
    {
        entities = new ArrayList<Entity>(5);
        Map map = new Map(size, 3);
        layout = map.getLayout();
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;
        for (int c = 0; c<layout.length; c++)
        {
            con.gridx=c;
            for(int r = 0; r<layout[c].length; r++)
            {
                con.gridy=r;
                add(layout[c][r].getLabel(), con);
            }
        }
    }
    
    public void add(Point p, Entity entity)
    {
        if (!layout[p.x][p.y].isPassable())
        {
            p = findEmpty(p);
        }
        layout[p.x][p.y].setPassable( false );
        layout[p.x][p.y].setType( entity.getType() + "entity" ); 
        ImageIcon current = layout[p.x][p.y].getImage();
        entity.setCurrent( current );
        layout[p.x][p.y].getLabel().setIcon( Images.combine( current, entity.getImg() ) );
        entities.add( entity );
    }
    
    public Point findEmpty(Point p)
    {
        int distance = 1;
        Point empty = null;
        while (true)
        {
            for (int i = -distance; i<= distance; i++)
            {
                try
                {
                if(layout[p.x+i][p.y+distance].isPassable())
                {
                    
                    return new Point(p.x+i, p.y+distance);
                }
                }
                catch(Exception e)
                {
                
                }
                try
                {
                if(layout[p.x+i][p.y-distance].isPassable())
                {
                    
                    return new Point(p.x+i, p.y-distance);
                }
                }
                catch(Exception e)
                {
                
                }
                }
            for (int i = -(distance-1); i<=distance-1; i++)
            {
                try
                {
                if(layout[p.x+distance][p.y+i].isPassable())
                {
                    return new Point(p.x+distance, p.y+i);
                }
                }
                catch(Exception e)
                {
                    
                }
                try
                {
                if(layout[p.x-distance][p.y+i].isPassable())
                {
                    return new Point(p.x+distance, p.y+i);
                }
                }
                catch(Exception e)
                {
                    
                }
            }
            distance++;
        }
    }
}
