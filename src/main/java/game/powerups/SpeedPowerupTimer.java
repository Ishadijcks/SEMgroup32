package game.powerups;

import game.Game;
import game.Player;
import settings.PlayerSettings;
import settings.ThreadSettings;

/**
 * Special timer for the speed powerup.
 * 
 * @author Boning
 *
 */
public class SpeedPowerupTimer extends PowerupTimer {

    private Player player;

    /**
     * Constructor for the Speedpowerup timer.
     * 
     * @param game
     *            in which the timer is active
     */
    public SpeedPowerupTimer(Game game) {
        super(game);
        this.player = game.getPlayerList().get(0);
    }

    /**
     * Let the counter start.
     */
    @Override
    public void run() {

        long start = System.currentTimeMillis();
        long end = start + 5 * 1000; // 5 seconds * 1000 ms/sec
        while (System.currentTimeMillis() < end) {
            if (player.getStepSize() != PlayerSettings
                    .getPlayerPowerupStepSize()
                    && !ThreadSettings.getDieThreads()) {
                player.setStepSize(PlayerSettings.getPlayerPowerupStepSize());
            }
            if (ThreadSettings.getDieThreads()) {
                ThreadSettings.setDieThreads(false);
                end = System.currentTimeMillis();
            }
        }
        ThreadSettings.setDieThreads(false);
        player.setStepSize(PlayerSettings.getPlayerStepSize());
    }

}
