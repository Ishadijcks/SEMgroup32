import java.awt.Color;

public class Bubble {
	private double x;
	private double y;
	private int radius;
	private boolean directionH;
	private boolean directionV;
	private Color color;
	private double downTime = 1;
	private double upTime = 1;
	private boolean falling = false;
	private double lastDownSpeed = 0;
	private double lastUpSpeed = 0;
	private boolean newBubble = true;

	private double s;
	private double t = 0;
	private double a;
	private double v;
	private double Ek;
	private double Ez;
	private double oldEz;
	private double h;
	private double oldh;
	private double m = 1;
	

	/**
	 * the constructor sets the starting coordinates the moving location the
	 * radius
	 * 
	 * @param x
	 * @param y
	 */
	Bubble(int radius, double x, double y, boolean directionH,
			boolean directionV) {
		this.x = x;
		this.y = y;
		this.directionH = directionH;
		this.directionV = directionV;
		this.radius = radius;
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
		// System.out.println(directionV);

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
		if(newBubble){
		newBubble = false;
		}
		
		
		h = (height -y)/10;
		
		if (directionV) {
			Ez = m * 9.81 * h;
			oldEz = m * 9.81 * oldh;
			Ek = oldEz - Ez;
			v = Math.sqrt(Ek/ (0.5 * m));
			v = Math.round(v);
			lastDownSpeed = v;
			y += v + 0.2;
		} else {
			Ek = 0.5 * m * lastDownSpeed * lastDownSpeed;
			Ez = m * 9.81 * h;
			Ek = Ek - Ez;
			v = Math.sqrt(Ek/ (0.5 * m));
			v = Math.round(v);
			y -= v + 0.2;
		}
		oldh = h;
		t += 0.1;
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
		t= 0;
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

	public int getRadius() {
		return radius;
	}

	public Color getColor() {
		return color;
	}

}
