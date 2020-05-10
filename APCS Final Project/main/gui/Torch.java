package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Torch
{
    private ImageIcon[] images;
    private int num;
    private JLabel label;
    
    public Torch()
    {
        ImageIcon wall = Images.getTop()[(int)(Math.random()*4)];
        ImageIcon[] temp = Images.getFrontTorch();
        images = new ImageIcon[temp.length];
        for (int i = 0; i<4; i++)
        {
            ImageIcon pict = Images.combine( wall, temp[i] );
            images[i] = pict;
        }
        num = (int)(Math.random()*4)-1;
        label = new JLabel();
    }
    
    public void update()
    {
        num++;
        if (num == 4)
        {
            num = 0;
        }
        label.setIcon( images[num] );
    }
    
    public JLabel getLabel()
    {
        return label;
    }
}
