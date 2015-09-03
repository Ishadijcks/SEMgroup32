import java.awt.Color;

public class Bubble {
	private int x;
	private int y;
	private int radius;
	private boolean directionH;
	private boolean directionV;
	private Color color;

	/**
	 * the constructor sets the starting coordinates the moving location the
	 * radius
	 * 
	 * @param x
	 * @param y
	 */
	Bubble(int radius, int x, int y, boolean directionH, boolean directionV) {
		this.x = x;
		this.y = y;
		this.directionH = directionH;
		this.directionV = directionV;
		this.radius = radius;

		// Sets the color depending on the radius of the bubble
		switch (radius) {
		case 1:
			color = Color.BLUE;
			break;
		case 2:
			color = Color.BLACK;
			break;
		case 4:
			color = Color.GREEN;
			break;
		case 8:
			color = Color.CYAN;
			break;
		case 16:
			color = Color.PINK;
			break;
		default:
			color = Color.MAGENTA;
			break;
		}
	}

	public void move(int width, int height) {
		// moeilijke berekeningen enzo
		if (x + radius > width && directionH || x <= 1 && !directionH) { 
			bounceH();
		}

		if (y + radius > height && directionV || y <= 1 && !directionV) {
			bounceV();
		}

		if (directionH) {
			x++;
		} else {
			x--;
		}
		if (directionV) {
			y++;
		} else {
			y--;
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
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}
	
	public Color getColor(){
		return color;
	}


}
