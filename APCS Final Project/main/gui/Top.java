package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Top extends JPanel
{
    private ImageIcon full;
    private ImageIcon empty;
    
    public Top(int size)
    {
        setup(size);
    }
    
    public void setup(int size)
    {
        ImageIcon back1;
        ImageIcon back2;
        ImageIcon back3;
        int length = size/3;
        int height = size/4;
        if (size%3 == 0)
        {
            back1 = Images.getEmpty( length, height );
            back2 = Images.getEmpty( length, height );
            back3 = Images.getEmpty( length, height );
        }
        else if (size%3 == 1)
        {
            back1 = Images.getEmpty( length, height );
            back2 = Images.getEmpty( length+1, height );
            back3 = Images.getEmpty( length, height );
        }
        else
        {
            back1 = Images.getEmpty( length+1, height );
            back2 = Images.getEmpty( length, height );
            back3 = Images.getEmpty( length+1, height );
        }
        
        //Work on leftmost side: Contains just the healthbar
        int healthsize = back1.getIconWidth()/128;
        ImageIcon[] bars = Images.getHealthBars( healthsize );
        full = bars[0];
        empty = bars[1];
        int offset = (empty.getIconWidth()-full.getIconWidth())/2;
        back1 = Images.combine( back1, empty, 16, 50 );
        back1 = Images.combine( back1, full, 16+offset, 50 );
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel(back1),c);
        c.gridx = 1;
        c.gridy = 0;
        add(new JLabel(back2),c);
        c.gridx = 2;
        c.gridy = 0;
        add(new JLabel(back3),c);
    }
    
    private void drawBar()
    {
        
    }
    
    public ImageIcon getFull()
    {
        return full;
    }
}