package game.wall;

import game.Settings;

import java.awt.Color;

/**
 * Wall class.
 * 
 * @author Boning
 *
 */
public abstract class Wall {

    private int xCoord;
    private int yCoord;
    private int width = Settings.getWallWidth();
    private int height = Settings.getWallHeight();
    private Color color;
    private boolean isActive;

    /**
     * Constructor of a wall.
     * 
     * @param xCoord
     *            x-Coordinate of the wall
     * @param color
     *            of the wall
     */
    public Wall(int xCoord, Color color) {
        this.xCoord = xCoord;
        this.yCoord = 0;
        this.color = color;
        this.isActive = true;
    }

    /**
     * Returns true if a collision between the wall and player is expected.
     * Otherwise false.
     * 
     * @param movingLeft
     *            is the direction of the player
     * @param xCoord
     *            of the player
     * @return boolean of collision
     */
    public abstract boolean expectPlayerCollision(int xCoord, boolean movingLeft);

    /**
     * Returns true if a collision between the wall and bubble is expected.
     * Otherwise false.
     * 
     * @param BubbleDiameter
     *            is size of the bubble
     * @param xCoord
     *            of the bubble
     * @return boolean of collision
     */
    public abstract boolean expectBubbleCollision(int xCoord, int BubbleDiameter);

    /**
     * Checks if a wall is active or not.
     * 
     * @return true if it is active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Set the wall to active or not active.
     * 
     * @param bool
     *            true for active, false for not active
     */
    public void setActive(boolean bool) {
        isActive = bool;
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
     * @param xCoord
     *            the xCoord to set
     */
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     * @param yCoord
     *            the yCoord to set
     */
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    /**
     * @param width
     *            the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height
     *            the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param color
     *            the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Generated equals method to check if all attributes equals another of the
     * same class.
     * 
     * @param obj
     *            Object that it will compare to
     * @return true if the object is from the same type and has the same
     *         attributes
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
