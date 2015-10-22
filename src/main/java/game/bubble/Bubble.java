package game.bubble;

import game.log.Logger;

import java.awt.Color;
import java.util.ArrayList;

import settings.ScreenSettings;

/**
 * Abstract class of a bubble.
 * 
 * @author Boning
 *
 */
public abstract class Bubble {
    protected double xCoord = 10;
    protected double yCoord = 10;
    protected double timer = 1;
    protected boolean directionHorizontal;
    protected boolean directionVertical;
    protected double lastDownSpeed = 0;
    protected double lastUpSpeed = 1;
    protected boolean newBubble;
    protected double wallBounceBoost = 0;

    private int maxheight;
    private Color color;
    private double gravitation;
    private int diameter;
    private double speedX;

    protected double shifting;
    protected double sOld;
    protected double time = 0;
    protected double velocity;
    protected double timeStep = 0.01;
    protected double factor = 2;
    protected int scoreWorth;

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
     * @param maxheight
     *            max bounce height
     * @param color
     *            of the ball
     * @param gravitation
     *            of the ball
     * @param diameter
     *            of the ball
     * @param speedX
     *            speed of the x-Coordination movement
     */
    public Bubble(double xCoord, double yCoord, boolean directionHorizontal,
            boolean directionVertical, int maxheight, Color color,
            double gravitation, int diameter, double speedX) {

        Logger.log("Bubble created with diameter " + diameter, 3, 4);

        this.xCoord = xCoord;
        this.yCoord = yCoord;

        this.maxheight = maxheight;
        this.color = color;
        this.gravitation = gravitation;
        this.diameter = diameter;
        this.speedX = speedX;

        this.directionHorizontal = directionHorizontal;
        this.directionVertical = directionVertical;
        this.newBubble = true;

    }

    /**
     * Move the bubble.
     */
    public void move() {
        outOfBoardCheck();
        bounceBorder();
        moveX();
        moveY();
    }

    /**
     * Check if the bubble isn'time outside of the borders.
     */
    public void outOfBoardCheck() {
        if (yCoord < ScreenSettings.getTopMargin() || !(yCoord > 0)) {
            yCoord = maxheight;
        }
    }

