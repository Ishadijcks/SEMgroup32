package game;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Bubble {
    protected double x = 10;
    protected double y = 10;
    protected double timer = 1;
    protected boolean directionH;
    protected boolean directionV;
    protected double lastDownSpeed = 0;
    protected double lastUpSpeed = 1;
    protected boolean newBubble;
    
    private int maxheight;
    private Color color;
    private double G;
    private int diameter;
    private double speedX; 

    protected double s;
    protected double sOld;
    protected double t = 0;
    protected double v;
    protected double timeStep = 0.01;
    protected double factor = 2;

    /**
     * the constructor sets the starting coordinates, the moving location, the
     * diameter.
     * 
     * @param x
     * @param y
     */
    public Bubble(double x, double y, boolean directionH,
            boolean directionV, int maxheight, Color color, double G, int diameter, double speedX) {
    	
        Logger.log("Bubble created with diameter " + diameter, 3, 4);

        this.x = x;
        this.y = y;
        
        this.maxheight = maxheight;
        this.color = color;
        this.G = G;
        this.diameter = diameter;
        this.speedX = speedX;

        this.directionH = directionH;
        this.directionV = directionV;
        this.newBubble = true;
        
    }
    

    /**
     * get the correct X of the bubble
     * 
     * @param x
     * @param diameter
     * @return the x of the bubble
     */
    public boolean correctX(double x, int diameter) {
        if (x > 0
                && x < Settings.getLeftMargin() + Settings.getLevelWidth()
                        - diameter) {
            return true;
        } else {
            Logger.log("Incorrect x", 3, 3);
            return false;
        }
    }

    /**
     * get the correct Y of the bubble
     * 
     * @param y
     * @param diameter
     * @return the y of the bubble
     */
    public boolean correctY(double y, int diameter) {
        if (y > Settings.getTopMargin()
                && y < (Settings.getTopMargin() + Settings.getLevelHeight() - diameter)) {
            return true;
        }

        else {
            Logger.log("Incorrect y", 3, 3);
            return false;
        }
    }

    /**
     * The method that controls bubble movement.
     * 
     * @param width
     * @param height
     */
    public void move() {
		outOfBoardCheck();
        bounceBorder();
        moveX();
        moveY();
	}
    
    /**
     * check if the bubble isn't outside of the borders.
     */
    public void outOfBoardCheck() {
		if (y < Settings.getTopMargin() || !(y > 0)) {
            y = maxheight;
        }
	}

    /**
     * Checks if the bubble needs to bounce cause of the borders. If needed
     * bounce.
     */
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
    
    public abstract ArrayList<Bubble> destroyBubble(int x, int y);


    public abstract int getDiameter();
    
    public abstract Color getColor();
    
    /**
     * Updates the y location of the bubble.
     */
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
    
    /**
     * Updates the x location of the bubble.
     */
    public void moveX() {
        if (directionH) {
            x += speedX;
        } else {
            x -= speedX;
        }
    }

    /**
     * switches the horizontal direction.
     */
    public void bounceH() {
        if (directionH) {
            Logger.log("Bubble bounced on the right wall", 2, 4, 1);
        } else {
            Logger.log("Bubble bounced on the left wall", 2, 4, 1);
        }
        directionH = !directionH;

    }

    /**
     * switches the vertical direction.
     */
    public void bounceV() {
        if (directionV) {
            Logger.log("Bubble bounced on the floor", 2, 4, 1);
        } else {
            Logger.log("Bubble reached max height", 2, 4, 1);
        }
        directionV = !directionV;

    }

    // Getters and Setters

    public int getX() {
        return (int) Math.round(x);
    }

    public int getY() {
        return (int) Math.round(y);
    }

    /**
     * Give the direction of the bubble
     * 
     * @return the horizontal direction
     */
    public boolean isDirectionH() {
        return directionH;
    }

    /**
     * Set the direction of the bubble
     * 
     * @param directionH
     */
    public void setDirectionH(boolean directionH) {
        this.directionH = directionH;
    }

    /**
     * Get the vertical direction
     * 
     * @return the vertical direction
     */
    public boolean isDirectionV() {
        return directionV;
    }

    /**
     * Set the vertical direction of the bubble
     * 
     * @param directionV
     */
    public void setDirectionV(boolean directionV) {
        this.directionV = directionV;
    }


	/**
	 * @param speedX the speedX to set
	 */
	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}


	/**
	 * @return the speedX
	 */
	public double getSpeedX() {
		return speedX;
	}


	/**
	 * @return the g
	 */
	public double getG() {
		return G;
	}


	/**
	 * @return the maxheight
	 */
	public int getMaxheight() {
		return maxheight;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bubble other = (Bubble) obj;
		if (Double.doubleToLongBits(G) != Double.doubleToLongBits(other.G))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (diameter != other.diameter)
			return false;
		if (directionH != other.directionH)
			return false;
		if (directionV != other.directionV)
			return false;
		if (Double.doubleToLongBits(factor) != Double
				.doubleToLongBits(other.factor))
			return false;
		if (Double.doubleToLongBits(lastDownSpeed) != Double
				.doubleToLongBits(other.lastDownSpeed))
			return false;
		if (Double.doubleToLongBits(lastUpSpeed) != Double
				.doubleToLongBits(other.lastUpSpeed))
			return false;
		if (maxheight != other.maxheight)
			return false;
		if (newBubble != other.newBubble)
			return false;
		if (Double.doubleToLongBits(s) != Double.doubleToLongBits(other.s))
			return false;
		if (Double.doubleToLongBits(sOld) != Double
				.doubleToLongBits(other.sOld))
			return false;
		if (Double.doubleToLongBits(speedX) != Double
				.doubleToLongBits(other.speedX))
			return false;
		if (Double.doubleToLongBits(t) != Double.doubleToLongBits(other.t))
			return false;
		if (Double.doubleToLongBits(timeStep) != Double
				.doubleToLongBits(other.timeStep))
			return false;
		if (Double.doubleToLongBits(timer) != Double
				.doubleToLongBits(other.timer))
			return false;
		if (Double.doubleToLongBits(v) != Double.doubleToLongBits(other.v))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

}
