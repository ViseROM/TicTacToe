import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Panel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Panel extends Actor
{   
    private int markType;
    private static GameContext context;
    private int column;
    private int row;
    
    public Panel(int width, int height, int column, int row){
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);
        
        context = GameContext.instance();
        markType = 0;
        
        this.column = column;
        this.row = row;
    }
    
    /**
     * Act - do whatever the Panel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        if(markType == 0){
             if(Greenfoot.mouseClicked(this) && context.getCurrentState() == 1){
                 //Add O mark
                 OMark o = new OMark();
                 getWorld().addObject(o, getX(), getY());
                 markType = 1;
                 
                 //Go to checkBoardState
                 context.changeState(3);
             }
             else if (Greenfoot.mouseClicked(this) && context.getCurrentState() == 2){
                 //Add X mark
                 XMark x = new XMark();
                 getWorld().addObject(x, getX(), getY());
                 markType = 2;
                 
                 //Go to checkBoardState
                 context.changeState(3);
             }
        }
    }
    
    public int getMarkType(){
        return markType;
    }
    
    public void markPanel(int mark)
    {
        if(mark == 1)
        {
            OMark o = new OMark();
            getWorld().addObject(o, getX(), getY());
            markType = 1;
        }
        else if (mark == 2)
        {
            XMark x = new XMark();
            getWorld().addObject(x, getX(), getY());
            markType = 2;
        }
        
        
        //Go to checkBoardState
        context.changeState(3);
    }
    
    public int getColumn()
    {
        return column;
    }
    
    public int getRow()
    {
        return row;
    }
}
