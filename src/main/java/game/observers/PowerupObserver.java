package game.observers;

import game.Driver;
import game.bubble.Bubble;
import game.collisions.Collision;
import game.powerups.Powerup;
import game.powerups.PowerupFactory;

/**
 * Powerup with player collisions observer.
 * @author Tim
 *
 */
public class PowerupObserver extends Observer {

	private PowerupFactory pfac = new PowerupFactory();
	
    /**
     * Powerup with player collisions observer constructor.
     * @param collisions class for all collisions
     */
    public PowerupObserver(Collision collisions) {
        super(collisions);
        collisions.registerObserver(this);
    }

	@Override
	public void ropeBubbleEvent(Bubble bubble) {
		
		int bubblePosX = bubble.getX();
        int bubblePosY = bubble.getY();
        
        int powerupChance = 40;        
		if (powerupChance > Math.random() * 100) {
	        Powerup powerup = pfac.createRandomPowerup();
	        powerup.setX(bubblePosX);
	        powerup.setY(bubblePosY);
	        powerup.addToLevel();
	
	    }
		
	}

	@Override
	public void powerupPlayerEvent(Powerup powerup) {
        powerup.setGame(Driver.game);
        powerup.executeEffect();
		
	}

}
