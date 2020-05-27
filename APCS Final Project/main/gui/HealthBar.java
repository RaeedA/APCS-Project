package gui;

import javax.swing.ImageIcon;

import entities.User;

public class HealthBar
{
    private ImageIcon mainImage;
    private ImageIcon myImage;
    private final ImageIcon myEmpty;
    private int health;
    private int maxHealth;
    private final int myOffset;
    
    public HealthBar(ImageIcon image, ImageIcon empty, User user, int offset)
    {
        mainImage = image;
        myImage = mainImage;
        try
        {
            maxHealth = user.getMaxHealth();
            health = user.getHealth();
        }
        catch(NullPointerException e)
        {
            maxHealth = 1;
            health = 1;
        }
        myOffset = offset;
        myEmpty = empty;
    }
    
    public boolean update(int newHealth)
    {
        if (health != newHealth)
        {
            health = newHealth;
            int newSize = (int)( ((double)(health)/maxHealth)*mainImage.getIconWidth() );
            if (newSize < 0)
            {
                newSize = 1;
            }
            myImage = new ImageIcon(Images.crop( Images.toBufferedImage(mainImage.getImage()), 0,0, newSize, mainImage.getIconHeight() ));
            return true;
        }
        return false;
    }
    
    public String getHealth()
    {
        return health + " / " + maxHealth;
    }
    
    public ImageIcon[] getBar()
    {
        return new ImageIcon[] {myImage, myEmpty};
    }
    
    public int getOffset()
    {
        return myOffset;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }

    public ImageIcon getFull()
    {
        return mainImage;
    }

    public ImageIcon getEmpty()
    {
        return myEmpty;
    }
}
