import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerLabel extends Actor
{
    private GreenfootImage label1 = new GreenfootImage("player1.png");
    private GreenfootImage label2 = new GreenfootImage("player2.png");
    private GreenfootImage label3 = new GreenfootImage("player1-1.png");
    private GreenfootImage label4 = new GreenfootImage("player2-1.png");
    private GreenfootImage label5 = new GreenfootImage("win.png");
    private static GameContext context;
    
    public PlayerLabel(int type)
    {
        if(type == 1)
        {
             GreenfootImage image = label1;
             image.scale(186, 33);
             setImage(image);
        }
        else if(type == 2)
        {
            GreenfootImage image = label2;
            image.scale(186, 33);
            setImage(image);
        }
        else if(type == 3)
        {
            GreenfootImage image = label5;
            image.scale(186, 33);
            setImage(image);
        }
        context = GameContext.instance();
    }
}
