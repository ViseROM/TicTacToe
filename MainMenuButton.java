import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QuitButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenuButton extends Actor
{
    private GreenfootImage image1 = new GreenfootImage("MainMenuButton1.png");
    private GreenfootImage image2 = new GreenfootImage("MainMenuButton2.png");
    private static GameContext context;
    public MainMenuButton()
    {
        GreenfootImage image = image1;
        image.scale(224, 30);
        setImage(image);
        
        context = GameContext.instance();
    }
    
    public void act() 
    {
        touchingButton();
        
        if(Greenfoot.mouseClicked(this) && context.getCurrentState() == 4)
        {   
            //Change To TitleScreenState
            context.changeState(0);
            
            //Change To TitleScreen World
            Greenfoot.setWorld(new TitleScreen());
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
            image2.scale(234, 30);
            setImage(image2);
        }
        else if(getImage() != image1)
        {
            setImage(image1);
        }
    }
}
