package game.wall;

import helperobjects.Coordinates;

/**
 * Class that gives a wall a vertical movement.
 * @author Boning
 *
 */
public class MoveVertically implements WallMovementBehavior {
    
    private Coordinates coordinates;
    
    /**
     * Moves the wall down.
     */
    public void moveIncrease(int speed) {
        coordinates.setyCoordinate(coordinates.getyCoordinate() + speed);
    }
    
    /**
     * Moves the wall up.
     */
    public void moveDecrease(int speed) {
        coordinates.setyCoordinate(coordinates.getyCoordinate() - speed);
    }

    /**
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @param coordinates the coordinates to set
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    
    
}
