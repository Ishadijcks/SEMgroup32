package game.wall;

import helperobjects.Coordinates;

/**
 * Wall class of a bubble wall that can move vertical.
 * @author Boning
 */
public class VerticalMoveBubbleWall extends BubbleWall {
	
	private int bouncedOn;

    /**
     * Constructor of the vertical move bubble wall.
     */
    public VerticalMoveBubbleWall(Coordinates coordinates, int height, int width) {
        super(coordinates, height, width, new MoveVertically());
        this.bouncedOn = 0;
    }

}
