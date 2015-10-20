package game.wall;

import helperobjects.Coordinates;

/**
 * Wall class of a bubble wall that can move horizontal.
 * @author Boning
 */
public class HorizontalMoveBubbleWall extends BubbleWall {
    
    private int bouncedOn;

    /**
     * Constructor of the horizontal move bubble wall.
     */
    public HorizontalMoveBubbleWall(Coordinates coordinates, int height, int width) {
        super(coordinates, height, width, new MoveHorizontally());
        this.bouncedOn = 0;
    }

}
