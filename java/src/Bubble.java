import java.awt.Color;

public class Bubble {    private double x;
    private double y;
    private int diameter;
    private boolean directionH;
    private boolean directionV;
    private Color color;
    private double lastDownSpeed = 0;
    private double lastUpSpeed = 0;
    private boolean newBubble;

	private double s;
	private double sOld;
	private double t = 0;
	private double a;
	private double v;
	private double Ek;
	private double Ez;
	private double oldEz;
	private double h;
	private double oldh;
	private double m = 1;
	private double timeStep = 1/ Settings.getFps();

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
        switch (diameter) {
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
        if (diameter == 4) {
            maxheight = 300;
        }
        if (diameter == 8) {
            maxheight = 260;
        }
        if (diameter == 16) {
            maxheight = 220;
        }
        if (diameter == 32) {
            maxheight = 120;
        }

        if (x + diameter > width && directionH || x <= 1 && !directionH) {
            bounceH();
        }

        if (y + diameter > height && directionV || y <= 1 && !directionV) {
            bounceV();
        }

        // bounce on the max height
        if (y < maxheight) {
            directionV = true;
        }
        
        if (directionV) {
            sOld = 1/2 * 9.81 * t * t;
        	t += timeStep;
            s = 1/2 * 9.81 * t * t;
            v = (s - sOld ) / timeStep;
            lastDownSpeed = v;
            y += lastDownSpeed / timeStep;

        } else {
        	t = 0;
            if (newBubble) {
                newBubble = false;
                if(lastDownSpeed < 1){
                lastDownSpeed = 1;
                }
            }
            Ek = 0.5 * m * lastDownSpeed * lastDownSpeed;
            h = height - y;
            Ez = m * 9.81 * h;
            v = Math.sqrt(Ek/ (0.5 * m));
			v = Math.round(v);
			lastUpSpeed = v/timeStep;
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
