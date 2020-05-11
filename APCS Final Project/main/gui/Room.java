package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import entities.Entity;
import entities.User;
import entities.Character;

@SuppressWarnings("serial")
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
    
    public void addEntity(Entity entity)
    {
        Point p = entity.getLocation();
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
    
    public void move(Entity entity, Point p)
    {
        if (entity.getLocation().distance( p ) > 1.5 || p.x >= layout.length || p.y >= layout[0].length || !layout[p.x][p.y].isPassable())
        {
            return;
        }
        Tile newTile = layout[p.x][p.y];
        Tile current = layout[entity.getLocation().x][entity.getLocation().y];
        newTile.setPassable( false );
        newTile.setType( entity.getType() + "entity" );
        current.setPassable( true );
        current.setType( "floor" );
        current.getLabel().setIcon(entity.getCurrent());
        entity.setCurrent( newTile.getImage() );
        newTile.getLabel().setIcon( Images.combine(newTile.getImage(),entity.getImg() ));
        entity.setLocation( p );
        
    }
    
    public void redraw( Entity entity, ImageIcon img )
    {
        int locX = entity.getLocation().x;
        int locY = entity.getLocation().y;
        layout[locX][locY].getLabel().setIcon( Images.combine( layout[locX][locY].getImage(), img ));
    }
    
    public Entity getUser( )
    {
        for( Entity entity : entities)
        {
            if(entity.getType().equals( "user" ))
            {
                return entity;
            }
        }
        return null;
    }
    
    public Entity getEntityAtPoint( Point location )
    {
        for( Entity entity : entities)
        {
            if(entity.getLocation().equals( location ))
            {
                return entity;
            }
        }
        return null;
    }
    
    public Point findEmpty(Point p)
    {
        int distance = 1;
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
