public class Rope {
	private int x;
	private int y;

	Rope(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move() {
		if(y <= 0){
			Driver.game.getLevelList().get(Driver.game.getCurrentLevel()).setRope(null);
		}
		else{
		y--;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
