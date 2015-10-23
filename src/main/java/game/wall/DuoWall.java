package game.wall;

import helperobjects.Coordinates;

import java.awt.Color;

/**
 * Wall class of a duo wall.
 * 
 * @author Boning
 */
public class DuoWall extends Wall {

    /**
     * Constructor of a duo wall.
     * 
     * @param xCoord
     *            xCoord-Coordinate of the wall
     */
    public DuoWall(Coordinates coordinates, int height, int width) {
        super(coordinates, Color.blue, height, width);
    }

    /**
     * Checks if a player collides with the wall. 
     * A duowall will not move.
     */
    @Override
    public boolean expectPlayerCollision(int xCoord, int yCoord,
            boolean movingLeft) {
		int plyrXCoord = xCoord;
		int plyrStepSize = 4;
		int plyrWidth = 111;
        if (this.isActive())
            if ((plyrXCoord - plyrStepSize <= this.getxCoord()
                    + this.getWidth()
                    && plyrXCoord - plyrStepSize >= this.getxCoord() && movingLeft)
                    || (plyrXCoord + plyrStepSize + plyrWidth - 37 >= this
                            .getxCoord()
                            && plyrXCoord + plyrStepSize + plyrWidth - 37 <= this
                                    .getxCoord() + this.getWidth() && !movingLeft))
                return true;
        return false;
    }

    /**
     * Checks if a bubble collides with the wall.
     */
    @Override
    public boolean expectBubbleCollision(int BubblexCoord, int BubbleyCoord,
            int BubbleDiameter) {
        if ((BubblexCoord <= (this.getxCoord() + this.getWidth()) && (BubblexCoord + BubbleDiameter) >= this
                .getxCoord())
                && (BubbleyCoord <= (this.getyCoord() + this.getHeight()) && (BubbleyCoord + BubbleDiameter) >= this
                        .getyCoord()) && this.isActive()) {
            return true;
        }
        return false;
    }

}
