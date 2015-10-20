package game.wall;

/**
 * @author Tim
 * This interface class controlls the movement of walls.
 * Some walls will not move and have a empty implementation.
 *
 */
public interface WallMovementBehavior {
    /**
     * The movement of the wall method, where the coordinate will be increased.
     */
    void moveIncrease(int speed);
    
    /**
     * The movement of the wall method, where the coordinate will be decreased.
     */
    void moveDecrease(int speed);
}

