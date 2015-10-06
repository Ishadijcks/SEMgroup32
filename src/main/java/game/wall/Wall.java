package game.wall;

import game.Settings;

import java.awt.Color;

/**
 * Wall class.
 * @author Boning
 *
 */
public class Wall {

    private int xCoord;
    private int yCoord;
    private int width = Settings.getWallWidth();
    private int height = Settings.getWallHeight();
    private Color color;
    private boolean isActive;
    private int bouncedOn;

    /**
     * Constructor of a wall.
     * @param xCoord x-Coordinate of the wall
     * @param color of the wall
     */
    public Wall(int xCoord, Color color) {
        this.xCoord = xCoord;
        this.yCoord = 0;
        this.color = color;
        this.isActive = true;
        this.bouncedOn = 0;
    }

    /**
     * Checks if a wall is active or not.
     * @return true if it is active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Set the wall to active or not active.
     * @param bool true for active, false for not active
     */
    public void setActive(boolean bool) {
        isActive = bool;
    }

    /**
     * Checks if a ball bounced on the wall.
     */
    public void bouncedOn() {
        bouncedOn++;
        setActive(false);
    }
 
	/**
     * @return the xCoord
     */
    public int getxCoord() {
        return xCoord;
    }

    /**
     * @return the yCoord
     */
    public int getyCoord() {
        return yCoord;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the bouncedOn
     */
    public int getBouncedOn() {
        return bouncedOn;
    }

    /**
     * @param xCoord the xCoord to set
     */
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     * @param yCoord the yCoord to set
     */
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * @param bouncedOn the bouncedOn to set
     */
    public void setBouncedOn(int bouncedOn) {
        this.bouncedOn = bouncedOn;
    }

    /**
     * Generated equals method to check if all attributes 
     * equals another of the same class.
     * @param obj Object that it will compare to
     * @return true if the object is from the same type and has the same attributes
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Wall other = (Wall) obj;
		if (bouncedOn != other.bouncedOn) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (height != other.height) {
			return false;
		}
		if (isActive != other.isActive) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		if (xCoord != other.xCoord) {
			return false;
		}
		if (yCoord != other.yCoord) {
			return false;
		}
		return true;
	}

}
