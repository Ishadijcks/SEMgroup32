package game.observers;

import game.bubble.Bubble;
import game.collisions.Collision;

/**
 * Wall with bubble collisions observer.
 * 
 * @author Tim
 *
 */
public class BubbleObserver extends Observer {

    /**
     * The constructor of the observer class.
     * 
     * @param collisions
     *            class handels all collisions.
     */
    public BubbleObserver(Collision collisions) {
        super(collisions);
        collisions.registerObserver(this);
    }

    @Override
    public void wallBubbleEvent(Bubble bubble, boolean vertical) {
        if (vertical) {
            bubble.bounceH();
        } else {
            bubble.wallBounceBoost();
            bubble.bounceV();
        }
    }
}
