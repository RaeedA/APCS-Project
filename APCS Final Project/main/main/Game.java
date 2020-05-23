package main;

import javax.swing.SwingUtilities;

import gui.Level;
import screens.Screen;
import screens.MenuScreen;

public class Game extends Thread
{
    Level lvl;
    MenuScreen menu;
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
