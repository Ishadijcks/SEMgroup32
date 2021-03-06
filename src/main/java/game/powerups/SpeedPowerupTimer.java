package game.powerups;

import game.Game;
import game.Player;

/**
 * Special timer for the speed power up.
 * 
 * @author Boning
 *
 */
public class SpeedPowerupTimer extends PowerupTimer {

    private Player player;

    /**
     * Constructor for the Speed power up timer.
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
        long end = start + 5 * 1000;
        while (System.currentTimeMillis() < end) {
            if (player.getStepSize() != player.getPlayerPowerupStepSize()
                    && !PowerupThreadKiller.getDieThreads()) {
                player.setStepSize(player.getPlayerPowerupStepSize());
            }
            if (PowerupThreadKiller.getDieThreads()) {
                PowerupThreadKiller.setDieThreads(false);
                end = System.currentTimeMillis();
            }
        }
        PowerupThreadKiller.setDieThreads(false);
        player.setStepSize(player.getPlayerNormalStepSize());
    }

}
