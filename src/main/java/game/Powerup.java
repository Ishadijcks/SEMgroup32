package game;


import game.log.Logger;
import game.screens.StartScreen;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Class that controls the powerups
 * @author Naomi
 *
 */
public class Powerup {
    String name;
    private int x;
    private int y;
    private Image image;
    
    int width = Settings.getPowerupWidth();
    int height = Settings.getPowerupHeight();
    
    int framesLeft = 10*Settings.getFps();
    
    /**
     * Constructor of the powerup
     * @param name
     * @param x
     * @param y
     */
    public Powerup(String name, int x, int y) {
        Logger.log("Powerup created", 6, 4);
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
     * The powerup moves down till it hits the floor
     */
    public void move() {
        if (y <= Driver.game.getCurrentLevel().getHeight() - (height -1) ) {
            Logger.log("Powerup moved from "+x+","+y+ " to "+ x + ","+(y+Settings.getPowerupSpeed()), 6, 5,10);
            y += Settings.getPowerupSpeed();
            
        }
    }

    /**
     * Decrease the frames that are left
     */
    public void decreaseFramesLeft(){
        framesLeft--;
    }
    
    /**
     * The powerup is active when the framesLeft count is higher than zero
     */
    public boolean isActive(){
        return framesLeft > 0;
    }
    
    /**
     * DeActivate the powerup by setting the framesLeft counter to zero
     */
    public void deActivate(){
        framesLeft = 0;
    }
    
    /**
     * Reset the framesLeft counter to the starting count
     */
    public void resetFramesLeft(){
        framesLeft = 10*Settings.getFps();
    }
    
    /**
     * Compare the names of the powerup to determine if they are the same sort
     */
    public boolean samePowerup(Powerup that){
        if(getName().equals(that.getName()))
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * Get the x coordinate of the powerup
     * @return the height of the powerup
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y coordinate of the powerup
     * @return the y coordinate of the powerup
     */
    public int getY() {
        return y;
    }
    
    /**
     * Get the height of the powerup
     * @return the height of the powerup
     */
    public int getHeight(){
        return height;
    }
    
    /**
     * Get the width of the powerup
     * @return the width of the powerup
     */
    public int getWidth(){
        return width;
    }
    
    /**
     * Get the frames that are left of the powerup
     * @return the frames left
     */
    public int getFramesLeft(){
        return framesLeft;
    }
    
    /**
     * Set the frames that are left of the powerup
     * @return the frames left
     */
    public void setFramesLeft(int left){
        framesLeft = left;
    }
    
    /**
     * Get the name of the powerup
     * @return the name of the powerup
     */
    public String getName(){
        return name;
    }
    
    /**
     * Get the image of the powerup
     * @return the image of the powerup
     */
    public ImageIcon getImageIcon() {
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        if(name.equals("speed"))
        {
            ImageIcon powerupspeed = new ImageIcon(imageLocation + "main/Images/Powerups/puspeed.png", "speed");
            return powerupspeed;
        }
        if(name.equals("life"))
        {
            ImageIcon poweruplife = new ImageIcon(imageLocation + "main/Images/Powerups/pulife.png", "life");
            return poweruplife;
        }
        if(name.equals("ice"))
        {
            ImageIcon powerupice = new ImageIcon(imageLocation + "main/Images/Powerups/puice.png", "ice");
            return powerupice;
        }
        return null;
        
    }
    
}
