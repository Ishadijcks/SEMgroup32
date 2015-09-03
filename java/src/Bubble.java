public class Bubble {
	private int x;
	private int y;
	private int radius;
	private boolean directionH;
	private boolean directionV;
	private String color;

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
			color = "#ecff13";
			break;
		case 2:
			color = "#33ef5f";
			break;
		case 3:
			color = "#3aa9ff";
			break;
		default:
			color = "#0b33ff";
			break;
		}
	}

	public void move(int width, int height) {
		// moeilijke berekeningen enzo
		if (x + radius > width && directionH || x <= 1 && !directionH) { // 250 should should level.size();
			bounceH();
		}

		if (y + radius > height && directionV || y <= 1 && !directionV) { // 350 should should level.size();
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}
}
