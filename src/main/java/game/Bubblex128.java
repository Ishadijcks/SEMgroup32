package game;

import java.awt.Color;
import java.util.ArrayList;

public class Bubblex128 extends Bubble {
	
	private final int maxheight = 40;
	private final Color color = Color.PINK;
	private final double G = 1;
	private final int diameter = 128;
	private double speedX = 1;

	public Bubblex128(double x, double y, boolean directionH, boolean directionV) {
		super(x, y, directionH, directionV);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
        bounceBorder();
        moveX();
        moveY();
	}

	@Override
	public void outOfBoardCheck() {
		if (y < Settings.getTopMargin() || !(y > 0)) {
            y = maxheight;
        }
	}

	@Override
	public void bounceBorder() {
		if (x + diameter > Settings.getLeftMargin() + Settings.getLevelWidth()
                && directionH || x <= Settings.getLeftMargin() && !directionH) {
            bounceH();
        }

        if (y + diameter > Settings.getTopMargin() + Settings.getLevelHeight()
                && directionV || y <= Settings.getTopMargin() && !directionV) {
            bounceV();
        }
	}

	@Override
	public void moveY() {
		if (directionV) {
            sOld = 0.5 * G * t * t;
            t += timeStep;
            s = 0.5 * G * t * t;
            v = (s - sOld) / timeStep;
            lastDownSpeed = v;
            y += lastDownSpeed;
            lastDownSpeed += 0.05;
        } else {
            t = 0;
            if (newBubble) {
                newBubble = false;
                lastDownSpeed = 4;
            }
            factor = ((y - maxheight) / (Settings.getTopMargin()
                    + Settings.getLevelHeight() - maxheight));
            lastUpSpeed = lastDownSpeed * Math.pow(factor, timer);
            y -= lastUpSpeed;
        }
        if (lastUpSpeed < 0.5 && !directionV && y < Settings.getTopMargin() + Settings.getLevelHeight() - 50) {
            timer += 0.4;
        }
        if (timer > 5) {
            bounceV();
            timer = 1;
        }
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
