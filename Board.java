import java.util.*;
import java.text.*;
import java.io.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{
    private final int NUM_COLUMNS = 3;
    private final int NUM_ROWS = 3;
    private final int PANEL_SIZE = 150;
    private Panel[][] panels = new Panel[NUM_COLUMNS][NUM_ROWS];
    private Player player[] = new Player[2];
    private Player currentPlayer;
    private Player winner;
    private static GameContext context;
    private PlayerLabel label[] = new PlayerLabel[2];
    private boolean over = false;
    private Arrow arrow;
    private int numMarked;
    private int currentGameMode;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Board(int gameMode)
    {    
        // Create a new world with 610x710 cells with a cell size of 1x1 pixels.
        super(460, 550, 1);
        
        //Get context
        context = GameContext.instance();
        
        //Create Board
        spawnPanels();
        
        currentGameMode = gameMode;
        
        prepare();
        
        
        //Set currentPlayer
        currentPlayer = player[0];
        
        numMarked = 0;
        
        winner = null;
    }
    
    public void act()
    {
        if(context.getCurrentState() == 3)
        {
            ++numMarked;
            if(numMarked < 5)
            {
                yourTurn();
            }
            else if(checkHorizontal() == true || checkVertical() == true || checkDiagonal() == true)
            {
                //Go to GameOverState
                context.changeState(4);
                winner = currentPlayer;
                removeObject(arrow);
            }
            else if(numMarked == 9)
            {
                context.changeState(4);
                removeObject(arrow);
            }
            else
            {
                yourTurn();
            }
        }
        
        gameOverState();
    }
    
    private void spawnPanels(){
        int xLocation = 75;
        int yLocation = 75;
        
        for(int i = 0; i < NUM_COLUMNS; i++){
            for(int j = 0; j < NUM_ROWS; j++){
                panels[i][j] = new Panel(PANEL_SIZE, PANEL_SIZE, i, j);
                addObject(panels[i][j], xLocation, yLocation);
                xLocation = xLocation + 155;
            }
            yLocation = yLocation + 155;
            xLocation = 75;
        }
    }
    
    private void prepare()
    {   
        if(currentGameMode == 1)
        {
            player[0] = new HumanPlayer(1);
            player[1] = new AIPlayer(2);
            addObject(player[1], 0, 0);
        }
        else
        {
            player[0] = new HumanPlayer(1);
            player[1] = new HumanPlayer(2);
        }
        
        //Create Labels
        label[0] = new PlayerLabel(1);
        label[1] = new PlayerLabel(2);
        addObject(label[0], 100, 500);
        addObject(label[1], 357, 500);
        
        //Create Arrow
        arrow = new Arrow();
        addObject(arrow, 100, 535);
    }
    
    private boolean checkHorizontal(){
        int counter = 0;
        int markType = currentPlayer.getMarkType();
        int xLocation;
        int yLocation;
        
        //Check Horizontal
        for(int i = 0; i < NUM_COLUMNS; i++){
            xLocation = panels[i][0].getX();
            yLocation = panels[i][0].getY();
            for(int j = 0; j < NUM_ROWS; j++){
                if(panels[i][j].getMarkType() == markType){
                    ++counter;
                }
                else
                {
                    break;
                }
            }
            
            if(counter == 3){
                drawLine(xLocation, yLocation, 0, "horizontal");
                return true;
            }
            counter = 0;
        }
        
        return false;
    }
    
    private boolean checkVertical(){
        int counter = 0;
        int markType = currentPlayer.getMarkType();
        int xLocation;
        int yLocation;
        
        //Check Vertical
        for(int i = 0; i < NUM_COLUMNS; i++){
            xLocation = panels[0][i].getX();
            yLocation = panels[0][i].getY();
            
            for(int j = 0; j < NUM_ROWS; j++){
                if(panels[j][i].getMarkType() == markType){
                    ++counter;
                }
                else
                {
                    break;
                }
            }
            
            if(counter == 3){
                drawLine(xLocation, yLocation, 90, "vertical");
                return true;
            }
            counter = 0;
        }
        return false;
    }
    
    private boolean checkDiagonal(){
        int markType = currentPlayer.getMarkType();
        int xLocation;
        int yLocation;
        
        //Check Diagonals
        if(panels[0][0].getMarkType() == markType && panels[1][1].getMarkType() == markType && panels[2][2].getMarkType() == markType){
            xLocation = panels[0][0].getX();
            yLocation = panels[0][0].getY();
            drawLine(xLocation, yLocation, 45, "diagonal");
            return true;
        }
        else if(panels[0][2].getMarkType() == markType && panels[1][1].getMarkType() == markType && panels[2][0].getMarkType() == markType){
            xLocation = panels[0][2].getX();
            yLocation = panels[0][2].getY();
            drawLine(xLocation, yLocation, -45, "diagonal");
            return true;
        }
        return false;
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    private void drawLine(int x, int y, int rotation, String direction)
    {  
        if(direction.equals("horizontal"))
        {
            while(x <= 545)
            {
                Line line = new Line();
                addObject(line, x, y);
                line.setRotation(rotation);
                x += 50;
                Greenfoot.delay(2);
            }
        }
        else if(direction.equals("vertical"))
        {
            while(y <= 375)
            {
                Line line = new Line();
                addObject(line, x, y);
                line.setRotation(rotation);
                y += 70;
                Greenfoot.delay(2);
            }
        }
        else if(direction.equals("diagonal") && rotation > 0)
        {
            while(x <= 400)
            {
                Line line = new Line();
                addObject(line, x, y);
                line.setRotation(rotation);
                x += 50;
                y += 50;
                Greenfoot.delay(2);
            }
        }
        else if(direction.equals("diagonal") && rotation < 0)
        {
            while(x >= 70)
            {
                Line line = new Line();
                addObject(line, x, y);
                line.setRotation(rotation);
                x -= 50;
                y += 50;
                Greenfoot.delay(2);
            }
        }
    }
    
    private void yourTurn()
    {
        if(currentPlayer == player[0])
        {
            //Go to Player2State
            context.changeState(2);
            currentPlayer = player[1];
            arrow.setLocation(357, 535);
        }
        else if(currentPlayer == player[1])
        {
            //Go to Player1State
            context.changeState(1);
            currentPlayer = player[0];
            arrow.setLocation(100, 535);
        }
    }
    
    private void gameOverState()
    {
        if(context.getCurrentState() != 4 || over == true)
        {
            return;
        }
        
        //Create GameOver Box
        GameOver gameOver = new GameOver();
        addObject(gameOver, getWidth() / 2, getHeight() / 2);
        
        //Create Play Again Button
        PlayAgainButton playAgainButton = new PlayAgainButton();
        addObject(playAgainButton, getWidth() / 2, 350);
        
        //Create Main Menu Button
        MainMenuButton mainMenuButton = new MainMenuButton();
        addObject(mainMenuButton, getWidth() / 2, 395);
        if(winner != null)
        {
            PlayerLabel label;
            if(winner == player[0])
            {
                label = new PlayerLabel(1);
            }
            else
            {
                label = new PlayerLabel(2);
            }
            addObject(label, getWidth() / 2, 150);
            
            //Create Win Label
            PlayerLabel win = new PlayerLabel(3);
            addObject(win, getWidth() / 2, 183); 
            
            over = true;
        }
        else if(winner == null) //Draw
        {
            NoWinnerLabel draw = new NoWinnerLabel();
            addObject(draw, getWidth() / 2, 150);
            over = true;
        }
    }
    
    public Panel[][] getBoard()
    {
        return panels;
    }
    
    public int getCurrentGameMode()
    {
        return currentGameMode;
    }
}











