package game.observers;

import java.util.ArrayList;

import game.Driver;
import game.bubble.Bubble;
import game.collisions.Collision;
import game.powerups.Powerup;

public class LevelController extends Observer {

	public LevelController(Collision subject) {
		super(subject);
		subject.registerObserver(this);
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
	public void powerupPlayerEvent(Powerup powerup) {
		Driver.game.getCurrentLevel().getPowerupList().remove(powerup);
	}

}
