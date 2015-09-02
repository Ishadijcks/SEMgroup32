
public class Player {

	private int X;
	private int height;
	private int width;
	
	public Player(int x){
		this.X = x;
		this.height = 40;
		this.width = 20;
	}
	
	
	
	public void moveLeft(){
		if(X > 0){
			X++;
		}
	}
	
	public void moveRight(){
		if(X < 250){  // 250 should be level.size
			X--;
		}
	}
	
	public int getX() {
		return X;
	}
	
	public int getHeight(){
		return height;
	}

	public int getWidth(){
		return width;
	}
}
