package game.powerups;

import game.Game;

/**
 * Class that will keep track of how long a powerup is active.
 * 
 * @author Boning
 *
 */
public abstract class PowerupTimer implements Runnable {

    protected Game game;

    /**
     * Constructor for the powerupTimer class.
     * 
     * @param game
     *            in which the timer is active
     */
    public PowerupTimer(Game game) {
        this.game = game;
    }

    /**
     * Will start the timer.
     */
    public abstract void run();

}
