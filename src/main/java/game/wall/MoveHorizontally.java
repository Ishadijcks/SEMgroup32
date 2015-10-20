package game.wall;

import helperobjects.Coordinates;

/**
 * Class that gives a wall a horizontal movement.
 * @author Boning
 *
 */
public class MoveHorizontally implements WallMovementBehavior {
    
    private Coordinates coordinates;
    
    /**
     * Moves the wall to the right.
     */
    public void moveIncrease(int speed) {
        coordinates.setxCoordinate(coordinates.getxCoordinate() + speed);
    }
    
    /**
     * Moves the wall to the left.
     */
    public void moveDecrease(int speed) {
        coordinates.setxCoordinate(coordinates.getxCoordinate() - speed);
    }
}
