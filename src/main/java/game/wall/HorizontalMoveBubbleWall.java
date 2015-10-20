package game.wall;

import settings.screenSettings;
import helperobjects.Coordinates;

/**
 * Wall class of a bubble wall that can move horizontal.
 * @author Boning
 */
public class HorizontalMoveBubbleWall extends BubbleWall {
    
    private int bouncedOn;
    private MoveHorizontally mover;
    private boolean goingRight;
    private int leftBoundary;
    private int rightBoundary;
    private int movementSpeed;

    /**
     * Constructor of the horizontal move bubble wall.
     */
    public HorizontalMoveBubbleWall(Coordinates coordinates, int height, int width, int leftBound, int rightBound, int speed) {
        super(coordinates, height, width);
        mover = new MoveHorizontally(coordinates);
        leftBoundary = leftBound;
        rightBoundary = rightBound;
        movementSpeed = speed;
        this.bouncedOn = 0;
    }
    
    /**
     *  Checks if a bubble collides with the wall.
     */
    @Override
    public boolean expectBubbleCollision(int BubblexCoord, int BubbleyCoord, int BubbleDiameter) {
        if ((BubblexCoord <= (this.getxCoord() + this.getHeight()) && 
                (BubblexCoord + BubbleDiameter) >= this.getxCoord()) &&
                    (BubbleyCoord <= (this.getyCoord() + this.getWidth()) &&
                        (BubbleyCoord + BubbleDiameter) >= this.getyCoord()) &&
                            this.isActive()) {
            this.bouncedOn();
            return true;
        }
        return false;
    }
    
    /**
     * Moves the wall left and right.
     */
    @Override
    public void move() {
        if(goingRight) {
            mover.moveIncrease(1);
            this.setxCoord(mover.getCoordinates().getxCoordinate());
        }
        else {
            mover.moveDecrease(1);
            this.setxCoord(mover.getCoordinates().getxCoordinate());
        }
        checkPlace();
    }
    
    /**
     * Check if the wall has to go to the right or to the left.
     */
    public void checkPlace() {
        if(this.getxCoord() >= rightBoundary) {
            goingRight = false;
        }
        if(this.getxCoord() <= leftBoundary) {
            goingRight = true;
        }
    }

}
