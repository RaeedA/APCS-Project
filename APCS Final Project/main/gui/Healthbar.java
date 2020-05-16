package gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Healthbar
{
    private ImageIcon full;
    private ImageIcon empty;
    
    public Healthbar(int size)
    {
        ImageIcon[] images = Images.getHealthBars(size);
        full = images[0];
        empty = images[1];
    }
    
    public ImageIcon getFull()
    {
        return full;
    }
}