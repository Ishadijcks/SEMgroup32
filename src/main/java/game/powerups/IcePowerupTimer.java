package game.powerups;

import game.Game;
import game.Player;
import game.Settings;

public class IcePowerupTimer extends PowerupTimer {

	public IcePowerupTimer(Game game) {
		super(game);
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		long end = start + 5*1000; // 5 seconds * 1000 ms/sec
		Player player = game.getPlayerList().get(0);
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
		game.getCurrentLevel().setRope(null);
		Settings.setPlayerHasIceRope(false);
		System.out.println("DONE");
	}

}
