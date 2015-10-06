package game.powerups;

import game.Game;

public class LifePowerup extends Powerup {

	public LifePowerup(String name, int x, int y, boolean isNormalMode) {
		super(name, x, y, isNormalMode);
	}

	@Override
	public void executeEffect() {
		game.getLife();		
	}

	@Override
	public void setGame(Game game) {
		this.game = game;		
	}

}
