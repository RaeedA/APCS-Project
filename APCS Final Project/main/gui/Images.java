package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Images
{
    private ImageIcon floor1, floor2, floor3, floor4, floor5, floor6, floor7, floor8, leftcorner, rightcorner, bottom1, bottom2, bottom3, bottom4, top1, top2, top3, top4, left1, left2, left3, left4, right1, right2, right3, right4,dark;
    public Images()
    {
        BufferedImage img = null;
        try
        {
            File file = new File("gui/Dungeon_Tileset.png");
            img = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }
        
        floor1 = new ImageIcon(img.getSubimage( 96, 0, 16, 16 ));
        floor2 = new ImageIcon(img.getSubimage( 112, 0, 16, 16 ));
        floor3 = new ImageIcon(img.getSubimage( 128, 0, 16, 16 ));
        floor4 = new ImageIcon(img.getSubimage( 144, 0, 16, 16 ));
        floor5 = new ImageIcon(img.getSubimage( 96, 16, 16, 16 ));
        floor6 = new ImageIcon(img.getSubimage( 112, 16, 16, 16 ));
        floor7 = new ImageIcon(img.getSubimage( 128, 16, 16, 16 ));
        floor8 = new ImageIcon(img.getSubimage( 144, 16, 16, 16 ));
        rightcorner = new ImageIcon(img.getSubimage( 80, 64, 16, 16 ));
        leftcorner = new ImageIcon(img.getSubimage( 0, 64, 16, 16 ));
        bottom1 = new ImageIcon(img.getSubimage( 16, 64, 16, 16 ));
        bottom2 = new ImageIcon(img.getSubimage( 32, 64, 16, 16 ));
        bottom3 = new ImageIcon(img.getSubimage( 48, 64, 16, 16 ));
        bottom4 = new ImageIcon(img.getSubimage( 64, 64, 16, 16 ));
        top1 = new ImageIcon(img.getSubimage( 16, 0, 16, 16 ));
        top2 = new ImageIcon(img.getSubimage( 32, 0, 16, 16 ));
        top3 = new ImageIcon(img.getSubimage( 48, 0, 16, 16 ));
        top4 = new ImageIcon(img.getSubimage( 64, 0, 16, 16 ));
        left1 = new ImageIcon(img.getSubimage( 0, 0, 16, 16 ));
        left2 = new ImageIcon(img.getSubimage( 0, 16, 16, 16 ));
        left3 = new ImageIcon(img.getSubimage( 0, 32, 16, 16 ));
        left4 = new ImageIcon(img.getSubimage( 0, 48, 16, 16 ));
        right1 = new ImageIcon(img.getSubimage( 80, 0, 16, 16 ));
        right2 = new ImageIcon(img.getSubimage( 80, 16, 16, 16 ));
        right3 = new ImageIcon(img.getSubimage( 80, 32, 16, 16 ));
        right4 = new ImageIcon(img.getSubimage( 80, 48, 16, 16 ));
        dark = new ImageIcon(img.getSubimage( 128, 112, 16, 16 ));

    }
    
    public ImageIcon[] getFloor()
    {
        return new ImageIcon[] {floor1,floor2,floor3,floor4, floor5, floor6, floor7, floor8};
    }
    public ImageIcon[] getCorners()
    {
        return new ImageIcon[] {leftcorner, rightcorner};
    }
    public ImageIcon[] getBottom()
    {
        return new ImageIcon[] {bottom1, bottom2, bottom3, bottom4};
    }
    public ImageIcon[] getTop()
    {
        return new ImageIcon[] {top1, top2, top3, top4};
    }
    public ImageIcon[] getRight()
    {
        return new ImageIcon[] {right1, right2, right3, right4};
    }
    public ImageIcon[] getLeft()
    {
        return new ImageIcon[] {left1, left2, left3, left4};
    }
    public ImageIcon getEmpty()
    {
        return dark;
    }
}
