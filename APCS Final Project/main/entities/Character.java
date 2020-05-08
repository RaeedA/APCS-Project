package entities;

public class Character extends Entity
{
    protected int health;
    protected int attackDamage;
    
    public Character()
    {
        
    }
    
    public Character(int x, int y, String image)
    {
        super(x, y, image);
    }
    
    public int getHealth() {return health;}
    public void setHealth(int health) { this.health = health; }
    public void moveTo(int x, int y)
    {
        //TODO: animation and process
        this.x = x;
        this.y = y;
    }
}
