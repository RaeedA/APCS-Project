package entities;

import gui.Images;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public abstract class Entity
{
    protected int x;
    
    protected int y;
    
    //TODO: Substitute later
    protected Image image;
    
    public Entity()
    {
        //TODO: Default Constructor
    }
    
    public Entity(int x, int y, String imgPath)
    {
        this.x = x;
        this.y = y;
        this.setImg( imgPath, 64, 288, 32, 32 );
    }
    
    public int getX() {return x;}
    public void setX( int x ) { this.x = x;}
    
    public int getY() {return y;}
    public void setY( int y ) {this.y = y;}
    
    //TODO: Fix later
    public Image getImg() {return image;}
    public void setImg(String imgPath, int x, int y, int width, int height) 
    {
        image = Images.crop( Images.loadImg( imgPath ), x, y, width, height).getImage();
    }
    
    //TODO: More methods
}
