package game.wall;

import settings.screenSettings;
import helperobjects.Coordinates;

/**
 * Wall class of a bubble wall that can move horizontal.
 * @author Boning
 */
public class HorizontalMoveBubbleWall extends BubbleWall {
    
    private int bouncedOn;
    private static MoveHorizontally mover = new MoveHorizontally();

    /**
     * Constructor of the horizontal move bubble wall.
     */
    public HorizontalMoveBubbleWall(Coordinates coordinates, int height, int width) {
        super(coordinates, height, width, mover);
        this.bouncedOn = 0;
    }
    
    /**
     * Moves the wall left and right.
     */
    @Override
    public void move() {
        if(this.getxCoord() < screenSettings.getLevelWidth()) {
            mover.moveIncrease(1);
            this.setxCoord(mover.getCoordinates().getxCoordinate());
        }
        else {
            mover.moveDecrease(1);
            this.setxCoord(mover.getCoordinates().getxCoordinate());
        }
    }

}
