package game.powerups;


import game.Driver;
import game.Game;
import game.log.Logger;

import javax.swing.ImageIcon;

import settings.PowerupSettings;
import settings.ScreenSettings;

/**
 * Class that controls the powerups.
 * @author Boning
 */
public abstract class Powerup {
    private int xCoord;
    private int yCoord;
   
    protected Game game;
    
    int width = PowerupSettings.getPowerupWidth();
    int height = PowerupSettings.getPowerupHeight();
    
    int framesLeft = 10 * ScreenSettings.getFps();

    /**
     * Constructor of the powerup.
     * @param name
     * @param xCoord The xCoord of the rope
     * @param yCoord The yCoord of the rope
     */
    public Powerup(int xCoord, int yCoord) {
        Logger.log("Powerup created", 6, 4);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    
    /**
     * What will happen if you pick the powerup up.
     */
    public abstract void executeEffect();

    /**
     * Generated equals method to check if all attributes 
     * equals another of the same class.
     * @param obj Object that it will compare to
     * @return true if the object is from the same type and has the same attributes
     */
    @Override
	public boolean equals(Object obj) {
		if (obj instanceof Powerup) {
			obj = (Powerup) obj;
			if (((Powerup) obj).xCoord == this.xCoord) {
				if (((Powerup) obj).yCoord == this.yCoord) {
					if (((Powerup) obj).width == this.width) {
						if (((Powerup) obj).height == this.height) {
							if (((Powerup) obj).framesLeft == this.framesLeft) {
								return true;
							}
						}
					}
				}
				
			}
		}
		return false;
		
	}

	/**
     * The powerup moves down till it hits the floor.
     */
    public void move() {
        if (yCoord <= Driver.game.getCurrentLevel().getHeight() - (height - 1)) {
            Logger.log("Powerup moved from " + xCoord + "," + yCoord + " to " + xCoord 
                    + "," + (yCoord + PowerupSettings.getPowerupSpeed()), 6, 5, 10);
            yCoord += PowerupSettings.getPowerupSpeed();
        }
        

    }
    
    /**
     * Add this powerup to the current level.
     */
    public void addToLevel() {
    	Driver.game.getCurrentLevel().getPowerupList().add(this);
    }

    /**
     * Decrease the frames that are left.
     */
    public void decreaseFramesLeft() {
        framesLeft--;
    }
    
    /**
     * The powerup is active when the framesLeft count is higher than zero.
     * @return true if the powerup is active, false otherwise
     */
    public boolean isActive() {
        return framesLeft > 0;
    }
    
    /**
     * DeActivate the powerup by setting the framesLeft counter to zero.
     */
    public void deActivate() {
        framesLeft = 0;
    }
    
    /**
     * Reset the framesLeft counter to the starting count.
     */
    public void resetFramesLeft() {
        framesLeft = 10 * ScreenSettings.getFps();
    }
    
    /**
     * Get the x-Coordinate of the powerup.
     * @return the x-Coordinate of the powerup
     */
    public int getX() {
        return xCoord;
    }

    /**
     * Get the y-Coordinate of the powerup.
     * @return the y-Coordinate of the powerup
     */
    public int getY() {
        return yCoord;
    }
    
    /**
     * Get the height of the powerup.
     * @return the height of the powerup
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Get the width of the powerup.
     * @return the width of the powerup
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Get the frames that are left of the powerup.
     * @return the amount of frames left
     */
    public int getFramesLeft() {
        return framesLeft;
    }
    
    /**
     * Set the frames that are left of the powerup.
     * @param left new amount of framesLeft
     */
    public void setFramesLeft(int left) {
        framesLeft = left;
    }
    
    /**
     * Get the image of the powerup.
     * @return the image of the powerup
     */
    public abstract ImageIcon getImageIcon();


	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.xCoord = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.yCoord = y;
	}
	
	/**
	 * Set the game.
	 * @param game in which powerups will spawn
	 */
	public abstract void setGame(Game game);
    
}
