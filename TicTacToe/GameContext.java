import java.util.*;
import java.text.*;
import java.io.*;
import greenfoot.*; 

public class GameContext  
{
    private int currentState;
    private static GameContext context;
    
    private int[] states;
    private int[][] nextState;
    
    /**
     * Constructor for objects of class GameContext
     */
    private GameContext()
    {
        //Set up FSM
        states = new int[5];
        states[0] = 0;  //MenuState
        states[1] = 1;  //Player1State
        states[2] = 2;  //Player2State
        states[3] = 3;  //CheckBoardState
        states[4] = 4;  //GameOverState
        
        nextState = new int[5][5];
        
        nextState[0][0] = -1;   nextState[0][1] = 1;    nextState[0][2] = 2;    nextState[0][3] = -2;   nextState[0][4] = -2;
        nextState[1][0] = 0;    nextState[1][1] = -2;   nextState[1][2] = 2;    nextState[1][3] = 3;    nextState[1][4] = -2;
        nextState[2][0] = 0;    nextState[2][1] = 1;    nextState[2][2] = -2;   nextState[2][3] = 3;    nextState[2][4] = -2;
        nextState[3][0] = 0;    nextState[3][1] = 1;    nextState[3][2] = 2;    nextState[3][3] = -2;   nextState[3][4] = 4;
        nextState[4][0] = 0;    nextState[4][1] = 1;   nextState[4][2] = -2;   nextState[4][3] = -2;   nextState[4][4] = -2;
        
        currentState = 0;
    }
    
    public static GameContext instance(){
        if(context == null)
        {
            context = new GameContext();
        }
        
        return context;
    }
    
    public void changeState(int transition)
    {
        currentState = nextState[currentState][transition];
        
        if(currentState == -2){
            Greenfoot.stop();
            return;
        }
        
        if(currentState == -1){
            Greenfoot.stop();
            return;
        }
    }
    
    public int getCurrentState()
    {
        return currentState;
    }
    
    public void setCurrentState(int currentState)
    {
        this.currentState = currentState;
    }
}
