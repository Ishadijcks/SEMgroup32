package game.wall;

import helperobjects.Coordinates;

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
    public void move(Coordinates coordinates) {
    }
}
