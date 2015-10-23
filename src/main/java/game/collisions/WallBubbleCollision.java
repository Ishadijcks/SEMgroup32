package game.collisions;

import game.Game;
import game.bubble.Bubble;
import game.observers.Observer;
import game.wall.HorizontalMoveBubbleWall;
import game.wall.Wall;

/**
 * wall and bubble collision class.
 * 
 * @author Floris
 *
 */
public class WallBubbleCollision extends Collision {
    private boolean bounceVertical;

    /**
     * The constructor same as the super class Collision.
     */
    public WallBubbleCollision() {
        super();
    }

    /**
     * Checks the collision between a player and a bubble.
     */
    @Override
    public boolean checkCollision(Game game) {
        for (Bubble bubble : game.getCurrentLevel().getBubbleList()) {
            for (Wall wall : game.getCurrentLevel().getWallList()) {
                if (wall.expectBubbleCollision(bubble.getX(), bubble.getY(),
                        bubble.getDiameter())) {
                    if (wall instanceof HorizontalMoveBubbleWall) {
                        bounceVertical = false;
                    } else {
                        bounceVertical = true;
                    }
                    notifyListeningObservers(bubble);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Notify the collision.
     */
    @Override
    public void notifyListeningObservers() {
        // TODO Auto-generated method stub

    }

    /**
     * Notify the collision.
     */
    @Override
    public void notifyListeningObservers(Object object) {
        Bubble bubble = (Bubble) object;
        for (Observer o : observers) {
            o.wallBubbleEvent(bubble, bounceVertical);
        }
    }

}
