package game.wall;

import game.Settings;

import java.awt.Color;

public class Wall {

    private int x;
    private int y;
    private int width = Settings.getWallWidth();
    private int height = Settings.getWallHeight();
    private Color color;
    
    public Wall (int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
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

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
    
}
