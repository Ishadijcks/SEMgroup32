package game;

import settings.playerSettings;
import game.log.Logger;

public class RopeFactory {

	public Rope createRope(boolean iceRope) {
		Level currentLevel = Driver.game.getCurrentLevel();
		int yCoord = currentLevel.getHeight()
                - playerSettings.getPlayerHeight();
        int xCoord = currentLevel.getPlayerList().get(0).getX() + playerSettings.getPlayerWidth() / 2;

        Logger.log("Shot a rope", 1, 4);
        
		if(!iceRope)
			return new Rope(xCoord, yCoord);
		else 
			return new IceRope(xCoord, yCoord);
	}

}
