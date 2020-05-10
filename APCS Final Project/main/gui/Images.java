package gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images
{
    private ImageIcon floor1, floor2, floor3, floor4, floor5, floor6, floor7, floor8, leftcorner, rightcorner, bottom1, bottom2, bottom3, bottom4, top1, top2, top3, top4, left1, left2, left3, left4, right1, right2, right3, right4,dark, torch1, torch2, torch3, torch4,warrior1, warrior2, warrior3, warrior4,skeleton1, skeleton2, skeleton3, skeleton4;
    public Images()
    {
        BufferedImage tileSet = loadImg("main/images/Dungeon_Tileset.png");
        
        floor1 = resize(crop(tileSet, 96, 0, 16, 16), 32, 32);
        floor2 = resize(crop(tileSet, 112, 0, 16, 16 ), 32, 32);
        floor3 = resize(crop(tileSet, 128, 0, 16, 16 ), 32, 32);
        floor4 = resize(crop(tileSet, 144, 0, 16, 16 ), 32, 32);
        floor5 = resize(crop(tileSet, 96, 16, 16, 16 ), 32, 32);
        floor6 = resize(crop(tileSet, 112, 16, 16, 16 ), 32, 32);
        floor7 = resize(crop(tileSet, 128, 16, 16, 16 ), 32, 32);
        floor8 = resize(crop(tileSet, 144, 16, 16, 16 ), 32, 32);
        rightcorner = resize(crop(tileSet, 80, 64, 16, 16 ), 32, 32);
        leftcorner = resize(crop(tileSet, 0, 64, 16, 16 ), 32, 32);
        bottom1 = resize(crop(tileSet, 16, 64, 16, 16 ), 32, 32);
        bottom2 = resize(crop(tileSet, 32, 64, 16, 16 ), 32, 32);
        bottom3 = resize(crop(tileSet, 48, 64, 16, 16 ), 32, 32);
        bottom4 = resize(crop(tileSet, 64, 64, 16, 16 ), 32, 32);
        top1 = resize(crop(tileSet, 16, 0, 16, 16 ), 32, 32);
        top2 = resize(crop(tileSet, 32, 0, 16, 16 ), 32, 32);
        top3 = resize(crop(tileSet, 48, 0, 16, 16 ), 32, 32);
        top4 = resize(crop(tileSet, 64, 0, 16, 16 ), 32, 32);
        left1 = resize(crop(tileSet, 0, 0, 16, 16 ), 32, 32);
        left2 = resize(crop(tileSet, 0, 16, 16, 16 ), 32, 32);
        left3 = resize(crop(tileSet, 0, 32, 16, 16 ), 32, 32);
        left4 = resize(crop(tileSet, 0, 48, 16, 16 ), 32, 32);
        right1 = resize(crop(tileSet, 80, 0, 16, 16 ), 32, 32);
        right2 = resize(crop(tileSet, 80, 16, 16, 16 ), 32, 32);
        right3 = resize(crop(tileSet, 80, 32, 16, 16 ), 32, 32);
        right4 = resize(crop(tileSet, 80, 48, 16, 16 ), 32, 32);
        dark = resize(crop(tileSet, 128, 112, 16, 16 ), 32, 32);
        torch1 = resize(loadImg("main/images/torch_1.png"), 32, 32);
        torch2 = resize(loadImg("main/images/torch_2.png"), 32, 32);
        torch3 = resize(loadImg("main/images/torch_3.png"), 32, 32);
        torch4 = resize(loadImg("main/images/torch_4.png"), 32, 32);
        warrior1 = resize(loadImg("main/images/warrior_1.png"), 32, 32);
        warrior2 = resize(loadImg("main/images/warrior_2.png"), 32, 32);
        warrior3 = resize(loadImg("main/images/warrior_3.png"), 32, 32);
        warrior4 = resize(loadImg("main/images/warrior_4.png"), 32, 32);
        skeleton1 = resize(loadImg("main/images/sksleton_1.png"), 32, 32);
        skeleton2 = resize(loadImg("main/images/skeleton_2.png"), 32, 32);
        skeleton3 = resize(loadImg("main/images/skeleton_3.png"), 32, 32);
        skeleton4 = resize(loadImg("main/images/skeleton_4.png"), 32, 32);
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
    public ImageIcon[] getFrontTorch()
    {
        return new ImageIcon[] {torch1, torch2, torch3, torch4};
    }
    public ImageIcon[] getWarrior()
    {
        return new ImageIcon[] {warrior1, warrior2, warrior3, warrior4};
    }
    public ImageIcon[] getSkeleton()
    {
        return new ImageIcon[] {skeleton1, skeleton2, skeleton3, skeleton4};
    }
    
    public static ImageIcon combine(ImageIcon bottom, ImageIcon top)
    {
        BufferedImage finalImage = new BufferedImage(bottom.getIconWidth(), bottom.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = finalImage.createGraphics();
        g.drawImage(bottom.getImage(),0,0,null);
        g.drawImage( top.getImage(), 0, 0, null );
        g.dispose();
        return new ImageIcon(finalImage);
    }
    public static ImageIcon resize(BufferedImage img, int newW, int newH) {
        Image image = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }  
    
    public static BufferedImage crop(BufferedImage img, int x, int y, int width, int height)
    {
        return img.getSubimage( x, y, width, height );
    }
    
    public static BufferedImage loadImg(String path)
    {
        try
        {
            return ImageIO.read(new File( path ));
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            return null;
        }
    }
}
