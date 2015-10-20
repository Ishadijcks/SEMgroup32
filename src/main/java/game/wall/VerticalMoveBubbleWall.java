package game.wall;

import settings.screenSettings;
import helperobjects.Coordinates;

/**
 * Wall class of a bubble wall that can move vertical.
 * 
 * @author Boning
 */
public class VerticalMoveBubbleWall extends BubbleWall {

    private int bouncedOn;
    private MoveVertically mover;
    private boolean goingDown;

    /**
     * Constructor of the vertical move bubble wall.
     */
    public VerticalMoveBubbleWall(Coordinates coordinates, int height,
            int width, int lowerBound, int upperBound, int speed) {
        super(coordinates, height, width);
        mover = new MoveVertically(coordinates, lowerBound, upperBound, speed);
        this.bouncedOn = 0;
    }

    /**
     * Moves the wall upper and down.
     */
    @Override
    public void move() {
        mover.move();
        mover.getCoordinates();
    }

}
