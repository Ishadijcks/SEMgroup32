package game.powerups;

import game.Game;
import game.Player;

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
		Player player = game.getCurrentLevel().getPlayerList().get(0);
		long start = System.currentTimeMillis();
		long end = start + 5*1000; // 5 seconds * 1000 ms/sec
		while (System.currentTimeMillis() < end)
		{
		    if(!player.hasIceRope()){
		        player.setHasIceRope(true);
		    }
		    if(PowerupThreadKiller.getDieThreads()){
		    	PowerupThreadKiller.setDieThreads(false);
		    	end = System.currentTimeMillis();
		    }
		}
		player.setHasIceRope(false);
	}

}
