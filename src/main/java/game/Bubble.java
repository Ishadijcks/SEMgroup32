package game;

import java.awt.Color;

public class Bubble {
    private double x = 10;
    private double y = 10;
    private int diameter = 16;
    private int maxheight = 0;
    private double timer = 1;
    private boolean directionH;
    private boolean directionV;
    private Color color;
    private double lastDownSpeed = 0;
    private double lastUpSpeed = 1;
    private boolean newBubble;
    private static Color dragonRed = Settings.getDragonRed();

    private double speedX;

    private double s;
    private double sOld;
    private double t = 0;
    private double v;
    private double timeStep = 0.01;
    private double G = 3;
    private double factor = 2;

    /**
     * the constructor sets the starting coordinates, the moving location, the
     * diameter.
     * 
     * @param x
     * @param y
     */
    public Bubble(int diameter, double x, double y, boolean directionH,
            boolean directionV) {

        if (correctDiameter(diameter)) {
            this.diameter = diameter;
        } else {
            this.diameter = Settings.getBubbleDefaultDiameter();
        }

        if (correctX(x, diameter)) {
            this.x = x;
        }

        else {
            this.x = Settings.getBubbleDefaultX() ;
            
        }

        if (correctY(y, diameter)) {
            this.y = y;
        }

        else {
            this.y = Settings.getBubbleDefaultY();
        }

        this.directionH = directionH;
        this.directionV = directionV;
        this.newBubble = true;

        // Sets the color depending on the radius of the bubble
        this.color = calculateColor(diameter);
    }

    /**
     * Get the correct diameter
     * @param diameter
     * @return de diameter van de bubble
     */
    public boolean correctDiameter(int diameter) {
        return diameter > 0 && diameter < 200;
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
    public void move() {

        G = calculateG(diameter);
        maxheight = calculateMaxHeight(diameter);
        speedX = calculateSpeedX(diameter);

        if (x + diameter > Settings.getLeftMargin() + Settings.getLevelWidth() && directionH || x <= Settings.getLeftMargin() && !directionH) {
            bounceH();
        }

        if (y + diameter > Settings.getTopMargin() + Settings.getLevelHeight() && directionV || y <= Settings.getTopMargin()
                && !directionV) {
            bounceV();
        }

        if (directionH) {
            x += speedX;
        } else {
            x -= speedX;
        }
       
        if (lastUpSpeed < 0.5 && !directionV && y < Settings.getTopMargin() + Settings.getLevelHeight() - 50) {
            timer += 0.4;
        }
        if (timer > 5) {
            bounceV();
            timer = 1;
        }

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
            factor = ((y - maxheight) / (Settings.getTopMargin() + Settings.getLevelHeight() - maxheight));
            lastUpSpeed = lastDownSpeed * Math.pow(factor, timer);
            y -= lastUpSpeed;
        }

    }

    /**
     * Give a color to the different balls
     * @param diameter
     * @return the color of the bubble per case
     */
    public Color calculateColor(int diameter) {
        switch (diameter) {
        case 8:
            return dragonRed;
        case 16:
            return Color.BLACK;
        case 32:
            return Color.GREEN;
        case 64:
            return Color.CYAN;
        case 128:
            return Color.PINK;
        default:
            return Color.MAGENTA;

        }

    }

    /**
     * Calculate the speed of the bubble
     * @param diameter
     * @return the speed of the bubble
     */
    public double calculateG(int diameter) {
        switch (diameter) {
        case 4:
            return 2.0;
        case 8:
            return 2.1;
        case 16:
            return 2.3;
        case 32:
            return 2.5;
        case 64:
            return 2.8;
        default:
            return 3;
        }

    }

    /**
     * Calculate the maximum height of the bubbles
     * @param diameter
     * @return the maximum height per bubble.
     */
    public int calculateMaxHeight(int diameter) {
        switch (diameter) {
        case 4:
            return 120;
        case 8:
            return 95;
        case 16:
            return 75;
        case 32:
            return 56;
        case 64:
            return 40;
        default:
            return 100;

        }
    }
    
    /**
     * Calculate the speed of the bubble
     * @param diameter
     * @return the speed of the bubble per case.
     */
    public double calculateSpeedX(int diameter) {
        switch (diameter) {
        case 4:
            return 0.5;
        case 8:
            return 0.6;
        case 16:
            return 0.7;
        case 32:
            return 0.8;
        case 64:
            return 0.9;
        default:
            return 0.75;
        }
    }

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

    public int getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
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
