package game.powerups;

import game.Game;
import game.Player;
import game.Settings;

/**
 * Special timer for the ice powerup.
 * @author Boning
 *
 */
public class IcePowerupTimer extends PowerupTimer {

	private Player player;
	
    /**
     * Constructor for the Icepowerup timer.
     * @param game in which the timer is active
     */
	public IcePowerupTimer(Game game) {
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
		    if(!player.hasIceRope()){
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
