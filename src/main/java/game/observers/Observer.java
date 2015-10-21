package game.observers;

import game.bubble.Bubble;
import game.powerups.Powerup;

/**
 * Observer class for the game.
 * 
 * @author Floris
 *
 */
public abstract class Observer {

    protected Object subject;

    /**
     * constructor.
     * 
     * @param subject
     *            collisions object
     */
    public Observer(Object subject) {
        this.subject = subject;
    }

    /**
     * The method that fires when a rope intersect with a bubble.
     * 
     * @param bubble
     *            that is being collided with
     */
    public void ropeBubbleEvent(Bubble bubble) {

    }

    /**
     * The method that fires when a bubble intersects with a player.
     */
    public void bubblePlayerEvent() {

    }

    /**
     * The method that fires when a wall intersects with a player.
     */
    public void wallPlayerEvent() {

    }

    /**
     * The method that fires when a wall intersects with a bubble.
     * 
     * @param bubble
     *            that is being collided with
     * @param vertical
     *            direction boolean of the bubble bounce
     */
    public void wallBubbleEvent(Bubble bubble, boolean vertical) {
    }

    /**
     * @param bubble
     *            that is being collided with
     */
    public void wallBubbleEvent(Bubble bubble) {

    }

    /**
     * The method that fires when a powerup intersects with a player.
     * 
     * @param powerup
     *            that is being collided with
     */
    public void powerupPlayerEvent(Powerup powerup) {

    }
}
