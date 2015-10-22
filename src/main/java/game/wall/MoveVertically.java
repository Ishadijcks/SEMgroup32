package game.wall;

import helperobjects.Coordinates;

/**
 * Class that gives a wall a vertical movement.
 * 
 * @author Boning
 *
 */
public class MoveVertically implements WallMovementBehavior {

    private Coordinates coordinates;
    private int bouncedOn;
    private int lowerBoundary;
    private int upperBoundary;
    private int movementSpeed;
    private int goingUp = 1;

    /**
     * 
     * Constructor for the vertical mover.
     * 
     * @param coord
     *            coordinates x and y
     * @param lower
     *            the lower boundary
     * @param upper
     *            the upper boundary
     * @param speed
     *            of the move
     */
    public MoveVertically(Coordinates coord, int lower, int upper, int speed) {
        coordinates = coord;
        movementSpeed = speed;
        lowerBoundary = lower;
        upperBoundary = upper;
    }

    /**
     * The method that is called to make the move. by changing the coordinates.
     */
    public void move() {
        if (coordinates.getyCoordinate() >= upperBoundary) {
            goingUp = -1;
        }
        if (coordinates.getyCoordinate() <= lowerBoundary) {
            goingUp = 1;
        }
        coordinates.setyCoordinate(coordinates.getyCoordinate() + movementSpeed
                * goingUp);
    }

    /**
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

}
