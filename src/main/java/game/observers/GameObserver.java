package game.observers;

import game.Driver;
import game.collisions.Collision;
import game.powerups.Powerup;
import game.powerups.PowerupThreadKiller;

public class GameObserver extends Observer {

	public GameObserver(Collision subject) {
		super(subject);
		subject.registerObserver(this);
	}

	@Override
	public void bubblePlayerEvent() {
		PowerupThreadKiller.setDieThreads(true);
        Driver.game.resetLevel();
        Driver.game.loseLife();
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PowerupThreadKiller.setDieThreads(false);
	}

}
