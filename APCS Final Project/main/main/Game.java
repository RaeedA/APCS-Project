package main;

import java.util.ArrayList;
import java.util.Collections;

import gui.Level;
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
        menu = new MenuScreen();
        menu.setVisible( true );
        scores = new ArrayList<Long>(5);
    }
    
    public void endGame()
    {
        long recentScore = lvl.getUserLevelScore();
        boolean isNewestRecord;
        lvl.setVisible( false );
        if(scores.size() > 0 && recentScore > scores.get( 0 ))
        {
            isNewestRecord = true;
        }
        else
        {
            isNewestRecord = false;
        }
        scores.add( recentScore );
        sortScores();
        end = new EndScreen();
        end.recentIsNewRecord(isNewestRecord);
        end.setRecentScore( recentScore );
        end.setVisible( true );
    }
    
    public void startGame()
    {
        lvl = new Level("Dungeon Crawler");
        lvl.setVisible( true );
        lvl.startGame();
    }
    
    public MenuScreen getMenu()
    {
        return menu;
    }
    
    public Level getLevel()
    {
        return lvl;
    }
    
    public void sortScores(  )
    {
        Collections.sort(scores);
        Collections.reverse( scores );
    }
    
    public ArrayList<Long> getScores()
    {
        return scores;
    }
}
