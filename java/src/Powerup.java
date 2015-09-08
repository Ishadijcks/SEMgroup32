public class Powerup {
    String name;
    private int x;
    private int y;
    int height = 15;
    int width = 10;
    int framesLeft = 10*120;
    
    Powerup(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     * The powerup moves up and gets destroyed when it hits the roof
     */
    public void move() {
        if (y <= Driver.game.getLevelList().get(Driver.game.getCurrentLevel()).getHeight() - (height -1) ) {
            y += 1;
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
