public class Player {
	private String name;
	private int x;
	private int y;
	private int height = 40;
	private int width = 20;
	private int stepSize = 2;
	private boolean movingLeft = false;
	private boolean movingRight = false;

	Player(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	/**
	 * The player moves left
	 */
	public void movingLeft() {
		movingLeft = true;
	}
	/**
	 * The player stops moving left
	 */
	public void stopMovingLeft() {
		movingLeft = false;
	}

	/**
	 * The player moves right
	 */
	public void movingRight() {
		movingRight = true;
	}


	/**
	 * The player stops moving right
	 */
	public void stopMovingRight() {
		movingRight = false;
	}

	public void move() {
		if (movingLeft) {
			if (x - stepSize > 0) {
				x -= stepSize;
			}
		}

		if (movingRight) {
			if (x + stepSize + width < Driver.game.getLevelList()
					.get(Driver.game.getCurrentLevel()).getWidth()) {
				x += stepSize;
			}
		}
	}

	public void shootRope() {
		if (!Driver.game.getLevelList().get(Driver.game.getCurrentLevel())
				.hasRope()) {
			int ropeY = Driver.game.getLevelList()
					.get(Driver.game.getCurrentLevel()).getHeight()
					- height + 2;
			int ropeX = x + width / 2;
			Rope rope = new Rope(ropeX, ropeY);

			Driver.game.getLevelList().get(Driver.game.getCurrentLevel())
					.setRope(rope);
		}
	}

	// Getters and setters
	public String getName() {
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
