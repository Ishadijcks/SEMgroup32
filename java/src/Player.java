
public class Player {
	private int x;
	private int y;
	private int height;
	private int width;
	private int stepSize = 10;

	Player( int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void moveLeft(){
		x -= stepSize;
	}
	
	public void moveRIght(){
		x += stepSize;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
}
