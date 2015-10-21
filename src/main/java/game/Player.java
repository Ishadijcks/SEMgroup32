package game;

import game.log.Logger;
import settings.PlayerSettings;
import settings.ScreenSettings;

/**
 * Class that will control a player.
 * 
 * @author Boning
 *
 */
public class Player {
    private String name;
    private int xCoord;
    private int yCoord = ScreenSettings.getLevelHeight()
            - PlayerSettings.getPlayerHeight() + ScreenSettings.getTopMargin();
    private int colY = yCoord + 61;
    private int colX;
    private int height = PlayerSettings.getPlayerHeight();
    private int width = PlayerSettings.getPlayerWidth();
    private int stepSize = PlayerSettings.getPlayerStepSize();
    private boolean movingLeft = false;
    private boolean movingRight = false;


    private final int powerupStepSize = 5;
    private final int normalStepSize = 2;

    /**
     * Constructor for a player.
     * 
     * @param name
     *            of the player
     * @param xCoord
     *            x-Coordinate of the player
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
     * Set the x coordinate of the player.
     * 
     * @param x
     *            new xcoord player
     */
    public void setXCoord(int x) {
        xCoord = x;
    }

    /**
     * Moves the player left or right, depending on what key is pressed. list of
     * walls
     */
    public void move() {
        if (movingLeft && !PlayerSettings.isRestrictMovingLeft()) {
            if (xCoord - stepSize > ScreenSettings.getLeftMargin()) {
                xCoord -= stepSize;
                colX -= stepSize;
                PlayerSettings.setRestrictMovingRight(false);
            } else {
                Logger.log("Player is at the left border", 1, 4);
            }
        }

        if (movingRight && !PlayerSettings.isRestrictMovingRight()) {
            if (xCoord + stepSize + width < ScreenSettings.getLevelWidth()
                    + ScreenSettings.getLeftMargin() + 37) {
                xCoord += stepSize;
                colX += stepSize;
                PlayerSettings.setRestrictMovingLeft(false);
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
        return PlayerSettings.getPlayerHasIceRope();
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
     * 
     * @return the stepSize
     */
    public int getStepSize() {
        return stepSize;
    }


    /**
     * Set the stepsize of the player.
     * @param stepSize The stepsize
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

    /**
     * @return the normal stepSize of the player.
     */
    public int getPlayerNormalStepSize() {
        return this.normalStepSize;
    }

}
