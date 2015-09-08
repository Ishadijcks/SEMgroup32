package game;
public class Powerup {
    String name;
    private int x;
    private int y;
    
    int width = Settings.getPowerupWidth();
    int height = Settings.getPowerupHeight();
    
    int framesLeft = 10*Settings.getFps();
    
    public Powerup(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
	public boolean equals(Object obj) {
		if(obj instanceof Powerup){
			obj = (Powerup) obj;
			if(((Powerup) obj).name.equals(this.name))
				if(((Powerup) obj).x == this.x)
					if(((Powerup) obj).y == this.y)
						if(((Powerup) obj).width == this.width)
							if(((Powerup) obj).height == this.height)
								if(((Powerup) obj).framesLeft == this.framesLeft)
									return true;
		}
		return false;
		
	}

	/**
     * The powerup moves up and gets destroyed when it hits the roof
     */
    public void move() {
        if (y <= Driver.game.getCurrentLevel().getHeight() - (height -1) ) {
            y += Settings.getPowerupSpeed();
        }
    }

    public void decreaseFramesLeft(){
        framesLeft--;
    }
    
    public boolean isActive(){
        return framesLeft > 0;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getFramesLeft(){
        return framesLeft;
    }
    
    public String getName(){
        return name;
    }
    
}
