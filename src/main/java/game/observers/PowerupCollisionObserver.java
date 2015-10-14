package game.observers;

import game.Collisions;
import game.Game;
import game.Player;
import game.log.Logger;
import game.powerups.IcePowerup;
import game.powerups.Powerup;

/**
 * Powerup with player collisions observer.
 * @author Tim
 *
 */
public class PowerupCollisionObserver extends Observer {

    /**
     * Powerup with player collisions observer constructor.
     * @param collisions class for all collisions
     */
    public PowerupCollisionObserver(Collisions collisions) {
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
    public void update(Object pow, Object plyr, Game game) {
        Powerup powerup = (Powerup) pow;
        Player player = (Player) plyr;

        powerup.setGame(game);
        powerup.executeEffect();
        game.getCurrentLevel().getPowerupList().remove(powerup);
    }

}
