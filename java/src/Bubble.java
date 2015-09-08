import java.awt.Color;

public class Bubble {
    private double x;
    private double y;
    private int diameter;
    private boolean directionH;
    private boolean directionV;
    private Color color;
    private double downTime = 1;
    private double upTime = 1;
    private boolean falling = false;
    private double lastDownSpeed = 0;
    private double lastUpSpeed = 0;
    private boolean newBubble;

    /**
     * the constructor sets the starting coordinates, the moving location, the
     * diameter
     * 
     * @param x
     * @param y
     */
    Bubble(int diameter, double x, double y, boolean directionH,
            boolean directionV) {
        this.x = x;
        this.y = y;
        this.directionH = directionH;
        this.directionV = directionV;
        this.diameter = diameter;
        this.newBubble = true;
        // Sets the color depending on the radius of the bubble
        switch (radius) {
        case 8:
            color = Color.BLUE;
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

    public void move(int width, int height) {

        int maxheight = 200;
        if (radius == 4) {
            maxheight = 300;
        }
        if (radius == 8) {
            maxheight = 260;
        }
        if (radius == 16) {
            maxheight = 220;
        }
        if (radius == 32) {
            maxheight = 120;
        }

        if (directionV) {
            downTime += 1;
        } else {
            upTime += 1;
        }

        int range = height - maxheight;
        double speedFactor = 0.8 / range;

        if (x + radius > width && directionH || x <= 1 && !directionH) {
            bounceH();
        }

        if (y + radius > height && directionV || y <= 1 && !directionV) {
            bounceV();
        }

        if (directionH) {
            x += 0.8;
        } else {
            x -= 0.8;
        }

        // bounce on the max height
        if (y < maxheight) {
            directionV = true;
        }
        if (directionV) {
            lastDownSpeed = 0.1 + 4 * (downTime / 100);
            lastDownSpeed = lastDownSpeed * 0.8;
            if (lastDownSpeed > 2.5) {
                lastDownSpeed = 2.5;
            }
            y += 0.2 + 4 * ((downTime + 10) / 100);

        } else {
            if (newBubble) {
                newBubble = false;
                lastDownSpeed = 2;
            }
            // start with the last downspeed but up this speed slows down
            // depending on the uptime
            // mutiply this with a factor that reaches 0 when at max height
            // + 0.1 standaard speed to reach the maxheight (last few pixels)
            lastUpSpeed = (1 - Math.pow((maxheight / y), 5) + 0.05)
                    * (lastDownSpeed - Math.pow(upTime, 1 / 3) + 0.7) + 0.05;
            if (lastUpSpeed < 0.1) {
                lastUpSpeed = 0.1;
            }
            y -= lastUpSpeed;
        }

    }

    /**
     * switches the horizontal direction
     */
    public void bounceH() {
        directionH = !directionH;
    }

    /**
     * switches the vertical direction
     */
    public void bounceV() {
        directionV = !directionV;
        if (directionV) {
            falling = true;
            upTime = 1;
        } else {
            falling = false;
            downTime = 1;
        }
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

}
