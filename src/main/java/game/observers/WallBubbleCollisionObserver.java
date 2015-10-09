package game.observers;

import game.Collisions;
import game.Game;
import game.bubble.Bubble;

/**
 * Wall  with bubble collisions observer.
 * @author Tim
 *
 */
public class WallBubbleCollisionObserver extends Observer {

    /**
     * The constructor of the observer class.
     * @param collisions class handels all collisions.
     */
    public WallBubbleCollisionObserver(Collisions collisions) {
        super(collisions);
        // TODO Auto-generated constructor stub
    }

    /**
     * The update method of the observer.
     * @param target object
     * @param cause object
     * @param game object
     */
    @Override
    public void update(Object wall, Object bubb, Game game) {
        Bubble bubble = (Bubble) bubb;
        bubble.bounceH();
    }

}
