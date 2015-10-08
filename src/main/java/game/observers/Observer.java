package game.observers;

import game.Collisions;
import game.Game;

/**
 * Observer class for the game.
 * @author Floris
 *
 */
public abstract class Observer {

    protected Collisions subject;

    /**
     * constructor.
     * @param collisions object
     */
    public Observer(Collisions collisions) {
        this.subject = collisions;
    }

    /**
     * The update method of the observer.
     * @param target object
     * @param cause object
     * @param game object
     */
    public abstract void update(Object target, Object cause, Game game);

}
