package game;

import java.awt.Color;

public class Bubble {
    private double x;
    private double y;
    private int diameter;
    private int maxheight = 0;
    private double timer = 1;
    private boolean directionH;
    private boolean directionV;
    private Color color;
    private double lastDownSpeed = 0;
    private double lastUpSpeed = 1;
    private boolean newBubble;
    private static Color dragonRed = new Color(135, 15, 15);

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
        this.x = x;
        this.y = y;
        this.directionH = directionH;
        this.directionV = directionV;
        this.diameter = diameter;
        this.newBubble = true;

        // Sets the color depending on the radius of the bubble
        switch (diameter) {
            case 8:
                color = dragonRed;
                break;
            case 16:
                color = Color.BLACK;
                break;
            case 32:
                color = Color.GREEN;
                break;
            case 64:
                color = Color.CYAN;
                break;
            case 128:
                color = Color.PINK;
                break;
            default:
                color = Color.MAGENTA;
                break;
        }
    }

    /**
     * The method that controlss bubble movement.
     * 
     * @param width
     * @param height
     */
    public void move(int width, int height) {

        if (diameter == 4) {
            G = 2.0;
            maxheight = 120;
            speedX = 0.5;
        }
        if (diameter == 8) {
            G = 2.1;
            maxheight = 95;
            speedX = 0.6;
        }
        if (diameter == 16) {
            G = 2.3;
            maxheight = 75;
            speedX = 0.7;
        }
        if (diameter == 32) {
            G = 2.5;
            maxheight = 56;
            speedX = 0.8;
        }

        if (diameter == 64) {
            G = 2.8;
            maxheight = 40;
            speedX = 0.9;
        }

        if (x + diameter > width && directionH || x <= Settings.getLeftMargin() && !directionH) {
            bounceH();
        }

        if (y + diameter > height && directionV || y <= Settings.getTopMargin() && !directionV) {
            bounceV();
        }

        if (directionH) {
            x += speedX;
        } else {
            x -= speedX;
        }

        if (lastUpSpeed < 0.5 && !directionV && y < height - 50) {
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
            factor = ((y - maxheight) / (height - maxheight));
            lastUpSpeed = lastDownSpeed * Math.pow(factor, timer);
            y -= lastUpSpeed;
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

    public boolean isDirectionH() {
        return directionH;
    }

    public void setDirectionH(boolean directionH) {
        this.directionH = directionH;
    }

    public boolean isDirectionV() {
        return directionV;
    }

    public void setDirectionV(boolean directionV) {
        this.directionV = directionV;
    }

}
