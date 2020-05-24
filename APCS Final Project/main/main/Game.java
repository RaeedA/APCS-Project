package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gui.Level;
import screens.Screen;
import screens.MenuScreen;
import screens.EndScreen;

public class Game extends Thread
{
    Level lvl;
    MenuScreen menu;
    EndScreen end;
    boolean started = false;
    public Game()
    {
//        SwingUtilities.invokeLater( new Runnable() {
//
//            @Override
//            public void run()
//            {
//                
//                
//                //TODO: This will set visibility, etc. Will make changes to Game, Screen, MenuScreen classes
//            }
//            
//        });
        lvl = new Level("gui");
        menu = new MenuScreen();
        menu.setVisible( true );
        
        //menu.setVisible( false );
        //lvl.setVisible( true );
        
        
    }
    
    public void run()
    {
        while(true)
        {
            
        }
        
    }
    
    public Level getLevel()
    {
        return lvl;
    }
}
