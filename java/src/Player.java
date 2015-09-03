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


	public void shootRope() {
		if(!Driver.game.getLevelList().get(Driver.game.getCurrentLevel()).hasRope()){
		int ropeY =  Driver.game.getLevelList().get(Driver.game.getCurrentLevel()).getHeight() - height + 2;
		int ropeX = x + width/2;
		Rope rope = new Rope(ropeX, ropeY);		

		Driver.game.getLevelList().get(Driver.game.getCurrentLevel()).setRope(rope);
		}
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
