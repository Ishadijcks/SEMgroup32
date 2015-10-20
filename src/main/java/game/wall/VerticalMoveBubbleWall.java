package game.wall;

import helperobjects.Coordinates;

import java.awt.Color;

/**
 * Wall class of a bubble wall.
 * @author Boning
 */
public class VerticalMoveBubbleWall extends BubbleWall {
	
	private int bouncedOn;

    /**
     * Constructor of a bubble wall.
     * @param xCoord x-Coordinate of the wall
     */
    public VerticalMoveBubbleWall(Coordinates coordinates, int height, int width) {
        super(coordinates, height, width, new MoveVertically());
        this.bouncedOn = 0;
    }

}
