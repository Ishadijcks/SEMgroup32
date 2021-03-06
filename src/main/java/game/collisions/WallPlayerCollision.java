package game.collisions;

import game.Game;
import game.Player;
import game.observers.Observer;
import game.wall.Wall;

/**
 * wall and player collision class.
 * @author Floris
 *
 */
public class WallPlayerCollision extends Collision {

    /**
     * The constructor same as the super class Collision.
     */
	public WallPlayerCollision() {
		super();
	}

	/**
     * Checks the collision between a player and a bubble.
     */
	@Override
	public boolean checkCollision(Game game) {
        Player player = game.getPlayerList().get(0);
        for (Wall wall : game.getCurrentLevel().getWallList()) {
            if (wall.expectPlayerCollision(player.getX(), player.getY(),
                    player.getMovingLeft())) {
                notifyListeningObservers();
                return true;
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
    		o.wallPlayerEvent();
    	}

	}

	/**
     * Notify the collision.
     */
	@Override
	public void notifyListeningObservers(Object object) {
		// TODO Auto-generated method stub

	}

}
