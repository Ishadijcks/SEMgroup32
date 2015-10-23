package game.observers;

import game.Driver;
import game.collisions.Collision;
import game.powerups.PowerupThreadKiller;

/**
 * Game observer class observes the game.
 * @author Floris
 *
 */
public class GameObserver extends Observer {

    /**
     * The constructor of the game observer.
     * 
     * @param subject
     *            of the observer message.
     */
    public GameObserver(Collision subject) {
        super(subject);
        subject.registerObserver(this);
    }

    /**
     * Bubble hits a player.
     */
    @Override
    public void bubblePlayerEvent() {
        PowerupThreadKiller.setDieThreads(true);
        Driver.game.resetLevel();
        Driver.game.loseLife();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PowerupThreadKiller.setDieThreads(false);
    }

}
