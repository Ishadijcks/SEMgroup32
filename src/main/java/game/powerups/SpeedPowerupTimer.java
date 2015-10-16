package game.powerups;

import game.Game;
import game.Player;
import settings.playerSettings;
import settings.threadSettings;

/**
 * Special timer for the speed powerup.
 * @author Boning
 *
 */
public class SpeedPowerupTimer extends PowerupTimer {
	
	private Player player;

    /**
     * Constructor for the Speedpowerup timer.
     * @param game in which the timer is active
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
		long end = start + 5*1000; // 5 seconds * 1000 ms/sec
		while (System.currentTimeMillis() < end)
		{
		    if(player.getStepSize() != playerSettings.getPlayerPowerupStepSize() && !threadSettings.getDieThreads())
		    	player.setStepSize(playerSettings.getPlayerPowerupStepSize());
		    if(threadSettings.getDieThreads()){
		    	threadSettings.setDieThreads(false);
		    	end = System.currentTimeMillis();
		    }
		}
    	threadSettings.setDieThreads(false);
		player.setStepSize(playerSettings.getPlayerStepSize());
	}

}
