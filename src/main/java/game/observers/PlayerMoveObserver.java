package game.observers;

import game.Collisions;
import game.Game;

/**
 * The player observer class.
 * @author Tim
 *
 */
public class PlayerMoveObserver extends Observer {

    /**
     * Observes player movement.
     * @param collisions collision class for all collisions
     */
    public PlayerMoveObserver(Collisions collisions) {
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
    public void update(Object target, Object cause, Game game) {
        // TODO Auto-generated method stub

    }

}
