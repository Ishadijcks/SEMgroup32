package game.wall;

import java.awt.Color;

/**
 * Wall class of a bubble wall.
 * @author Boning
 */
public class BubbleWall extends Wall {
	
	/**
     * Constructor of a bubble wall.
     * @param xCoord x-Coordinate of the wall
     */
    public BubbleWall(int xCoord) {
        super(xCoord, Color.red);
    }

	@Override
	public boolean expectPlayerCollision(int xCoord, boolean movingLeft) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean expectBubbleCollision(int BubblexCoord, int BubbleDiameter) {
		if ((BubblexCoord <= (this.getxCoord() + this.getWidth()) && (BubblexCoord + BubbleDiameter) >= this.getxCoord())
                && this.isActive()) {
            this.bouncedOn();
			return true;
		}
		return false;
	}
	


    /**
     * Checks if a ball bounced on the wall.
     */
    public void bouncedOn() {
        setActive(false);
    }
    
}
