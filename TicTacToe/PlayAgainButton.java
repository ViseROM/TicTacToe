import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgainButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgainButton extends Actor
{
    private GreenfootImage image1 = new GreenfootImage("playAgainButton.png");
    private GreenfootImage image2 = new GreenfootImage("playAgainButton2.png");
    private static GameContext context;
    
    public PlayAgainButton()
    {
        GreenfootImage image = image1;
        image.scale(190, 30);
        setImage(image);
        
        context = GameContext.instance();
    }
    
    
    /**
     * Act - do whatever the PlayAgainButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        touchingButton();
        
        if(Greenfoot.mouseClicked(this) && context.getCurrentState() == 4)
        {
            //Switch to Player1State
            context.changeState(1);
            
            Board board = (Board) getWorld();
            if(board.getCurrentGameMode() == 1)
            {
                //Set the world to Board
                Greenfoot.setWorld(new Board(1));
            }
            else
            {
                //Set the world to Board
                Greenfoot.setWorld(new Board(2));
            }
        }
    } 
    
    
    private void touchingButton()
    {
        int xLocation = getX();
        int yLocation = getY();
        
        int width = getImage().getWidth() / 2;
        int height = getImage().getHeight() / 2;
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse == null)
        {
            return;
        }
        
        if( (mouse.getX() >= xLocation - width && mouse.getX() <= xLocation + width) && (mouse.getY() >= yLocation - height && mouse.getY() <= yLocation + height))
        {
            image2.scale(200, 35);
            setImage(image2);
        }
        else if(getImage() != image1)
        {
            setImage(image1);
        }
    }
}
