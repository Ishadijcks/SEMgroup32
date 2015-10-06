package game.wall;

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
    
}
