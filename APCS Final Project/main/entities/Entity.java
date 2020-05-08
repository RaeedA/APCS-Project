package entities;

public abstract class Entity
{
    protected int x;
    
    protected int y;
    
    //TODO: Substitute later
    protected String image;
    
    public Entity()
    {
        //TODO: Default Constructor
    }
    
    public Entity(int x, int y, String image)
    {
        //TODO: Fix
        this.x = x;
        this.y = y;
        this.image = image;
    }
    
    public int getX() {return x;}
    public void setX( int x ) { this.x = x;}
    
    public int getY() {return y;}
    public void setY( int y ) {this.y = y;}
    
    //TODO: Fix later
    public String getImg() {return image;}
    public void setImg(String image) {this.image = image;}
    
    //TODO: More methods
}
