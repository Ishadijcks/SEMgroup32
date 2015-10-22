package game.wall;

import helperobjects.Coordinates;

import java.awt.Color;

import settings.PlayerSettings;
import settings.ScreenSettings;

/**
 * Wall class of a player wall.
 * 
 * @author Boning
 */
public class PlayerWall extends Wall {

    /**
     * 
     * Constructor of a player wall.
     * 
     * @param coordinates
     *            of the wall
     * @param width
     *            of the wall
     */
    public PlayerWall(Coordinates coordinates, int width) {
        super(new Coordinates(coordinates.getxCoordinate(), 0), Color.green,
                ScreenSettings.getLevelHeight(), width);
    }

    /**
     * Checks if a player collides with the wall.
     */
    @Override
    public boolean expectPlayerCollision(int xCoord, int yCoord,
            boolean movingLeft) {
        int plyrXCoord = xCoord;
        int plyrStepSize = PlayerSettings.getPlayerStepSize();
        int plyrWidth = PlayerSettings.getPlayerWidth();
        if (this.isActive()) {
            if ((plyrXCoord - plyrStepSize <= this.getxCoord()
                    + this.getWidth()
                    && plyrXCoord - plyrStepSize >= this.getxCoord() && movingLeft)
                    || (plyrXCoord + plyrStepSize + plyrWidth >= this
                            .getxCoord()
                            && plyrXCoord + plyrStepSize + plyrWidth <= this
                                    .getxCoord() + this.getWidth() && !movingLeft)) {
                return true;
            }
        }
        return false;
    }

    /**
     * A PlayerWall will never collide with a bubble.
     */
    @Override
    public boolean expectBubbleCollision(int xCoord, int yCoord,
            int BubbleDiameter) {
        return false;
    }

    /**
     * A PlayerWall will not move.
     */
    @Override
    public void move() {

    }

}
