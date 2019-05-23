import java.util.*;
import java.io.*;
import greenfoot.*;
import java.util.LinkedList;

/**
 * Write a description of class CPU here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AIPlayer extends Player
{   
    private final int NUM_COLUMNS = 3;
    private final int NUM_ROWS = 3;
    private Board board;
    private Panel[][] panels = new Panel[NUM_COLUMNS][NUM_ROWS];
    private LinkedList <Panel> available;
    private int numAvailable;
    private static GameContext context;
    /**
     * Constructor for objects of class CPU
     */
    public AIPlayer(int markType)
    {
        super(markType);
        available = new LinkedList <Panel>();
        numAvailable = 0;
        context = GameContext.instance();
        getImage().setTransparency(0);
    }
    
    public void act()
    {
        if(context.getCurrentState() == 2)
        {
            board = (Board) getWorld();
            availableMoves();
            makeMove();
        }
    }
    
    private void availableMoves()
    {   
        numAvailable = 0;
        if(board == null)
        {
            return;
        }
        
        panels = board.getBoard();
        
        for(int i = 0; i < NUM_COLUMNS; i++)
        {
            for(int j = 0; j < NUM_ROWS; j++)
            {
                if(panels[i][j].getMarkType() == 0)
                {
                    available.add(panels[i][j]);
                    ++numAvailable;
                }
            }
        }
    }
    
    private void makeMove()
    {   
        if(board == null)
        {
            return;
        }
        
        Greenfoot.delay(25);
        if(numAvailable != 0)
        {
            int index = Greenfoot.getRandomNumber(numAvailable);
            available.get(index).markPanel(markType);
            available.clear();
        }
    }
}









