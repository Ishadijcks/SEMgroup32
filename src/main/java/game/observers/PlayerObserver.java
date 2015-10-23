package game.observers;

import game.Driver;
import game.Player;
import game.collisions.Collision;
import settings.PlayerSettings;

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

    /**
     * Player hits a wall.
     */
	@Override
	public void wallPlayerEvent() {
		Player player = Driver.game.getPlayerList().get(0);
        if (player.getMovingRight()) {
            PlayerSettings.setRestrictMovingRight(true);
            PlayerSettings.setRestrictMovingLeft(false);
        } else if (player.getMovingLeft()) {
        	PlayerSettings.setRestrictMovingLeft(true);
        	PlayerSettings.setRestrictMovingRight(false);
        }
		
	}

}
