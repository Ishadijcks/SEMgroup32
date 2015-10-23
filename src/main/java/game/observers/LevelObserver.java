package game.observers;

import java.util.ArrayList;

import game.Driver;
import game.bubble.Bubble;
import game.collisions.Collision;
import game.powerups.Powerup;

/**
 * Controls the evens in the level as bubbles, rope and score.
 * @author Tim
 *
 */
public class LevelObserver extends Observer {

    /**
     * The constructor of the observer with the subject.
     * @param subject object an collision object for the observer.
     */
	public LevelObserver(Collision subject) {
		super(subject);
		subject.registerObserver(this);
	}

	/**
	 * Bubble hits a rope.
	 */
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

	/**
	 * Player picks up a powerup.
	 */
	@Override
	public void powerupPlayerEvent(Powerup powerup) {
		Driver.game.getCurrentLevel().getPowerupList().remove(powerup);
	}

}
