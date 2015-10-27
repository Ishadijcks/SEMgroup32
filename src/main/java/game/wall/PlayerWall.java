package game.wall;

import helperobjects.Coordinates;

import java.awt.Color;


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
                500, width);
    }

    /**
     * Returns true if a collision between the wall and player is expected.
     * 
     * @param movingLeft
     *            is the direction of the player
     * @param xCoord
     *            of the player
     * @param yCoord
     *            of the player
     * @return boolean, true if there is a collision, false otherwise
     */
    @Override
    public boolean expectPlayerCollision(int xCoord, int yCoord,
            boolean movingLeft) {
		int plyrXCoord = xCoord;
		int plyrStepSize = 4;
		int plyrWidth = 80;
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
     *  @param BubbleDiameter
     *            is size of the bubble
     * @param BubblexCoord
     *            of the bubble
     * @param BubbleyCoord
     *            of the bubble
     * @return boolean, true if there is a collision, false otherwise
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
