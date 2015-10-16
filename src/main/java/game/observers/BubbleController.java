package game.observers;

import game.Game;
import game.bubble.Bubble;
import game.collisions.Collision;
import game.powerups.Powerup;

/**
 * Wall  with bubble collisions observer.
 * @author Tim
 *
 */
public class BubbleController extends Observer {

    /**
     * The constructor of the observer class.
     * @param collisions class handels all collisions.
     */
    public BubbleController(Collision collisions) {
        super(collisions);
        collisions.registerObserver(this);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wallPlayerEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wallBubbleEvent(Bubble bubble) {
		bubble.bounceH();		
	}

	@Override
	public void powerupPlayerEvent(Powerup powerup) {
		// TODO Auto-generated method stub
		
	}

}
