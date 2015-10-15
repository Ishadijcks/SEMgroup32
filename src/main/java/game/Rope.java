package game;

import settings.ropeSettings;
import settings.screenSettings;
import game.log.Logger;

/**
 * Rope class.
 * 
 * @author Boning
 */
public class Rope {
    protected int xCoord;
    protected int yCoord;

    /**
     * Constructor for a rope.
     * 
     * @param xCoord
     *            x-Coordinate of the rope
     * @param yCoord
     *            y-Coordinate of the rope
     * @param isNormalMode
     *            checks if it is a normal game of a survival game
     */
    public Rope(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    
    public boolean isAtTop(){
    	 if (yCoord <= screenSettings.getTopMargin() - 2) {
    		 return true;
    	 }
    	 return false;
    }

    /**
     * The rope moves up and gets destroyed when it hits the roof.
     */
    public void move() {
        if (isAtTop()) {
            Driver.game.getCurrentLevel()
                     .setRope(null);
            Logger.log("Rope hit the roof", 5, 4);
         } else {
             Logger.log("Rope moved from " + xCoord + "," + yCoord
                     + " to " + xCoord + "," + (yCoord - ropeSettings.getRopeSpeed()), 5, 5);
             yCoord -= ropeSettings.getRopeSpeed();
         }
    }

    /**
     * Increase the x-Coordinate.
     * 
     * @param extra
     *            Increased amount to the x-Coordinate
     */
    public void addX(int extra) {
        this.xCoord += extra;
    }

    /**
     * Getter for the x-Coordinate.
     * 
     * @return the x-Coordinate of the rope
     */
    public int getX() {
        return xCoord;
    }

    /**
     * Getter for the y-Coordinate.
     * 
     * @return the y-Coordinate of the rope
     */
    public int getY() {
        return yCoord;
    }

    /**
     * Generated equals method to check if a rope object equals another rope
     * object.
     * 
     * @param obj
     *            Object that it will compare to
     * @return true if the object is from the same type and has the same
     *         attributes
     */
    @Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Rope other = (Rope) obj;
		if (xCoord != other.xCoord) {
			return false;
		}
		if (yCoord != other.yCoord) {
			return false;
		}
		return true;
	}
}
