public class Ball {

	private int size;
	private boolean directionH; // 0 = left, 1 = right
	private boolean directionV; // 0 = up, 1 = down
	private String color;
	private int X;
	private int Y;

	public Ball(int size, boolean direction, String color) {
		this.size = size;
		this.directionH = direction;
		this.directionV = true;
		this.color = color;

	}

	public void moveBall() {
		if(X+size > 250 && directionH || X <= 1 && !directionH){ // 250 should be level.size();
			bounceH();
		}
	
		if(Y+size > 350 && directionV || Y <= 1 && !directionV){ // 350 should be level.size();
			bounceV();
		}
		
		if (directionH) {
			X++;
		} else {
			X--;
		}
		if (directionV) {
			Y++;
		} else {
			Y--;
		}
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}
	
	public int getSize(){
		return size;
	}

	public void bounceH() {
		directionH = !directionH;
	}

	public void bounceV() {
		directionV = !directionV;
	}
}
