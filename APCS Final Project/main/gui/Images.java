package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images
{
    private static BufferedImage tileSet = loadImg("main/images/Dungeon_Tileset.png");
    
    private static ImageIcon floor1 = resize(crop(tileSet, 96, 0, 16, 16), 32, 32);
    private static ImageIcon floor2 = resize(crop(tileSet, 112, 0, 16, 16 ), 32, 32);
    private static ImageIcon floor3 = resize(crop(tileSet, 128, 0, 16, 16 ), 32, 32);
    private static ImageIcon floor4 = resize(crop(tileSet, 144, 0, 16, 16 ), 32, 32);
    private static ImageIcon floor5 = resize(crop(tileSet, 96, 16, 16, 16 ), 32, 32);
    private static ImageIcon floor6 = resize(crop(tileSet, 112, 16, 16, 16 ), 32, 32);
    private static ImageIcon floor7 = resize(crop(tileSet, 128, 16, 16, 16 ), 32, 32);
    private static ImageIcon floor8 = resize(crop(tileSet, 144, 16, 16, 16 ), 32, 32);
    private static ImageIcon rightcorner = resize(crop(tileSet, 80, 64, 16, 16 ), 32, 32);
    private static ImageIcon leftcorner = resize(crop(tileSet, 0, 64, 16, 16 ), 32, 32);
    private static ImageIcon bottom1 = resize(crop(tileSet, 16, 64, 16, 16 ), 32, 32);
    private static ImageIcon bottom2 = resize(crop(tileSet, 32, 64, 16, 16 ), 32, 32);
    private static ImageIcon bottom3 = resize(crop(tileSet, 48, 64, 16, 16 ), 32, 32);
    private static ImageIcon bottom4 = resize(crop(tileSet, 64, 64, 16, 16 ), 32, 32);
    private static ImageIcon top1 = resize(crop(tileSet, 16, 0, 16, 16 ), 32, 32);
    private static ImageIcon top2 = resize(crop(tileSet, 32, 0, 16, 16 ), 32, 32);
    private static ImageIcon top3 = resize(crop(tileSet, 48, 0, 16, 16 ), 32, 32);
    private static ImageIcon top4 = resize(crop(tileSet, 64, 0, 16, 16 ), 32, 32);
    private static ImageIcon left1 = resize(crop(tileSet, 0, 0, 16, 16 ), 32, 32);
    private static ImageIcon left2 = resize(crop(tileSet, 0, 16, 16, 16 ), 32, 32);
    private static ImageIcon left3 = resize(crop(tileSet, 0, 32, 16, 16 ), 32, 32);
    private static ImageIcon left4 = resize(crop(tileSet, 0, 48, 16, 16 ), 32, 32);
    private static ImageIcon right1 = resize(crop(tileSet, 80, 0, 16, 16 ), 32, 32);
    private static ImageIcon right2 = resize(crop(tileSet, 80, 16, 16, 16 ), 32, 32);
    private static ImageIcon right3 = resize(crop(tileSet, 80, 32, 16, 16 ), 32, 32);
    private static ImageIcon right4 = resize(crop(tileSet, 80, 48, 16, 16 ), 32, 32);
    private static BufferedImage dark = crop(tileSet, 128, 112, 16, 16 );
    private static ImageIcon torch1 = resize(loadImg("main/images/torch_1.png"), 32, 32);
    private static ImageIcon torch2 = resize(loadImg("main/images/torch_2.png"), 32, 32);
    private static ImageIcon torch3 = resize(loadImg("main/images/torch_3.png"), 32, 32);
    private static ImageIcon torch4 = resize(loadImg("main/images/torch_4.png"), 32, 32);
    private static ImageIcon warrior1 = resize(loadImg("main/images/warriors/warrior_1.png"), 32, 32);
    private static ImageIcon warrior2 = resize(loadImg("main/images/warriors/warrior_2.png"), 32, 32);
    private static ImageIcon warrior3 = resize(loadImg("main/images/warriors/warrior_3.png"), 32, 32);
    private static ImageIcon warrior4 = resize(loadImg("main/images/warriors/warrior_4.png"), 32, 32);
    private static ImageIcon awarrior1 = resize(loadImg("main/images/warriors/awarrior_1.png"), 32, 32);
    private static ImageIcon awarrior2 = resize(loadImg("main/images/warriors/awarrior_2.png"), 32, 32);
    private static ImageIcon awarrior3 = resize(loadImg("main/images/warriors/awarrior_3.png"), 32, 32);
    private static ImageIcon awarrior4 = resize(loadImg("main/images/warriors/awarrior_4.png"), 32, 32);
    /*private static ImageIcon skeleton1 = resize(loadImg("main/images/skeletons/skeleton_1.png"), 32, 32);
    private static ImageIcon skeleton2 = resize(loadImg("main/images/skeletons/skeleton_2.png"), 32, 32);
    private static ImageIcon skeleton3 = resize(loadImg("main/images/skeletons/skeleton_3.png"), 32, 32);
    private static ImageIcon skeleton4 = resize(loadImg("main/images/skeletons/skeleton_4.png"), 32, 32);*/
    private static ImageIcon askeleton1 = resize(loadImg("main/images/skeletons/askeleton_1.png"), 32, 32);
    private static ImageIcon askeleton2 = resize(loadImg("main/images/skeletons/askeleton_2.png"), 32, 32);
    private static ImageIcon askeleton3 = resize(loadImg("main/images/skeletons/askeleton_3.png"), 32, 32);
    private static ImageIcon askeleton4 = resize(loadImg("main/images/skeletons/askeleton_4.png"), 32, 32);
    private static BufferedImage healthbars = loadImg("main/images/Healthbars.png");
    private static BufferedImage full = crop(healthbars, 33, 37, 80, 9);
    private static BufferedImage empty = crop(healthbars, 33, 51, 80, 9);
    
    public Images()
    { 
    }
    
    public static ImageIcon[] getFloor()
    {
        return new ImageIcon[] {floor1,floor2,floor3,floor4, floor5, floor6, floor7, floor8};
    }
    public static ImageIcon[] getCorners()
    {
        return new ImageIcon[] {leftcorner, rightcorner};
    }
    public static ImageIcon[] getBottom()
    {
        return new ImageIcon[] {bottom1, bottom2, bottom3, bottom4};
    }
    public static ImageIcon[] getTop()
    {
        return new ImageIcon[] {top1, top2, top3, top4};
    }
    public static ImageIcon[] getRight()
    {
        return new ImageIcon[] {right1, right2, right3, right4};
    }
    public static ImageIcon[] getLeft()
    {
        return new ImageIcon[] {left1, left2, left3, left4};
    }
    public static ImageIcon getEmpty(int length, int height)
    {
        return resize(dark, length*32, height*32);
    }
    public static ImageIcon[] getFrontTorch()
    {
        return new ImageIcon[] {torch1, torch2, torch3, torch4};
    }
    public static ImageIcon[] getWarrior()
    {
        return new ImageIcon[] {warrior1, warrior2, warrior3, warrior4};
    }
    public static ImageIcon[] getAttackWarrior()
    {
        return new ImageIcon[] {awarrior1, awarrior2, awarrior3, awarrior4};
    }
    public static ImageIcon[] getSkeleton()
    {
        return new ImageIcon[] {askeleton1, askeleton2, askeleton3, askeleton4};
    }
    public static ImageIcon[] getHealthBars(int mult)
    {
        return new ImageIcon[] {resize(crop(full, 8, 0, 64, 9), (int)( (128*mult*0.8)+0.5 ), 16*mult), resize(empty, 128*mult, 16*mult)};
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

    public static ImageIcon combine(ImageIcon bottom, ImageIcon top, int offx, int offy)
    {
        BufferedImage finalImage = new BufferedImage(bottom.getIconWidth(), bottom.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = finalImage.createGraphics();
        g.drawImage(bottom.getImage(), 0, 0, null);
        g.drawImage(top.getImage(), offx, offy, null);
        g.dispose();
        System.out.println("st");
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
    
    public static Font loadFont( float size )
    {
        String path = "main/res/slkscr.ttf";
        try
        {
            return Font.createFont( Font.TRUETYPE_FONT,  new File(path) ).deriveFont( Font.PLAIN, size );
        }
        catch ( FontFormatException e )
        {
            e.printStackTrace();
            System.exit( 1 );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            System.exit( 1 );
        }
        return null;
    }
    public static void drawText(Graphics g, String text, int xPos, int yPos, boolean center, Color color, Font font)
    {
        g.setColor( color );
        g.setFont( font );
        int x = xPos;
        int y = yPos;
        if( center )
        {
            FontMetrics fontMetric = g.getFontMetrics( font );
            x = xPos - fontMetric.stringWidth( text ) / 2;
            y = (yPos - fontMetric.getHeight() / 2) + fontMetric.getAscent();
        }
        g.drawString( text, x, y );
    }
}
