package gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Images
{
    private ImageIcon floor1, floor2, floor3, floor4, floor5, floor6, floor7, floor8, leftcorner, rightcorner, bottom1, bottom2, bottom3, bottom4, top1, top2, top3, top4, left1, left2, left3, left4, right1, right2, right3, right4,dark, torch1, torch2, torch3, torch4;
    public Images() throws IOException
    {
        BufferedImage tileSet = loadImg("main/images/Dungeon_Tileset.png");
        
        floor1 = crop(tileSet, 96, 0, 16, 16);
        floor2 = crop(tileSet, 112, 0, 16, 16 );
        floor3 = crop(tileSet, 128, 0, 16, 16 );
        floor4 = new ImageIcon(tileSet.getSubimage( 144, 0, 16, 16 ));
        floor5 = new ImageIcon(tileSet.getSubimage( 96, 16, 16, 16 ));
        floor6 = new ImageIcon(tileSet.getSubimage( 112, 16, 16, 16 ));
        floor7 = new ImageIcon(tileSet.getSubimage( 128, 16, 16, 16 ));
        floor8 = new ImageIcon(tileSet.getSubimage( 144, 16, 16, 16 ));
        rightcorner = new ImageIcon(tileSet.getSubimage( 80, 64, 16, 16 ));
        leftcorner = new ImageIcon(tileSet.getSubimage( 0, 64, 16, 16 ));
        bottom1 = new ImageIcon(tileSet.getSubimage( 16, 64, 16, 16 ));
        bottom2 = new ImageIcon(tileSet.getSubimage( 32, 64, 16, 16 ));
        bottom3 = new ImageIcon(tileSet.getSubimage( 48, 64, 16, 16 ));
        bottom4 = new ImageIcon(tileSet.getSubimage( 64, 64, 16, 16 ));
        top1 = new ImageIcon(tileSet.getSubimage( 16, 0, 16, 16 ));
        top2 = new ImageIcon(tileSet.getSubimage( 32, 0, 16, 16 ));
        top3 = new ImageIcon(tileSet.getSubimage( 48, 0, 16, 16 ));
        top4 = new ImageIcon(tileSet.getSubimage( 64, 0, 16, 16 ));
        left1 = new ImageIcon(tileSet.getSubimage( 0, 0, 16, 16 ));
        left2 = new ImageIcon(tileSet.getSubimage( 0, 16, 16, 16 ));
        left3 = new ImageIcon(tileSet.getSubimage( 0, 32, 16, 16 ));
        left4 = new ImageIcon(tileSet.getSubimage( 0, 48, 16, 16 ));
        right1 = new ImageIcon(tileSet.getSubimage( 80, 0, 16, 16 ));
        right2 = new ImageIcon(tileSet.getSubimage( 80, 16, 16, 16 ));
        right3 = new ImageIcon(tileSet.getSubimage( 80, 32, 16, 16 ));
        right4 = new ImageIcon(tileSet.getSubimage( 80, 48, 16, 16 ));
        dark = new ImageIcon(tileSet.getSubimage( 128, 112, 16, 16 ));
        torch1 = new ImageIcon(resize(ImageIO.read(new File("main/images/torch_1.png")), 16, 16));
        torch2 = new ImageIcon(resize(ImageIO.read(new File("main/images/torch_2.png")), 16, 16));
        torch3 = new ImageIcon(resize(ImageIO.read(new File("main/images/torch_3.png")), 16, 16));
        torch4 = new ImageIcon(resize(ImageIO.read(new File("main/images/torch_4.png")), 16, 16));

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
    public static ImageIcon combine(ImageIcon bottom, ImageIcon top)
    {
        BufferedImage finalImage = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = finalImage.createGraphics();
        g.drawImage(bottom.getImage(),0,0,null);
        g.drawImage( top.getImage(), 0, 0, null );
        g.dispose();
        return new ImageIcon(finalImage);
    }
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;
    }  
    
    public ImageIcon crop(BufferedImage img, int x, int y, int width, int height)
    {
        return new ImageIcon(img.getSubimage( x, y, width, height ));
    }
    
    public BufferedImage loadImg(String path) throws IOException
    {
        return ImageIO.read(new File( path ));
    }
}
