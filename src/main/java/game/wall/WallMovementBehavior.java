package game.wall;

/**
 * @author Tim
 * This interface class controls the movement of walls.
 * Some walls will not move and have a empty implementation.
 *
 */
public interface WallMovementBehavior {
    /**
     * The movement of the wall method.
     */
    void move();
}

