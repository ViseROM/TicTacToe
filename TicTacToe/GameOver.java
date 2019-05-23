import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    public GameOver(){
        GreenfootImage image = getImage();
        image.scale(400, 400);
        image.setTransparency(200);
        setImage(image);
    }
}
