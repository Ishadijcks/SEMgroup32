package game.collisions;

import game.Game;
import game.Player;
import game.log.Logger;
import game.observers.Observer;
import game.powerups.Powerup;

/**
 * Player and powerup collision class.
 * @author Floris
 *
 */
public class PlayerPowerupCollision extends Collision {

    /**
     * The constructor same as the super class Collision.
     */
	public PlayerPowerupCollision() {
		super();
	}

	/**
     * Checks the collision between a player and a bubble.
     */
	@Override
	public boolean checkCollision(Game game) {
        Player player1 = game.getPlayerList().get(0);
        for (Powerup powerup : game.getCurrentLevel().getPowerupList()) {
            if (player1.getCollisionX() <= (powerup.getX() + powerup.getWidth())
                    && (player1.getCollisionX() + player1.getWidth()) >= powerup
                            .getX()
                    && player1.getCollisionY() <= (powerup.getY() + powerup
                            .getHeight())
                    && (player1.getY() + player1.getHeight()) >= powerup.getY()) {
                Logger.log("Player collided with a powerup", 8, 4);
                notifyListeningObservers(powerup);

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
		// TODO Auto-generated method stub

	}

	/**
     * Notify the collision.
     */
	@Override
	public void notifyListeningObservers(Object object) {
		Powerup powerup = (Powerup) object;
    	for (Observer o : observers) {
    		o.powerupPlayerEvent(powerup);
    	}
	}

}
