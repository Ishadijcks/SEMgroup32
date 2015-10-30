package game.wall;

import game.helperobjects.Coordinates;

import java.awt.Color;

/**
 * Wall class of a bubble wall.
 * 
 * @author Boning
 */
public abstract class BubbleWall extends Wall {

    /**
     * Constructor of a bubble wall.
     * 
     * @param coordinates
     *           coordinates of the wall
     * @param height the bubblewall length
     * @param width the bubblewall width
     */
    public BubbleWall(Coordinates coordinates, int height, int width) {
        super(coordinates, Color.red, height, width);
    }

    /**
     * A BubbleWall will never collide with a player.
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
        return false;
    }

    /**
     * Checks if a bubble collides with the wall.
     *  @param BubbleDiameter
     *            is size of the bubble
     * @param BubblexCoord
     *            of the bubble
     * @param BubbleyCoord
     *            of the bubble
     * @return boolean, true if there is a collision, false otherwise
     */
    @Override
    public boolean expectBubbleCollision(int BubblexCoord, int BubbleyCoord,
            int BubbleDiameter) {
        if ((BubblexCoord <= (this.getxCoord() + this.getWidth()) && (BubblexCoord + BubbleDiameter) >= this
                .getxCoord())
                && (BubbleyCoord <= (this.getyCoord() + this.getHeight() + 50) && (BubbleyCoord + BubbleDiameter) >= this
                        .getyCoord() + 50) && this.isActive()) {
            this.bouncedOn();
            return true;
        }
        return false;
    }

    /**
     * Checks if a ball bounced on the wall.
     */
    public void bouncedOn() {
        setActive(false);
    }

    /**
     * Method that will move the wall.
     */
    @Override
    public void move() {
        setActive(false);
    }

}
