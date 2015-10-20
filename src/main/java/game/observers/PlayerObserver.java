package game.observers;

import game.Driver;
import game.Player;
import game.collisions.Collision;
import settings.playerSettings;

/**
 * Wall with Player collisions observer.
 * @author Floris
 *
 */
public class PlayerObserver extends Observer {

    /**
     * Constructor.
     * @param collisions class for all collision
     */
    public PlayerObserver(Collision collisions) {
        super(collisions);
        collisions.registerObserver(this);
    }

	@Override
	public void wallPlayerEvent() {
		Player player = Driver.game.getPlayerList().get(0);
        if (player.getMovingRight()) {
            playerSettings.setRestrictMovingRight(true);
            playerSettings.setRestrictMovingLeft(false);
        } else if (player.getMovingLeft()) {
        	playerSettings.setRestrictMovingLeft(true);
        	playerSettings.setRestrictMovingRight(false);
        }
		
	}

}
