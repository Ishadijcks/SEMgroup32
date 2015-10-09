package game.powerups;

import game.Game;
import game.Player;
import game.Settings;

/**
 * Special timer for the speed powerup.
 * @author Boning
 *
 */
public class SpeedPowerupTimer extends PowerupTimer {

    /**
     * Constructor for the Speedpowerup timer.
     * @param game in which the timer is active
     */
	public SpeedPowerupTimer(Game game) {
		super(game);
	}

	/**
     * Let the counter start.
     */
	@Override
	public void run() {

		long start = System.currentTimeMillis();
		long end = start + 5*1000; // 5 seconds * 1000 ms/sec
		Player player = game.getPlayerList().get(0);
		while (System.currentTimeMillis() < end)
		{
		    if(player.getStepSize() != Settings.getPlayerPowerupStepSize() && !Settings.getDieThreads())
		    	player.setStepSize(Settings.getPlayerPowerupStepSize());
		    if(Settings.getDieThreads()){
		    	Settings.setDieThreads(false);
		    	end = System.currentTimeMillis();
		    }
		}
    	Settings.setDieThreads(false);
		player.setStepSize(Settings.getPlayerStepSize());
	}

}
