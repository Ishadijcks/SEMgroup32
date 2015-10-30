package game.wall;

import game.helperobjects.Coordinates;

/**
 * Wall class of a bubble wall that can move horizontal.
 * 
 * @author Boning
 */
public class HorizontalMoveBubbleWall extends BubbleWall {

    @SuppressWarnings("unused")
    private int bouncedOn;
    private MoveHorizontally mover;

    /**
     * Constructor of the horizontal move bubble wall.
     * @param coordinates of the wall x and y
     * @param height of the wall
     * @param width of the wall
     * @param leftBound left boundary
     * @param rightBound right boundary
     * @param speed of the wall
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
