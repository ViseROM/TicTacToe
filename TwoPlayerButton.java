import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TwoPlayerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwoPlayerButton extends Actor
{
    private GreenfootImage image1 = new GreenfootImage("2PlayerButton-1.png");
    private GreenfootImage image2 = new GreenfootImage("2PlayerButton-2.png");
    private static GameContext context;
    
    /**
     * Act - do whatever the TwoPlayerButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TwoPlayerButton() 
    {
        GreenfootImage image = image1;
        image.scale(248, 44);
        setImage(image);
        
        
        //Get context
        context = GameContext.instance();
    }
    
    public void act()
    {
        touchingButton();
        
        
        if(Greenfoot.mouseClicked(this) && context.getCurrentState() == 0)
        {
            getWorld().removeObject(this);
            
            //Switch to Player1State
            context.changeState(1);
            
            //Change world to Board
            Greenfoot.setWorld(new Board(2));
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
            image2.scale(258, 45);
            setImage(image2);
        }
        else if(getImage() != image1)
        {
            setImage(image1);
        }
    }
}
