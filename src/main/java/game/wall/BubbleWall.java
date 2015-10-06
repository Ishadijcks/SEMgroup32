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
    
}
