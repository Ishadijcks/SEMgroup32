package game.powerups;

import game.Game;
import game.Settings;

/**
 * Special timer for the ice powerup.
 * @author Boning
 *
 */
public class IcePowerupTimer extends PowerupTimer {

    /**
     * Constructor for the Icepowerup timer.
     * @param game in which the timer is active
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
		long end = start + 5*1000; // 5 seconds * 1000 ms/sec
		while (System.currentTimeMillis() < end)
		{
		    if(!Settings.getPlayerHasIceRope()){
		    	Settings.setPlayerHasIceRope(true);
		    }
		    if(Settings.getDieThreads()){
		    	Settings.setDieThreads(false);
		    	end = System.currentTimeMillis();
		    }
		}
		Settings.setPlayerHasIceRope(false);
	}

}
