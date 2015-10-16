package game.observers;

import settings.powerupSettings;
import game.Driver;
import game.Game;
import game.Player;
import game.bubble.Bubble;
import game.collisions.Collision;
import game.log.Logger;
import game.powerups.IcePowerup;
import game.powerups.Powerup;
import game.powerups.PowerupFactory;

/**
 * Powerup with player collisions observer.
 * @author Tim
 *
 */
public class PowerupController extends Observer {

	private PowerupFactory pfac = new PowerupFactory();
	
    /**
     * Powerup with player collisions observer constructor.
     * @param collisions class for all collisions
     */
    public PowerupController(Collision collisions) {
        super(collisions);
        collisions.registerObserver(this);
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ropeBubbleEvent(Bubble bubble) {
		
		int bubblePosX = bubble.getX();
        int bubblePosY = bubble.getY();
        
		if (powerupSettings.getPowerupChance() > Math.random() * 100) {
	        Powerup powerup = pfac.createRandomPowerup();
	        powerup.setX(bubblePosX);
	        powerup.setY(bubblePosY);
	        powerup.addToLevel();
	
	    }
		
	}

	@Override
	public void bubblePlayerEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wallPlayerEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wallBubbleEvent(Bubble bubble) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerupPlayerEvent(Powerup powerup) {
        powerup.setGame(Driver.game);
        powerup.executeEffect();
		
	}

}
