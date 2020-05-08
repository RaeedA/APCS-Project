package gui;

import javax.swing.JLabel;

public class Tile
{
    boolean passable;
    JLabel myLabel;
    
    public Tile(boolean pass, JLabel label)
    {
        passable = pass;
        myLabel = label;
    }
}
