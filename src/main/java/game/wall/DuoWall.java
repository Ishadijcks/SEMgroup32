package game.wall;

import game.Settings;

import java.awt.Color;

/**
 * Wall class of a duo wall.
 * @author Boning
 */
public class DuoWall extends Wall {

    /**
     * Constructor of a duo wall.
     * @param xCoord xCoord-Coordinate of the wall
     */
    public DuoWall(int xCoord) {
        super(xCoord, Color.blue);
    }

    @Override
	public boolean expectPlayerCollision(int xCoord, boolean movingLeft) {
		int plyrXCoord = xCoord;
		int plyrStepSize = Settings.getPlayerStepSize();
		int plyrWidth = Settings.getPlayerWidth();
		if(this.isActive())
			if((plyrXCoord - plyrStepSize <= this.getxCoord() + this.getWidth()
					&& plyrXCoord - plyrStepSize >= this.getxCoord() && movingLeft) 
					|| (plyrXCoord + plyrStepSize + plyrWidth - 37 >= this.getxCoord() 
					&& plyrXCoord + plyrStepSize + plyrWidth - 37 <= this.getxCoord() + this.getWidth() && !movingLeft)
					)
				return true;
		return false;
	}

	@Override
	public boolean expectBubbleCollision(int BubblexCoord, int BubbleDiameter) {
		if ((BubblexCoord <= (this.getxCoord() + this.getWidth()) && (BubblexCoord + BubbleDiameter) >= this.getxCoord())
                && this.isActive()) {
			return true;
		}
		return false;
	}

}
