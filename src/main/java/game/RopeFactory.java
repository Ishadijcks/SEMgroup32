package game;

import game.log.Logger;

/**
 * Creates ice ropes and normal ropes.
 * 
 * @author Isha
 *
 */
public class RopeFactory {

    /**
     * Create the rope if boolean true then it's an iceRope.
     * 
     * @param iceRope boolean if true then ice.
     * @return The rope.
     */
    public Rope createRope(boolean iceRope) {
        Level currentLevel = Driver.game.getCurrentLevel();
        int yCoord = currentLevel.getHeight() - 50;
        int xCoord = currentLevel.getPlayerList().get(0).getX()
                + currentLevel.getPlayerList().get(0).getWidth() / 2;

        Logger.log("Shot a rope", 1, 4);

        if (!iceRope) {
            return new Rope(xCoord, yCoord);
        } else {
            return new IceRope(xCoord, yCoord);
        }
    }

}
