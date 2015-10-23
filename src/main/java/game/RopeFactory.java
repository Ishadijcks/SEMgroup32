package game;

import game.log.Logger;

/**
 * Creates ice ropes and normal ropes.
 * @author Isha
 *
 */
public class RopeFactory {

	public Rope createRope(boolean iceRope) {
		Level currentLevel = Driver.game.getCurrentLevel();
		// minus the top margin which is 50
		int yCoord = currentLevel.getHeight()
                - 50;
        int xCoord = currentLevel.getPlayerList().get(0).getX() + currentLevel.getPlayerList().get(0).getWidth() / 2;

        Logger.log("Shot a rope", 1, 4);

        if (!iceRope) {
            return new Rope(xCoord, yCoord);
        } else {
            return new IceRope(xCoord, yCoord);
        }
    }

}
