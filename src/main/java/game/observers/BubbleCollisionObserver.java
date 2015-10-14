package game.observers;

import game.Collisions;
import game.Game;
import game.Player;
import game.Settings;
import game.bubble.Bubble;

/**
 * Bubble with player Collision clas.
 * 
 * @author Floris
 *
 */
public class BubbleCollisionObserver extends Observer {

    /**
     * Bubble with player Collision.
     * 
     * @param collisions
     *            object
     */
    public BubbleCollisionObserver(Collisions collisions) {
        super(collisions);
        collisions.registerObserver(this);
    }

    /**
     * The update method of the observer.
     * @param target object
     * @param cause object
     * @param game object
     */
    @Override
    public void update(Object bub, Object plyr, Game game) {
        Bubble bubble = (Bubble) bub;
        Player player = (Player) plyr;

        Settings.setDieThreads(true);
        game.resetLevel();
    }

}
