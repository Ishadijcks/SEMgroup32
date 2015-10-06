package game;


import game.log.Logger;
import game.screens.StartScreen;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Class that controls the powerups.
 * @author Boning
 */
public class Powerup {
    String name;
    private int xCoord;
    private int yCoord;
    private Image image;
    
    int width = Settings.getPowerupWidth();
    int height = Settings.getPowerupHeight();
    
    private boolean normalMode;
    
    int framesLeft = 10*Settings.getFps();
    
    /**
     * Constructor of the powerup.
     * @param name
     * @param xCoord
     * @param yCoord
     */
    public Powerup(String name, int xCoord, int yCoord, boolean isNormalMode) {
        Logger.log("Powerup created", 6, 4);
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        normalMode = isNormalMode;
    }

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
			if (((Powerup) obj).name.equals(this.name)) {
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
		}
		return false;
		
	}

	/**
     * The powerup moves down till it hits the floor.
     */
    public void move() {
        if (normalMode) {
            if (yCoord <= NormalDriver.game.getCurrentLevel().getHeight() - (height - 1)) {
                Logger.log("Powerup moved from " + xCoord + "," + yCoord + " to " + xCoord 
                        + "," + (yCoord + Settings.getPowerupSpeed()), 6, 5, 10);
                yCoord += Settings.getPowerupSpeed();
            }
        }
        else {
            if (yCoord <= SurvivalDriver.game.getCurrentLevel().getHeight() - (height - 1)) {
                Logger.log("Powerup moved from " + xCoord + "," + yCoord + " to " + xCoord
                        + "," + (yCoord + Settings.getPowerupSpeed()), 6, 5, 10);
                yCoord += Settings.getPowerupSpeed();
            }
        }

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
        framesLeft = 10 * Settings.getFps();
    }
    
    /**
     * Compare the names of the powerup to determine if they are the same sort.
     * @param that given object that will be compared
     * @return true if it is of the same type, false otherwise
     */
    public boolean samePowerup(Powerup that) {
        if (getName().equals(that.getName())) {
            return true;
        }
        
        return false;
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
     * Get the name of the powerup.
     * @return the name of the powerup
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the image of the powerup.
     * @return the image of the powerup
     */
    public ImageIcon getImageIcon() {
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        imageLocation = imageLocation.replace("target/classes/", "src/");
        if (name.equals("speed")) {
            ImageIcon powerupspeed = new ImageIcon(imageLocation + "main/Images/Powerups/puspeed.png", "speed");
            return powerupspeed;
        }
        if (name.equals("life")) {
            ImageIcon poweruplife = new ImageIcon(imageLocation + "main/Images/Powerups/pulife.png", "life");
            return poweruplife;
        }
        if (name.equals("ice")) {
            ImageIcon powerupice = new ImageIcon(imageLocation + "main/Images/Powerups/puice.png", "ice");
            return powerupice;
        }
        return null;
        
    }
    
}
