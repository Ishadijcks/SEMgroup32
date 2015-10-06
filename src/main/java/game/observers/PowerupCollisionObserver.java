package game.observers;

import game.Collisions;
import game.Game;
import game.Player;
import game.log.Logger;
import game.powerups.IcePowerup;
import game.powerups.Powerup;

public class PowerupCollisionObserver extends Observer {

	public PowerupCollisionObserver(Collisions collisions) {
		super(collisions);
	}

	@Override
	public void update(Object pow, Object plyr, Game game) {
		Powerup powerup = (Powerup)pow;
		Player player = (Player)plyr;
		
		powerup.setGame(game);
		powerup.executeEffect();
		game.getCurrentLevel().getPowerupList().remove(powerup);
	}

}
