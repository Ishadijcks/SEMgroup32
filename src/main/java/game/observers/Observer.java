package game.observers;

import game.Game;
import game.bubble.Bubble;
import game.powerups.Powerup;

/**
 * Observer class for the game.
 * @author Floris
 *
 */
public abstract class Observer {
	
	protected Object subject;

	/**
     * constructor.
     * @param collisions object
     */
	public Observer(Object subject){
		this.subject = subject;
	}

    /**
     * The update method of the observer.
     */
    public abstract void update();
    
    /**
     * The method that fires when a rope intersect with a bubble.
     * @param bubble that is being collided with
     */
    public abstract void ropeBubbleEvent(Bubble bubble);
    
    /**
     * The method that fires when a bubble intersects with a player.
     */
    public abstract void bubblePlayerEvent();
    
    /**
     * The method that fires when a wall intersects with a player.
     */
    public abstract void wallPlayerEvent();
    
    /**
     * The method that fires when a wall intersects with a bubble.
     * @param bubble that is being collided with
     */
    public abstract void wallBubbleEvent(Bubble bubble);
    
    /**
     * The method that fires when a powerup intersects with a player.
     * @param powerup that is being collided with
     */
    public abstract void powerupPlayerEvent(Powerup powerup);

}
