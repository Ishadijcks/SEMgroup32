package game.wall;

/**
 * No movement for the static wall.
 * 
 * @author Tim
 *
 */
public class NoMove implements WallMovementBehavior {
    
    /**
     * No implementation because there is no movement.
     */
    public void moveIncrease(int speed) {
    }
    
    /**
     * No implementation because there is no movement.
     */
    public void moveDecrease(int speed) {
    }
}
