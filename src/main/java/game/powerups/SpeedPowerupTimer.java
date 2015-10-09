package game.powerups;

import game.Game;
import game.Player;
import game.Settings;

public class SpeedPowerupTimer extends PowerupTimer {

	public SpeedPowerupTimer(Game game) {
		super(game);
	}

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
