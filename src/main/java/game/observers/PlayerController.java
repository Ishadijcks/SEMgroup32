package game.observers;

import game.Collisions;
import game.Driver;
import game.Game;
import game.Player;
import game.Settings;
import game.bubble.Bubble;
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
    public PlayerController(Collisions collisions) {
        super(collisions);
        collisions.registerObserver(this);
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ropeBubbleEvent(Bubble bubble) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bubblePlayerEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wallPlayerEvent() {
		Player player = Driver.game.getPlayerList().get(0);
        if (player.getMovingRight()) {
            Settings.setRestrictMovingRight(true);
            Settings.setRestrictMovingLeft(false);
        } else if (player.getMovingLeft()) {
            Settings.setRestrictMovingLeft(true);
            Settings.setRestrictMovingRight(false);
        }
		
	}

	@Override
	public void wallBubbleEvent(Bubble bubble) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerupPlayerEvent(Powerup powerup) {
		// TODO Auto-generated method stub
		
	}

}
