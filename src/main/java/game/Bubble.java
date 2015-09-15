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
            boolean directionV) {
        
        this.x = x;
        this.y = y;

        this.directionH = directionH;
        this.directionV = directionV;
        this.newBubble = true;
        
    }

    /**
     * get the correct X of the bubble
     * @param x
     * @param diameter
     * @return the x of the bubble
     */
    public boolean correctX(double x, int diameter) {
        return x > 0 && x < Settings.getLeftMargin() + Settings.getLevelWidth() - diameter;
    }

    /**
     * get the correct Y of the bubble
     * @param y
     * @param diameter
     * @return the y of the bubble
     */
    public boolean correctY(double y, int diameter) {
        return y > Settings.getTopMargin() && y < (Settings.getTopMargin() + Settings.getLevelHeight() - diameter);
    }

    /**
     * The method that controls bubble movement.
     * 
     * @param width
     * @param height
     */
    public abstract void move();
    
    /**
     * check if the bubble isn't outside of the borders.
     */
    public abstract void outOfBoardCheck();
    
    /**
     * Checks if the bubble needs to bounce cause of the borders.
     * If needed bounce.
     */
    public abstract void bounceBorder();
    
    public abstract ArrayList<Bubble> destroyBubble(int x, int y);
    
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
    

    public abstract int getDiameter();
    
    public abstract Color getColor();
    /**
     * Updates the y location of the bubble.
     */
    public abstract void moveY();

    /**
     * switches the horizontal direction.
     */
    public void bounceH() {
        directionH = !directionH;
    }

    /**
     * switches the vertical direction.
     */
    public void bounceV() {
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
     * @return the horizontal direction 
     */
    public boolean isDirectionH() {
        return directionH;
    }

    /**
     * Set the direction of the bubble
     * @param directionH
     */
    public void setDirectionH(boolean directionH) {
        this.directionH = directionH;
    }
    
    /**
     * Get the vertical direction
     * @return the vertical direction
     */
    public boolean isDirectionV() {
        return directionV;
    }

    /**
     * Set the vertical direction of the bubble
     * @param directionV
     */
    public void setDirectionV(boolean directionV) {
        this.directionV = directionV;
    }

}
