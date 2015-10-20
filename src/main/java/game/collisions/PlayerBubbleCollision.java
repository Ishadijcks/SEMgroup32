package game.collisions;

import game.Game;
import game.Player;
import game.bubble.Bubble;
import game.log.Logger;
import game.observers.BubbleObserver;
import game.observers.GameObserver;
import game.observers.LevelObserver;
import game.observers.Observer;
import game.observers.PlayerObserver;
import game.observers.PowerupObserver;

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

	@Override
	public void notifyListeningObservers() {
		for (Observer o : observers) {
    		o.bubblePlayerEvent();
    	}
	}

	@Override
	public void notifyListeningObservers(Object object) {
		// TODO Auto-generated method stub
		
	}

}
