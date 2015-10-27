package game.bubble;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Bubble class of a bubble with diameter 16.
 * 
 * @author Boning
 *
 */
public class Bubblex16 extends Bubble {

    private static final int MAXHEIGHT = 150;
    private static final Color COLOR = Color.BLACK;
    private static final double GRAVITATION = 1.3;
    private static final int DIAMETER = 16;
    private static final double SPEEDX = 1;

    /**
     * Constructor which will make a new bubble with the given parameters.
     * 
     * @param xCoord
     *            x-Coordinate
     * @param yCoord
     *            y-Coordinate
     * @param directionHorizontal
     *            horizontal direction
     * @param directionVertical
     *            vertical direction
     */
    public Bubblex16(double xCoord, double yCoord, boolean directionHorizontal,
            boolean directionVertical) {
    	super(xCoord, yCoord, directionHorizontal, directionVertical);
        
        super.maxheight = MAXHEIGHT;
        super.color = COLOR;
        super.gravitation = GRAVITATION;
        super.diameter = DIAMETER;
        super.speedX = SPEEDX;
        
        this.scoreWorth = 15;
    }

    /**
     * Destroy a bubble.
     * 
     * @param xCoord
     *            of the bubble
     * @param yCoord
     *            of the bubble
     * @return new list of bubbles with the given bubble removed
     */
    @Override
    public ArrayList<Bubble> destroyBubble(int xCoord, int yCoord) {
        ArrayList<Bubble> retList = new ArrayList<Bubble>();
        retList.add(new Bubblex8(xCoord, yCoord, false, false));
        retList.add(new Bubblex8(xCoord, yCoord, true, false));
        return retList;
    }

    /**
     * @return the maxheight
     */
    public int getMaxheight() {
        return MAXHEIGHT;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return COLOR;
    }

    /**
     * @return the gravitation
     */
    public double getGravitation() {
        return GRAVITATION;
    }

    /**
     * @return the diameter
     */
    public int getDiameter() {
        return DIAMETER;
    }

    /**
     * @return the speedX
     */
    public double getSpeedX() {
        return speedX;
    }

}
