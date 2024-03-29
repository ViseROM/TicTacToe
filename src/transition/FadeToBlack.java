package transition;

import java.awt.Graphics2D;
import java.awt.Color;

/**
 * FadeToBlack class executes a fade to black transition animation
 * @author Vachia Thoj
 *
 */
public class FadeToBlack extends Transition
{
	//x and y coordinate of Transition
	private int x;
	private int y;
	
	//For black color opacity
	private int alpha;
	
	//Timer and delay for fade to black animation (length of each animation update)
	private long timer;
	private long delay;
	
	//Timer and delay for how long to wait to declare that transition is done
	private long doneTimer;
	private long doneDelay;
	
	//min and max value of alpha (opacity)
	private static final int MIN_ALPHA = 0;
	private static final int MAX_ALPHA = 255;
	
	/**
	 * Constuctor
	 * @param width (int) The width of the FadeToBlack transition
	 * @param height (int) The height of the FadeToBlack transition
	 */
	public FadeToBlack(int width, int height)
	{
		super(width, height);
		
		this.x = 0;
		this.y = 0;
		this.alpha = MIN_ALPHA;
		this.speed = 10;
		
		this.timer = System.nanoTime();
		this.delay = 20;
		
		this.doneTimer = 0;
		this.doneDelay = 250;
	}
	
	/**
	 * Method that resets the transition
	 */
	public void reset()
	{
		this.done = false;
		this.running = false;
		this.alpha = MIN_ALPHA;
		this.timer = System.nanoTime();
		this.doneTimer = 0;
	}
	
	
	/**
	 * Method that updates the fade to black transition
	 */
	public void update()
	{
		//Execute fade to black transition if running
		if(running == true)
		{
			if(alpha >= MAX_ALPHA)
			{
				if(doneTimer == 0)
				{
					doneTimer = System.nanoTime();
				}
				else if(((System.nanoTime() - doneTimer) / 1000000) > doneDelay)
				{
					done = true;
					running = false;
				}
			}
			else if(((System.nanoTime() - timer) / 1000000) > delay)
			{
				alpha = alpha + speed;
				
				if(alpha > MAX_ALPHA)
				{
					alpha = MAX_ALPHA;
				}
				
				timer = System.nanoTime();
			}
		}
	}
	
	/**
	 * Method that draws the fade to black transition
	 * 
	 * @param g (Graphics2D) The Graphics2D object to be drawn on
	 */
	public void draw(Graphics2D g)
	{
		if(running == true)
		{
			g.setColor(new Color(0, 0, 0, alpha));
			g.fillRect(x, y, width, height);
		}
	}
}