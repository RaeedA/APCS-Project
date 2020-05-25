package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gui.Level;
import screens.Screen;
import screens.MenuScreen;
import screens.EndScreen;

public class Game extends Thread
{
    private Level lvl;
    private MenuScreen menu;
    private EndScreen end;
    private ArrayList<Long> scores;
    
    
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
        scores = new ArrayList<Long>(4);
        
        //menu.setVisible( false );
        //lvl.setVisible( true );
        
        
    }
    
    public void endGame()
    {
        lvl.setVisible( false );
        scores.add( lvl.getUserLevelScore() );
        end = new EndScreen();
        end.setVisible( true );
    }
    
    public MenuScreen getMenu()
    {
        return menu;
    }
    
    public Level getLevel()
    {
        return lvl;
    }
    
    public void sortScores( int newScore )
    {

    }
    
    public ArrayList<Long> getScores()
    {
        return scores;
    }
}
