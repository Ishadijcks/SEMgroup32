package game.observers;

import game.Collisions;
import game.Driver;
import game.Settings;
import game.bubble.Bubble;
import game.powerups.Powerup;

public class GameController extends Observer {

	public GameController(Collisions subject) {
		super(subject);
		subject.registerObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ropeBubbleEvent(Bubble bubble) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bubblePlayerEvent() {
		Settings.setDieThreads(true);
        Driver.game.resetLevel();

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
        

	}

}
