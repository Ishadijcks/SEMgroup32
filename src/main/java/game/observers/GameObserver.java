package game.observers;

import game.Driver;
import game.collisions.Collision;
import settings.ThreadSettings;

/**
     * Game observer controlls the game progress. Other words the game state
     * lost or won enzo..
 * @author Tim
 *
 */
public class GameObserver extends Observer {

    /**
     * The constructor of the game observer.
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
        ThreadSettings.setDieThreads(true);
        Driver.game.resetLevel();
        Driver.game.loseLife();
    }

}
