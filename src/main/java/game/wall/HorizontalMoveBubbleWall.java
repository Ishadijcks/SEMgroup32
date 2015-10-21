package game.wall;

import settings.screenSettings;
import helperobjects.Coordinates;

/**
 * Wall class of a bubble wall that can move horizontal.
 * 
 * @author Boning
 */
public class HorizontalMoveBubbleWall extends BubbleWall {

    private int bouncedOn;
    private MoveHorizontally mover;

    /**
     * Constructor of the horizontal move bubble wall.
     */
    public HorizontalMoveBubbleWall(Coordinates coordinates, int height,
            int width, int leftBound, int rightBound, int speed) {
        super(coordinates, height, width);
        mover = new MoveHorizontally(coordinates, leftBound, rightBound, speed);
        this.bouncedOn = 0;
    }

    /**
     * Moves the wall left and right.
     */
    @Override
    public void move() {
        mover.move();
    }

}
