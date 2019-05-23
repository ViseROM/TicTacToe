import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    GameContext context;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(460, 550, 1);
        
        OnePlayerButton onePlayerButton = new OnePlayerButton();
        addObject(onePlayerButton, getWidth() / 2, (getHeight() / 2) + 100);
        TwoPlayerButton twoPlayerButton = new TwoPlayerButton();
        addObject(twoPlayerButton, getWidth()/ 2, (getHeight() / 2) + 165);
        
        context = GameContext.instance();
        
        if(context.getCurrentState() != 0)
        {
            context.setCurrentState(0);
        }
    }
}
