package game.wall;

import game.Settings;

import java.awt.Color;

/**
 * Wall class of a player wall.
 * @author Boning
 */
public class PlayerWall extends Wall {

    /**
     * Constructor of a player wall.
     * @param xCoord xCoord-Coordinate of the wall
     */
    public PlayerWall(int xCoord) {
        super(xCoord, Color.green);
    }

	@Override
	public boolean expectPlayerCollision(int xCoord, boolean movingLeft) {
		int plyrXCoord = xCoord;
		int plyrStepSize = Settings.getPlayerStepSize();
		int plyrWidth = Settings.getPlayerWidth();
		if(this.isActive())
			if((plyrXCoord - plyrStepSize <= this.getxCoord() + this.getWidth()
					&& plyrXCoord - plyrStepSize >= this.getxCoord() && movingLeft) 
					|| (plyrXCoord + plyrStepSize + plyrWidth >= this.getxCoord() 
					&& plyrXCoord + plyrStepSize + plyrWidth <= this.getxCoord() + this.getWidth() && !movingLeft)
					)
				return true;
		return false;
	}

	@Override
	public boolean expectBubbleCollision(int xCoord, int BubbleDiameter) {
		// TODO Auto-generated method stub
		return false;
	}
    
}
