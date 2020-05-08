package gui;

import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Torch
{
    ImageIcon[] images;
    int num;
    final GridBagConstraints constraints;
    JLabel label;
    
    public Torch(Images image, GridBagConstraints c)
    {
        constraints = c;
        ImageIcon wall = image.getTop()[(int)(Math.random()*4)];
        ImageIcon[] temp = image.getFrontTorch();
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
    public GridBagConstraints getConstraints()
    {
        return constraints;
    }
}
