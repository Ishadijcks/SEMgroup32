package game;

import game.log.Logger;
import settings.PlayerSettings;

/**
 * Creates ice ropes and normal ropes.
 * @author Isha
 *
 */
public class RopeFactory {

    /**
     * Creates a rope and returns it.
     * @param iceRope Whether it should be an ice rope or a normal rope
     * @return The rope 
     */
    public Rope createRope(boolean iceRope) {
        Level currentLevel = Driver.game.getCurrentLevel();
        int yCoord = currentLevel.getHeight()
                - PlayerSettings.getPlayerHeight();
        int xCoord = currentLevel.getPlayerList().get(0).getX()
                + PlayerSettings.getPlayerWidth() / 2;

        Logger.log("Shot a rope", 1, 4);

        if (!iceRope) {
            return new Rope(xCoord, yCoord);
        } else {
            return new IceRope(xCoord, yCoord);
        }
    }

}
