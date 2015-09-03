public class Player {
	private String name;
	private int x;
	private int y;
	private int height = 40;
	private int width = 20;
	private int stepSize = 10;

	Player(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	/**
	 * The player moves left
	 */
	public void moveLeft() {
		x -= stepSize;
	}

	/**
	 * The player moves right
	 */
	public void moveRight() {
		x += stepSize;
	}

	// Getters and setters
	public String getName(){
		return name;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
