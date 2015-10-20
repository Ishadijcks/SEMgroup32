package game.wall;

import settings.screenSettings;
import helperobjects.Coordinates;

/**
 * Wall class of a bubble wall that can move vertical.
 * @author Boning
 */
public class VerticalMoveBubbleWall extends BubbleWall {
	
	private int bouncedOn;
	private MoveVertically mover;
	private boolean goingDown;
	private int lowerBoundary;
	private int upperBoundary;
	private int movementSpeed;

    /**
     * Constructor of the vertical move bubble wall.
     */
    public VerticalMoveBubbleWall(Coordinates coordinates, int height, int width, int lowerBound, int upperBound, int speed) {
        super(coordinates, height, width);
        mover = new MoveVertically(coordinates);
        lowerBoundary = lowerBound;
        upperBoundary = upperBound;
        movementSpeed = speed;
        this.bouncedOn = 0;
    }
    
    /**
     * Moves the wall upper and down.
     */
    @Override
    public void move() {
        if(goingDown) {
            mover.moveIncrease(movementSpeed);
            this.setyCoord(mover.getCoordinates().getyCoordinate());
        }
        else {
            mover.moveDecrease(movementSpeed);
            this.setyCoord(mover.getCoordinates().getyCoordinate());
        }
        checkHeight();
    }
    
    /**
     * Check if the wall has to go up or down.
     */
    public void checkHeight() {
        System.out.println("yCoord: " +this.getyCoord() );
        System.out.println("upperBound: " + upperBoundary );
        if(this.getyCoord() >= upperBoundary) {
            goingDown = false;
        }
        if(this.getyCoord() <= lowerBoundary) {
            goingDown = true;
        }
    }

}
