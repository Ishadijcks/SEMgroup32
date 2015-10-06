package game.observers;

import game.Collisions;
import game.Game;
import game.Player;
import game.Settings;
import game.bubble.Bubble;

public class BubbleCollisionObserver extends Observer {

	public BubbleCollisionObserver(Collisions collisions) {
		super(collisions);
	}

	@Override
	public void update(Object bub, Object plyr, Game game) {
		Bubble bubble = (Bubble)bub;
		Player player = (Player)plyr;
		
		Settings.setDieThreads(true);
        game.resetLevel();
	}

}
