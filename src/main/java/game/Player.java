package game;

import game.log.Logger;
import game.powerups.Powerup;
import game.wall.DuoWall;
import game.wall.PlayerWall;
import game.wall.Wall;

import java.util.ArrayList;

/**
 * Class that will control a player.
 * 
 * @author Boning
 *
 */
public class Player {
    private String name;
    private int xCoord;
    /**
     * yCoord is calculated by:
     * levelHeight + playerHeight + topMargin
     */
    private int yCoord = 389;
    private int colY = yCoord + 61;
    private int colX;
    private final int height = 161;
    private final int width = 111;
    private int stepSize = 2;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    
    //THIS MIGHT BE MOVED TO PLAYERPOWERUP CLASS OR SOMETHING
    private boolean hasIceRope = false;
    private final int powerupStepSize = 5;
    private final int normalStepSize = 2;
    private boolean restrictMovingLeft = false;
    private boolean restrictMovingRight = false;
    
    //Boundaries of movingspace
    /**
     * The left boundary is the leftmargin of the screen
     */
    private final int boundaryLeft = 75;
    /**
     * The right boundary is calculated by
     * LevelWidth + LeftMargin + 37 <- half of sprite
     */
    private final int boundaryRight = 887;

    /**
     * Constructor for a player.
     * 
     * @param name
     *            of the player
     * @param xCoord
     *            x-Coordinate of the player
     * @param isNormalMode
     *            true if it is a normal game, false otherwise
     */
    public Player(String name, int xCoord) {
        this.name = name;
        this.xCoord = xCoord;

        this.colX = xCoord - 50;
        Logger.log("Player created", 1, 4);
    }

    /**
     * The player moves left.
     */
    public void movingLeft() {
        movingLeft = true;
        Logger.log("Player is moving left", 1, 5);
    }

    /**
     * The player stops moving left.
     */
    public void stopMovingLeft() {
        movingLeft = false;
        Logger.log("Player stopped moving left", 1, 5);
    }

    /**
     * The player moves right.
     */
    public void movingRight() {
        movingRight = true;
        Logger.log("Player is moving right", 1, 5);
    }

    /**
     * The player stops moving right.
     */
    public void stopMovingRight() {
        movingRight = false;
        Logger.log("Player stopped moving right", 1, 5);
    }

    /**
     * Moves the player left or right, depending on what key is pressed.
     *            list of walls
     */
    public void move() {
        if (movingLeft && !restrictMovingLeft) {
            if (xCoord - stepSize > boundaryLeft) {
                xCoord -= stepSize;
                colX -= stepSize;
                setRestrictMovingRight(false);
            } else {
                Logger.log("Player is at the left border", 1, 4);
            }
        }

        if (movingRight && !restrictMovingRight) {
            if (xCoord + stepSize + width < boundaryRight) {
                xCoord += stepSize;
                colX += stepSize;
                setRestrictMovingLeft(false);
            } else {
                Logger.log("Player is at the right border", 1, 4);
            }
        }
    }

    /**
     * Checks if the player has an ice rope.
     * 
     * @return true if it has, false otherwise
     */
    public boolean hasIceRope() {
        return hasIceRope;
    }
    
    /**
     * Sets the new state of the ice rope
     * 
     * @param state of the ice rope
     */
    public void setHasIceRope(boolean state) {
    	hasIceRope = state;
    }

    /**
     * Getter for the name of the player.
     * 
     * @return String name of player
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the player.
     * 
     * @param newName
     *            for the player
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Getter for the moving left attribute.
     * 
     * @return true if player is moving left, false otherwise
     */
    public boolean getMovingLeft() {
        return movingLeft;
    }

    /**
     * Getter for the moving right attribute.
     * 
     * @return true if player is moving right, false otherwise
     */
    public boolean getMovingRight() {
        return movingRight;
    }

    /**
     * Getter for the x-Coordinate.
     * 
     * @return xCoord x-Coordinate
     */
    public int getX() {
        return xCoord;
    }

    /**
     * Getter for the y-Coordinate.
     * 
     * @return yCoord y-Coordinate
     */
    public int getY() {
        return yCoord;
    }

    /**
     * Getter for the collisionX attribute.
     * 
     * @return x-Coordinate of the collision.
     */
    public int getCollisionX() {
        return this.colX;
    }

    /**
     * Getter for the collisionY attribute.
     * 
     * @return y-Coordinate of the collision.
     */
    public int getCollisionY() {
        return this.colY;
    }

    /**
     * Getter for the width of the player.
     * 
     * @return width of the player
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter for the height of the player.
     * 
     * @return height of the player
     */
    public int getHeight() {
        return height;
    }

    /**
     * Remove all powerups of the player.
     * @return the stepSize
     */
    public int getStepSize() {
        return stepSize;
    }

    /**
     * Check if the player has a powerup.
     * 
     * @return true if the player has 1 powerup or more, false otherwise
     */
    public void setStepSize(int stepSize) {
        this.stepSize = stepSize;
    }
    
    /**
     * @return the powerupstepsize of the player
     */
    public int getPlayerPowerupStepSize() {
    	return this.powerupStepSize;
    }
    
    public int getPlayerNormalStepSize() {
    	return this.normalStepSize;
    }

	/**
	 * @return the restrictMovingLeft
	 */
	public boolean isRestrictMovingLeft() {
		return restrictMovingLeft;
	}

	/**
	 * @param restrictMovingLeft the restrictMovingLeft to set
	 */
	public void setRestrictMovingLeft(boolean restrictMovingLeft) {
		this.restrictMovingLeft = restrictMovingLeft;
	}

	/**
	 * @return the restrictMovingRight
	 */
	public boolean isRestrictMovingRight() {
		return restrictMovingRight;
	}

	/**
	 * @param restrictMovingRight the restrictMovingRight to set
	 */
	public void setRestrictMovingRight(boolean restrictMovingRight) {
		this.restrictMovingRight = restrictMovingRight;
	}

}
