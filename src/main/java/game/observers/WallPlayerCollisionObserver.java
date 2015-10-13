package game.observers;

import game.Collisions;
import game.Game;
import game.Player;
import game.Settings;

/**
 * Wall with Player collisions observer.
 * @author Floris
 *
 */
public class WallPlayerCollisionObserver extends Observer {

    /**
     * Constructor.
     * @param collisions class for all collision
     */
    public WallPlayerCollisionObserver(Collisions collisions) {
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
    public void update(Object wall, Object plyr, Game game) {
        Player player = (Player) plyr;
        if (player.getMovingRight()) {
            Settings.setRestrictMovingRight(true);
            Settings.setRestrictMovingLeft(false);
        } else if (player.getMovingLeft()) {
            Settings.setRestrictMovingLeft(true);
            Settings.setRestrictMovingRight(false);
        }

    }

}
