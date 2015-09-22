package game.bubble;

import java.awt.Color;
import java.util.ArrayList;

public class Bubblex128 extends Bubble {
	
	private final static int maxheight = 40;
	private final static Color color = Color.PINK;
	private final static double G = 1;
	private final static int diameter = 128;
	private static double speedX = 1;

	public Bubblex128(double x, double y, boolean directionH, boolean directionV) {
		super(x, y, directionH, directionV, maxheight, color, G, diameter, speedX);
	}
	
	@Override
	public ArrayList<Bubble> destroyBubble(int x, int y) {
		ArrayList<Bubble> retList = new ArrayList<Bubble>();
		retList.add(new Bubblex64(x, y, false, false));
		retList.add(new Bubblex64(x, y, true, false));
		return retList;
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
		this.speedX = speedX;
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
	 * @return the g
	 */
	public double getG() {
		return G;
	}

	/**
	 * @return the diameter
	 */
	public int getDiameter() {
		return diameter;
	}

}
