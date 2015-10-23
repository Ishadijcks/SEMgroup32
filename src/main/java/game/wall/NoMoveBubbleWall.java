package game.wall;

import helperobjects.Coordinates;

/**
 * Wall class of a no movement bubble wall.
 * 
 * @author Boning
 */
public class NoMoveBubbleWall extends BubbleWall {

    private NoMove mover;

    /**
     * Constructor of a no movement bubble wall.
     * 
     * @param coordinates
     *            of the wall
     * @param height
     *            of the wall
     * @param width
     *            of the wall
     */
    public NoMoveBubbleWall(Coordinates coordinates, int height, int width) {
        super(coordinates, height, width);
        mover = new NoMove();
    }

    /**
     * A NoMoveBubbleWall does not move.
     */
    @Override
    public void move() {
        mover.move();
    }

}
