package game.wall;

import helperobjects.Coordinates;

import java.awt.Color;

/**
 * Wall class of a bubble wall.
 * @author Boning
 */
public abstract class BubbleWall extends Wall {
	
	private int bouncedOn;

    /**
     * Constructor of a bubble wall.
     * @param xCoord x-Coordinate of the wall
     */
    public BubbleWall(Coordinates coordinates, int height, int width, WallMovementBehavior wallMovement) {
        super(coordinates, Color.red, height, width, wallMovement);
        this.bouncedOn = 0;
    }

	@Override
	public boolean expectPlayerCollision(int xCoord, int yCoord, boolean movingLeft) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean expectBubbleCollision(int BubblexCoord, int BubbleyCoord, int BubbleDiameter) {
		if ((BubblexCoord <= (this.getxCoord() + this.getWidth()) && 
		        (BubblexCoord + BubbleDiameter) >= this.getxCoord()) &&
		            (BubbleyCoord <= (this.getyCoord() + this.getHeight()) &&
		                (BubbleyCoord + BubbleDiameter) >= this.getyCoord()) &&
		                    this.isActive()) {
            this.bouncedOn();
			return true;
		}
		return false;
	}
	


    /**
     * Checks if a ball bounced on the wall.
     */
    public void bouncedOn() {
        bouncedOn++;
        setActive(false);
    }
    
}
