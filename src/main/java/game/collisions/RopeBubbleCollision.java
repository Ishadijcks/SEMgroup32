package game.collisions;

import game.Game;
import game.Rope;
import game.bubble.Bubble;
import game.log.Logger;
import game.observers.Observer;

/**
 * Bubble and rope collision class.
 * @author Floris
 *
 */
public class RopeBubbleCollision extends Collision {

    /**
     * The constructor same as the super class Collision.
     */
	public RopeBubbleCollision() {
		super();
	}

	@Override
	public boolean checkCollision(Game game) {
		if (game.getCurrentLevel().hasRope()) {
			Rope rope = game.getCurrentLevel().getRope();
	        for (Bubble bubble : game.getCurrentLevel().getBubbleList()) {
	            if (bubble.getX() <= rope.getX()) {
	                if (bubble.getX() + bubble.getDiameter() >= rope.getX()) {
	                    if (bubble.getY() + bubble.getDiameter() >= rope.getY()) {
	                        Logger.log("Rope collided with a bubble", 8, 4);
	                        notifyListeningObservers(bubble);
	                        return true;
	                    }
	                }
	            }
	        }
		}
        return false;
	}

	@Override
	public void notifyListeningObservers() {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyListeningObservers(Object object) {
		Bubble bubble = (Bubble) object;
    	for (Observer o : observers) {
    		o.ropeBubbleEvent(bubble);
    	}
	}

}
