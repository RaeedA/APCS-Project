package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import entities.Enemy;
import entities.Entity;
import entities.GameCharacter;
import entities.User;
import main.Launcher;

@SuppressWarnings("serial")
public class Room extends JPanel
{
    private Tile[][] layout;
    private ArrayList<Entity> entities;
    private Map map;
    private int roomNum;
    
    public Room(int size)
    {
        entities = new ArrayList<Entity>();
        map = new Map(size, 3);
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
        if (entity.getLocation().distance( p ) > 1.5 || p.y < 0 || p.x >= layout.length || p.y >= layout[0].length || !layout[p.x][p.y].isPassable())
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
    
    public Entity getUpEntity(Point p)
    {
        if (layout[p.x][p.y-1].getType().contains( "entity" ) )
        {
            return entityAt(new Point(p.x, p.y-1));
        }
        return null;
    }
    
    public Entity getDownEntity(Point p)
    {
        if (layout[p.x][p.y+1].getType().contains( "entity" ) )
        {
            return entityAt(new Point(p.x, p.y+1));
        }
        return null;
    }
    
    public Entity getLeftEntity(Point p)
    {
        if (layout[p.x-1][p.y].getType().contains( "entity" ) )
        {
            return entityAt(new Point(p.x-1, p.y));
        }
        return null;
    }
    
    public Entity getRightEntity(Point p)
    {
        if (layout[p.x+1][p.y].getType().contains( "entity" ) )
        {
            return entityAt(new Point(p.x+1, p.y));
        }
        return null;
    }
    
    public void kill(Entity entity)
    {
        if(entity instanceof GameCharacter)
        {
            ( (GameCharacter)entity ).setAliveStatus( false );
        }
        removeEntity( entity );
        
    }
    
    public void removeEntity( Entity entity )
    {
        entities.remove( entity );
        layout[entity.getLocation().x][entity.getLocation().y].setPassable( true );
        layout[entity.getLocation().x][entity.getLocation().y].setType( "floor" );
        layout[entity.getLocation().x][entity.getLocation().y].getLabel().setIcon( entity.getCurrent() );
    }
    
    public void redraw( Entity entity, ImageIcon img )
    {
        int locX = entity.getLocation().x;
        int locY = entity.getLocation().y;
        layout[locX][locY].getLabel().setIcon( Images.combine( layout[locX][locY].getImage(), img ));
    }
    
    public void redraw( Entity entity, ImageIcon img , int offx, int offy)
    {
        int locX = entity.getLocation().x;
        int locY = entity.getLocation().y;
        System.out.print( "te" );
        layout[locX][locY].getLabel().setIcon( Images.combine( layout[locX][locY].getImage(), img, offx, offy ));
    }
    
    public User getUser( )
    {
        Entity entity;
        for( int i = 0; i < entities.size(); i++)
        {
            entity = entities.get( i );
            if(entity.getType().equals( "user" ))
            {
                return (User) entity;
            }
        }
        return null;
    }
    
    public void clearEnemies()
    {
        int size = entities.size();
        Entity entity;
        for(int i = size - 1; i > 0; i--)
        {
            entity = entities.get( i );
            if(entity instanceof Enemy)
            {
                kill(entity);
            }
        }
    }
    
    public Entity entityAt( Point location )
    {
        Entity entity;
        for( int i = 0; i < entities.size(); i++)
        {
            entity = entities.get(i);
            if(entity.getLocation().equals( location ))
            {
                return entity;
            }
        }
        return null;
    }
    
    public int getRoomNum()
    {
        return roomNum;
    }
    
    public void setRoomNum( int roomNum )
    {
        this.roomNum = roomNum;
    }
    
    public int getLength()
    {
        return layout.length;
    }
    
    public Map getMap()
    {
        return map;
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
