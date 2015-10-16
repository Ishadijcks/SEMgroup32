package game.observers;

import settings.threadSettings;
import game.Driver;
import game.bubble.Bubble;
import game.collisions.Collision;
import game.powerups.Powerup;

public class GameController extends Observer {

	public GameController(Collision subject) {
		super(subject);
		subject.registerObserver(this);
	}

	@Override
	public void bubblePlayerEvent() {
		threadSettings.setDieThreads(true);
        Driver.game.resetLevel();
        Driver.game.loseLife();
	}

}