    /**
     * Checks if the bubble bounced against the borders.
     */
    public void bounceBorder() {
        if (xCoord + diameter > ScreenSettings.getLeftMargin()
                + ScreenSettings.getLevelWidth()
                && directionHorizontal
                || xCoord <= ScreenSettings.getLeftMargin()
                && !directionHorizontal) {
            bounceH();
        }
        if (yCoord + diameter > ScreenSettings.getTopMargin()
                + ScreenSettings.getLevelHeight()
                && directionVertical
                || yCoord <= ScreenSettings.getTopMargin()
                && !directionVertical) {
            bounceV();
        }
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
    public abstract ArrayList<Bubble> destroyBubble(int xCoord, int yCoord);

    /**
     * Get the diameter of the bubble.
     * 
     * @return diameter of the bubble
     */
    public abstract int getDiameter();

    /**
     * Get the color of the bubble.
     * 
     * @return color of the bubble
     */
    public abstract Color getColor();

    /**
     * Updates the y-Coordinate location of the bubble.
     */
    public void moveY() {
        mainMovementY();
        if (lastUpSpeed < 0.5
                && !directionVertical
                && yCoord < ScreenSettings.getTopMargin()
                        + ScreenSettings.getLevelHeight() - 50) {
            timer += 0.4;
        }
        if (timer > 5) {
            bounceV();
            timer = 1;
        }
    }

    /**
     * The main movement of the bubble verticlally.
     */
    public void mainMovementY() {
        if (directionVertical) {
            sOld = 0.5 * gravitation * time * time;
            time += timeStep;
            shifting = 0.5 * gravitation * time * time;
            velocity = (shifting - sOld) / timeStep;
            lastDownSpeed = velocity;
            if (wallBounceBoost > 0) {
                wallBounceBoost = wallBounceBoost - 0.01;
                lastDownSpeed += wallBounceBoost;
            }
            yCoord += lastDownSpeed;
            lastDownSpeed += 0.05;
        } else {
            time = 0;
            if (newBubble) {
                newBubble = false;
                lastDownSpeed = 4;
            }
            factor = ((yCoord - maxheight) / (ScreenSettings.getTopMargin()
                    + ScreenSettings.getLevelHeight() - maxheight));
            lastUpSpeed = lastDownSpeed * Math.pow(factor, timer);
            yCoord -= lastUpSpeed;
        }
    }

    /**
     * Updates the x-Coordinate location of the bubble.
     */
    public void moveX() {
        if (directionHorizontal) {
            xCoord += speedX;
        } else {
            xCoord -= speedX;
        }
    }

    /**
     * Switches the horizontal direction.
     */
    public void bounceH() {
        if (directionHorizontal) {
            Logger.log("Bubble bounced on the right wall", 2, 4, 1);
        } else {
            Logger.log("Bubble bounced on the left wall", 2, 4, 1);
        }
        directionHorizontal = !directionHorizontal;

    }

    /**
     * Switches the vertical direction.
     */
    public void bounceV() {
        if (directionVertical) {
            wallBounceBoost = 0;
            Logger.log("Bubble bounced on the floor", 2, 4, 1);
        } else {
            Logger.log("Bubble reached max height", 2, 4, 1);
        }
        directionVertical = !directionVertical;

    }

    /**
     * small boost in speed from bouncing on a wall.
     */
    public void wallBounceBoost() {
        wallBounceBoost = 1;
    }

    /**
     * Get the x-Coordinate of the bubble.
     * 
     * @return x-Coordinate of the bubble
     */
    public int getX() {
        return (int) Math.round(xCoord);
    }

    /**
     * Get the y-Coordinate of the bubble.
     * 
     * @return y-Coordinate of the bubble
     */
    public int getY() {
        return (int) Math.round(yCoord);
    }

    /**
     * Give the horizontal direction of the bubble.
     * 
     * @return the horizontal direction
     */
    public boolean isDirectionH() {
        return directionHorizontal;
    }

    /**
     * Set the horizontal direction of the bubble.
     * 
     * @param directionHorizontal
     *            new horizontal directions
     */
    public void setDirectionH(boolean directionHorizontal) {
        this.directionHorizontal = directionHorizontal;
    }

    /**
     * Get the vertical direction.
     * 
     * @return the vertical direction
     */
    public boolean isDirectionV() {
        return directionVertical;
    }

    /**
     * Set the vertical direction of the bubble.
     * 
     * @param directionVertical
     *            the vertical direction
     */
    public void setDirectionV(boolean directionVertical) {
        this.directionVertical = directionVertical;
    }

    /**
     * @param speedX
     *            the speedX to set
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
     * @return the gravitation
     */
    public double getG() {
        return gravitation;
    }

    /**
     * @return the maxheight
     */
    public int getMaxheight() {
        return maxheight;
    }

    /**
     * Returns the score points this bubble is worth.
     * 
     * @return the score points this bubble is worth
     */
    public int getScoreWorth() {
        return this.scoreWorth;
    }

    /**
     * Sets the score points this bubble is worth.
     * 
     * @param newWorth
     *            the score points this bubble is worth
     */
    public void setScoreWorth(int newWorth) {
        this.scoreWorth = newWorth;
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
        Bubble other = (Bubble) obj;
        if (Double.doubleToLongBits(gravitation) != Double
                .doubleToLongBits(other.gravitation)) {
            return false;
        }
        if (color == null) {
            if (other.color != null) {
                return false;
            }
        } else if (!color.equals(other.color)) {
            return false;
        }
        if (diameter != other.diameter) {
            return false;
        }
        if (directionHorizontal != other.directionHorizontal) {
            return false;
        }
        if (directionVertical != other.directionVertical) {
            return false;
        }
        if (Double.doubleToLongBits(factor) != Double
                .doubleToLongBits(other.factor)) {
            return false;
        }
        if (Double.doubleToLongBits(lastDownSpeed) != Double
                .doubleToLongBits(other.lastDownSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(lastUpSpeed) != Double
                .doubleToLongBits(other.lastUpSpeed)) {
            return false;
        }
        if (maxheight != other.maxheight) {
            return false;
        }
        if (newBubble != other.newBubble) {
            return false;
        }
        if (Double.doubleToLongBits(shifting) != Double
                .doubleToLongBits(other.shifting)) {
            return false;
        }
        if (Double.doubleToLongBits(sOld) != Double
                .doubleToLongBits(other.sOld)) {
            return false;
        }
        if (Double.doubleToLongBits(speedX) != Double
                .doubleToLongBits(other.speedX)) {
            return false;
        }
        if (Double.doubleToLongBits(timeStep) != Double
                .doubleToLongBits(other.timeStep)) {
            return false;
        }
        if (Double.doubleToLongBits(timer) != Double
                .doubleToLongBits(other.timer)) {
            return false;
        }
        if (Double.doubleToLongBits(velocity) != Double
                .doubleToLongBits(other.velocity)) {
            return false;
        }
        if (Double.doubleToLongBits(xCoord) != Double
                .doubleToLongBits(other.xCoord)) {
            return false;
        }
        if (Double.doubleToLongBits(yCoord) != Double
                .doubleToLongBits(other.yCoord)) {
            return false;
        }
        return true;
    }

    /**
     * @return the xCoord
     */
    public double getxCoord() {
        return xCoord;
    }

    /**
     * @param xCoord
     *            the xCoord to set
     */
    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    /**
     * @return the yCoord
     */
    public double getyCoord() {
        return yCoord;
    }

    /**
     * @param yCoord
     *            the yCoord to set
     */
    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }

}
