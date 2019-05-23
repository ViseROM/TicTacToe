import greenfoot.*;
import java.io.*;
import java.util.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    protected int markType;
    /**
     * Constructor for objects of class Player
     */
    public Player(int markType)
    {
        this.markType = markType;
    }
    
    public void setMarkType(int m){
        markType = m;
    }
    
    public int getMarkType(){
        return markType;
    }
}
