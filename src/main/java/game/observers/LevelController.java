package game.observers;

import java.util.ArrayList;

import game.Collisions;
import game.Driver;
import game.bubble.Bubble;
import game.powerups.Powerup;

public class LevelController extends Observer {

	public LevelController(Collisions subject) {
		super(subject);
		subject.registerObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ropeBubbleEvent(Bubble bubble) {
		ArrayList<Bubble> bubbleList = Driver.game.getCurrentLevel().getBubbleList();
		Driver.game.getCurrentLevel().setRope(null);
		
		int bubblePosX = bubble.getX();
        int bubblePosY = bubble.getY();

        Driver.score.addScore(bubble.getScoreWorth());
        bubbleList.addAll(bubble.destroyBubble(bubblePosX, bubblePosY));
        bubbleList.remove(bubble);

	}

	@Override
	public void bubblePlayerEvent() {
		// TODO Auto-generated method stub

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
		Driver.game.getCurrentLevel().getPowerupList().remove(powerup);
	}

}
