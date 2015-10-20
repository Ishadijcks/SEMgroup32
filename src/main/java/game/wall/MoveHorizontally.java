package game.wall;

import helperobjects.Coordinates;

/**
 * Class that gives a wall a horizontal movement.
 * @author Boning
 *
 */
public class MoveHorizontally implements WallMovementBehavior {
    
    private Coordinates coordinates;
    private int bouncedOn;
    private int leftBound;
    private int rightbound;
    private int movementSpeed;
    private int goingLeft = 1;

    /**
     * Constructor for the vertical mover.
     * 
     * @param coord
     *            Current coordinates of the wall
     */
    public MoveHorizontally(Coordinates coord, int left, int right, int speed) {
        coordinates = coord;
        movementSpeed = speed;
        leftBound = left;
        rightbound = right;
    }

    public void move() {
        if (coordinates.getxCoordinate() <= leftBound) {
            goingLeft = 1;
        }
        if (coordinates.getxCoordinate() >= rightbound) {
            goingLeft = -1;
        }
        coordinates.setxCoordinate(coordinates.getxCoordinate() + movementSpeed * goingLeft);
    }

    /**
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }
    
}
