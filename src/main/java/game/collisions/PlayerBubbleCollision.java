package game.collisions;

import game.Game;
import game.Player;
import game.bubble.Bubble;
import game.log.Logger;
import game.observers.Observer;

/**
 * Bubble and player collision class.
 * @author Floris
 *
 */
public class PlayerBubbleCollision extends Collision {

    /**
     * The constructor same as the super class Collision.
     */
	public PlayerBubbleCollision() {
		super();
	}

	/**
	 * Checks the collision between a player and a bubble.
	 */
	@Override
	public boolean checkCollision(Game game) {
		
		Player player = game.getPlayerList().get(0);

	    for (Bubble bubble : game.getCurrentLevel().getBubbleList()) {
	        if (player.getX() <= (bubble.getX() + bubble.getDiameter())
	                && (player.getCollisionX() + player.getWidth()) >= bubble
	                        .getX()
	                && player.getCollisionY() <= (bubble.getY() + bubble
	                        .getDiameter())
	                && (player.getY() + player.getHeight()) >= bubble.getY()) {
	            if (player.getCollisionY() <= bubble.getY()) {
	                Logger.log("Player collided with a bubble", 8, 4);
	                notifyListeningObservers();
	                return true;
	            }
	        }
	    }
	    return false;
	}

	/**
     * Notify the collision.
     */
	@Override
	public void notifyListeningObservers() {
		for (Observer o : observers) {
    		o.bubblePlayerEvent();
    	}
	}

	/**
     * Notify the collision.
     */
	@Override
	public void notifyListeningObservers(Object object) {
		
	}

}
