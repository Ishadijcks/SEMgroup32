package game.powerups;

import game.Game;

public class SpeedPowerup extends Powerup {

	public SpeedPowerup(String name, int x, int y, boolean isNormalMode) {
		super(name, x, y, isNormalMode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeEffect() {
		new Thread(new SpeedPowerupTimer(game)).start();
	}

	@Override
	public void setGame(Game game) {
		this.game = game;
	}

}
