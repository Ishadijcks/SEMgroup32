package game;

import game.log.Logger;

public class RopeFactory {

	public Rope createRope(boolean iceRope) {
		Level currentLevel = Driver.game.getCurrentLevel();
		int yCoord = currentLevel.getHeight()
                - Settings.getPlayerHeight();
        int xCoord = currentLevel.getPlayerList().get(0).getX() + Settings.getPlayerWidth() / 2;

        Logger.log("Shot a rope", 1, 4);
        System.out.println(iceRope);
        
		if(!iceRope)
			return new Rope(xCoord, yCoord);
		else 
			return new IceRope(xCoord, yCoord);
	}

}
