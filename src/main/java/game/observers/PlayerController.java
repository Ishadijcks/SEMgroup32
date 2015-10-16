package game.observers;

import settings.playerSettings;
import game.Driver;
import game.Game;
import game.Player;
import game.bubble.Bubble;
import game.collisions.Collision;
import game.powerups.Powerup;

/**
 * Wall with Player collisions observer.
 * @author Floris
 *
 */
public class PlayerController extends Observer {

    /**
     * Constructor.
     * @param collisions class for all collision
     */
    public PlayerController(Collision collisions) {
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
