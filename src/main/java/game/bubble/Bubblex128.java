package game.bubble;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Bubble class of a bubble with diameter 128.
 * @author Boning
 *
 */
public class Bubblex128 extends Bubble {
	
	private final static int maxheight = 40;
	private final static Color color = Color.PINK;
	private final static double gravitation = 1;
	private final static int diameter = 128;
	private static double speedX = 1;

	/**
     * Constructor which will make a new bubble with the given parameters.
     * @param xCoord x-Coordinate
     * @param yCoord y-Coordinate
     * @param directionHorizontal horizontal direction
     * @param directionVertical vertical direction
     */
	public Bubblex128(double xCoord, double yCoord, boolean directionHorizontal, boolean directionVertical) {
		super(xCoord, yCoord, directionHorizontal, directionVertical, maxheight, color, gravitation, diameter, speedX);
		this.scoreWorth = 30;
	}
	
	/**
     * Destroy a bubble.
     * @param xCoord of the bubble
     * @param yCoord of the bubble
     * @return new list of bubbles with the given bubble removed
     */
	@Override
	public ArrayList<Bubble> destroyBubble(int xCoord, int yCoord) {
		ArrayList<Bubble> retList = new ArrayList<Bubble>();
		retList.add(new Bubblex64(xCoord, yCoord, false, false));
		retList.add(new Bubblex64(xCoord, yCoord, true, false));
		return retList;
	}

    /**
     * @return the maxheight
     */
    public int getMaxheight() {
        return maxheight;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the gravitation
     */
    public double getGravitation() {
        return gravitation;
    }

    /**
     * @return the diameter
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * @return the speedX
     */
    public double getSpeedX() {
        return speedX;
    }

    /**
     * @param speedX the speedX to set
     */
    public void setSpeedX(double speedX) {
        Bubblex128.speedX = speedX;
    }

	
}
