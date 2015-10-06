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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wall other = (Wall) obj;
		if (bouncedOn != other.bouncedOn)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (height != other.height)
			return false;
		if (isActive != other.isActive)
			return false;
		if (width != other.width)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
