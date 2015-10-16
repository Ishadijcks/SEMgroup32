package game.collisions;

import game.Game;
import game.bubble.Bubble;
import game.observers.Observer;
import game.wall.Wall;

/**
 * wall and bubble collision class.
 * @author Floris
 *
 */
public class WallBubbleCollision extends Collision {

    /**
     * The constructor same as the super class Collision.
     */
	public WallBubbleCollision() {
		super();
	}

	@Override
	public boolean checkCollision(Game game) {
        for (Bubble bubble : game.getCurrentLevel().getBubbleList()) {
            for (Wall wall : game.getCurrentLevel().getWallList()) {
                if (wall.expectBubbleCollision(bubble.getX(),
                        bubble.getDiameter())) {
                    notifyListeningObservers(bubble);
                    return true;
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
    		o.wallBubbleEvent(bubble);
    	}
	}

}