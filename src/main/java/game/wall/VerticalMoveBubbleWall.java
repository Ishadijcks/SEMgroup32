package game.wall;

import settings.screenSettings;
import helperobjects.Coordinates;

/**
 * Wall class of a bubble wall that can move vertical.
 * @author Boning
 */
public class VerticalMoveBubbleWall extends BubbleWall {
	
	private int bouncedOn;
	private static MoveVertically mover = new MoveVertically();

    /**
     * Constructor of the vertical move bubble wall.
     */
    public VerticalMoveBubbleWall(Coordinates coordinates, int height, int width) {
        super(coordinates, height, width, mover);
        this.bouncedOn = 0;
    }
    
    /**
     * Moves the wall up and down.
     */
    @Override
    public void move() {
        if(this.getyCoord() < screenSettings.getLevelHeight()) {
            mover.moveIncrease(1);
            this.setyCoord(mover.getCoordinates().getyCoordinate());
        }
        else {
            mover.moveDecrease(1);
            this.setyCoord(mover.getCoordinates().getyCoordinate());
        }
    }

}
