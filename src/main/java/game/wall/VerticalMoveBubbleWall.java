package game.wall;

import helperobjects.Coordinates;

/**
 * Wall class of a bubble wall that can move vertical.
 * 
 * @author Boning
 */
public class VerticalMoveBubbleWall extends BubbleWall {

    private MoveVertically mover;

    /**
     * 
     * Constructor of the vertical move bubble wall.
     * @param coordinates of the wall
     * @param height of the wall
     * @param width of the wall
     * @param lowerBound lower boundary
     * @param upperBound upper boundary
     * @param speed of the wall
     */
    public VerticalMoveBubbleWall(Coordinates coordinates, int height,
            int width, int lowerBound, int upperBound, int speed) {
        super(coordinates, height, width);
        mover = new MoveVertically(coordinates, lowerBound, upperBound, speed);
    }

    /**
     * Moves the wall upper and down.
     */
    @Override
    public void move() {
        mover.move();
        mover.getCoordinates();
    }

}
