package game;


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

    /**
     * Decrease the frames that are left
     */
    public void decreaseFramesLeft(){
        framesLeft--;
    }
    
    public boolean isActive(){
        return framesLeft > 0;
    }
    
    public void deActive(){
        framesLeft = 0;
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
        if(name.equals("speed"))
        {
            ImageIcon powerupspeed = new ImageIcon(imageLocation + "main/Images/Powerups/puspeed.png");
            return powerupspeed;
        }
        if(name.equals("life"))
        {
            ImageIcon poweruplife = new ImageIcon(imageLocation + "main/Images/Powerups/pulife.png");
            return poweruplife;
        }
        if(name.equals("ice"))
        {
            ImageIcon powerupice = new ImageIcon(imageLocation + "main/Images/Powerups/puice.png");
            return powerupice;
        }
        return null;
        
    }
    
}
