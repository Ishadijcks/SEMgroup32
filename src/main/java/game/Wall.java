package game;

import java.awt.Color;

public class Wall {

    private int x;
    private int y;
    private int width = Settings.getWallWidth();
    private int height = Settings.getWallHeight();
    private Color color;
    private boolean isActive;
    
    public Wall (int x, Color color){
        this.x = x;
        this.y = 0;
        this.color = color;
        this.isActive = true;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public Color getColor(){
        return color;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public boolean isActive() {
        return isActive;
    }
    
}
