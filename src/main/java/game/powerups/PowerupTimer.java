package game.powerups;

import game.Game;

public abstract class PowerupTimer implements Runnable{

	protected Game game;
	
	public PowerupTimer(Game game) {
		this.game = game;
	}
	
	public abstract void run();

}
