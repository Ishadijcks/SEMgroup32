package game.bubble;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Bubble class of a bubble with diameter 64.
 * 
 * @author Boning
 *
 */
public class Bubblex64 extends Bubble {

    private static final int MAXHEIGHT = 80;
    private static final Color COLOR = Color.CYAN;
    private static final double GRAVITATION = 1.1;
    private static final int DIAMETER = 64;
    private static double speedX = 1.3;

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
    public Bubblex64(double xCoord, double yCoord, boolean directionHorizontal,
            boolean directionVertical) {
        super(xCoord, yCoord, directionHorizontal, directionVertical,
                MAXHEIGHT, COLOR, GRAVITATION, DIAMETER, speedX);
        this.scoreWorth = 25;
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
        retList.add(new Bubblex32(xCoord, yCoord, false, false));
        retList.add(new Bubblex32(xCoord, yCoord, true, false));
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

    /**
     * @param speedX
     *            the speedX to set
     */
    public void setSpeedX(double speedX) {
        Bubblex64.speedX = speedX;
    }

}
