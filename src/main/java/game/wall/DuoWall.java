package game.wall;

import helperobjects.Coordinates;

import java.awt.Color;

import settings.playerSettings;

/**
 * Wall class of a duo wall.
 * 
 * @author Boning
 */
public class DuoWall extends Wall {

    /**
     * Constructor of a duo wall.
     * 
     * @param xCoord
     *            xCoord-Coordinate of the wall
     */
    public DuoWall(Coordinates coordinates, int height, int width) {
        super(coordinates, Color.blue, height, width, new NoMove());
    }

    @Override
    public boolean expectPlayerCollision(int xCoord, boolean movingLeft) {
        int plyrXCoord = xCoord;
        int plyrStepSize = playerSettings.getPlayerStepSize();
        int plyrWidth = playerSettings.getPlayerWidth();
        if (this.isActive())
            if ((plyrXCoord - plyrStepSize <= this.getxCoord()
                    + this.getWidth()
                    && plyrXCoord - plyrStepSize >= this.getxCoord() && movingLeft)
                    || (plyrXCoord + plyrStepSize + plyrWidth - 37 >= this
                            .getxCoord()
                            && plyrXCoord + plyrStepSize + plyrWidth - 37 <= this
                                    .getxCoord() + this.getWidth() && !movingLeft))
                return true;
        return false;
    }

    @Override
    public boolean expectBubbleCollision(int BubblexCoord, int BubbleDiameter) {
        if ((BubblexCoord <= (this.getxCoord() + this.getWidth()) && (BubblexCoord + BubbleDiameter) >= this
                .getxCoord()) && this.isActive()) {
            return true;
        }
        return false;
    }

}
