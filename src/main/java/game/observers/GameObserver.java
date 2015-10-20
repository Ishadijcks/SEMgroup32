package game.observers;

import game.Driver;
import game.collisions.Collision;
import settings.threadSettings;


public class GameObserver extends Observer {

	public GameObserver(Collision subject) {
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
