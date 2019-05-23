import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NoWinnerLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NoWinnerLabel extends Actor
{
    public NoWinnerLabel()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 3, image.getHeight() / 3);
        setImage(image);
    }    
}
