package game.wall;

import game.Settings;

import java.awt.Color;

public class Wall {

    private int x;
    private int y;
    private int width = Settings.getWallWidth();
    private int height = Settings.getWallHeight();
    private Color color;
    private boolean isActive;
    private int bouncedOn;

    public Wall(int x, Color color) {
        this.x = x;
        this.y = 0;
        this.color = color;
        this.isActive = true;
        this.bouncedOn = 0;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
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

    public void setActive(boolean bool) {
        isActive = bool;
    }

    public int getBouncedOn() {
        return bouncedOn;
    }

    public void BouncedOn() {
        bouncedOn++;
        setActive(false);
    }

}
