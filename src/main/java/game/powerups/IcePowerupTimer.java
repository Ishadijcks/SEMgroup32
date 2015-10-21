package game.powerups;

import game.Game;
import settings.PlayerSettings;
import settings.ThreadSettings;

/**
 * Special timer for the ice powerup.
 * 
 * @author Boning
 *
 */
public class IcePowerupTimer extends PowerupTimer {

    /**
     * Constructor for the Icepowerup timer.
     * 
     * @param game
     *            in which the timer is active
     */
    public IcePowerupTimer(Game game) {
        super(game);
    }

    /**
     * Let the counter start.
     */
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long end = start + 5 * 1000; // 5 seconds * 1000 ms/sec
        while (System.currentTimeMillis() < end) {
            if (!PlayerSettings.getPlayerHasIceRope()) {
                PlayerSettings.setPlayerHasIceRope(true);
            }
            if (ThreadSettings.getDieThreads()) {
                ThreadSettings.setDieThreads(false);
                end = System.currentTimeMillis();
            }
        }
        PlayerSettings.setPlayerHasIceRope(false);
    }

}
