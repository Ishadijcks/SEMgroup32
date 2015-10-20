package game.wall;

import helperobjects.Coordinates;

import java.awt.Color;

import settings.playerSettings;

/**
 * Wall class of a player wall.
 * @author Boning
 */
public class PlayerWall extends Wall {

    /**
     * Constructor of a player wall.
     * @param xCoord xCoord-Coordinate of the wall
     */
    public PlayerWall(Coordinates coordinates, int height, int width) {
        super(coordinates, Color.green, height, width, new NoMove());
    }

	@Override
	public boolean expectPlayerCollision(int xCoord, boolean movingLeft) {
		int plyrXCoord = xCoord;
		int plyrStepSize = playerSettings.getPlayerStepSize();
		int plyrWidth = playerSettings.getPlayerWidth();
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
