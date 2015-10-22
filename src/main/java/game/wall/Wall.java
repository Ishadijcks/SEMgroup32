package game.wall;

import helperobjects.Coordinates;
import helperobjects.Dimensions;
import java.awt.Color;
import settings.WallSettings;

/**
 * Wall class.
 * 
 * @author Boning
 *
 */
public abstract class Wall {
    private int width = WallSettings.getWallWidth();
    private int height = WallSettings.getWallHeight();
    private Coordinates curCoord;
    private Dimensions curDim;
    private int xCoord;
    private int yCoord;
    private Color color;
    private boolean isActive;

    /**
     * 
     * Constructor of a wall.
     * 
     * @param coordinates
     *            of a wall
     * @param color
     *            of a wall
     * @param height
     *            of a wall
     * @param width
     *            of a wall
     */
    public Wall(Coordinates coordinates, Color color, int height, int width) {
        curCoord = coordinates;
        curDim = new Dimensions(height, width);
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
     * @param yCoord
     *            of the player
     * @return boolean of collision
     */
    public abstract boolean expectPlayerCollision(int xCoord, int yCoord,
            boolean movingLeft);

    /**
     * Returns true if a collision between the wall and bubble is expected.
     * Otherwise false.
     * 
     * @param BubbleDiameter
     *            is size of the bubble
     * @param xCoord
     *            of the bubble
     * @param yCoord
     *            of the bubble
     * @return boolean of collision
     */
    public abstract boolean expectBubbleCollision(int xCoord, int yCoord,
            int BubbleDiameter);

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
        return curCoord.getxCoordinate();
    }

    /**
     * @return the yCoord
     */
    public int getyCoord() {
        return curCoord.getyCoordinate();
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return curDim.getWidth();
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return curDim.getHeight();
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Method that will move the wall.
     */
    public void move() {

    }

    /**
     * @param xCoord
     *            the xCoord to set
     */
    public void setxCoord(int xCoord) {
        curCoord.setxCoordinate(xCoord);
    }

    /**
     * @param yCoord
     *            the yCoord to set
     */
    public void setyCoord(int yCoord) {
        curCoord.setyCoordinate(yCoord);
    }

    /**
     * @param width
     *            the width to set
     */
    public void setWidth(int width) {
        curDim.setWidth(width);
    }

    /**
     * @param height
     *            the height to set
     */
    public void setHeight(int height) {
        curDim.setWidth(height);
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
        if (height != other.height || width != other.width) {
            return false;
        }
        if (isActive != other.isActive) {
            return false;
        }

        if (xCoord != other.xCoord || yCoord != other.yCoord) {
            return false;
        }
        return true;
    }

}
