package game;

import java.awt.Color;

/**
 * Class that keeps all the settings of the whole game.
 * 
 * @author Boning
 *
 */
public class Settings {

    private static int fps = 120;
    private static int screenWidth = 1000;
    private static int screenHeight = 800;

    private static int levelWidth = 850;
    private static int levelHeight = 500;

    private static int pauseWidth = 850;
    private static int pauseHeight = 500;

    private static int playerHeight = 161;
    private static int playerWidth = 111;
    private static int playerStepSize = 2;
    private static int playerPowerupStepSize = 5;

    private static int bubbleDefaultDiameter = 16;
    private static int bubbleDefaultX = 10;
    private static int bubbleDefaultY = 10;
    private static int lives = 5;
    private static int ropeSpeed = 4;
    private static int smallestBubbleSize = 5;

    private static int powerupSpeed = 2;
    private static int powerupChance = 100;
    private static int powerupWidth = 15;
    private static int powerupHeight = 10;

    private static Color dragonRed = new Color(135, 15, 15);
    private static int wallWidth = 20;
    private static int wallHeight = levelHeight;

    private static int topMargin = 50;
    private static int leftMargin = 0;

    private static int playerSpawnPoint = 350;

    /**
     * @return the playerSpawnPoint
     */
    public static int getPlayerSpawnPoint() {
        return (int) Math.round(0.5 * (screenWidth - levelWidth) + 0.5
                * levelWidth);
    }

    /**
     * Set the left margin.
     * 
     * @param left
     *            what the margin should be.
     */
    public static void setLeftMargin(int left) {
        leftMargin = left;
    }

    /**
     * @return the fps
     */
    public static int getFps() {
        return fps;
    }

    /**
     * @return the screenWidth
     */
    public static int getScreenWidth() {
        return screenWidth;
    }

    /**
     * @return the screenHeight
     */
    public static int getScreenHeight() {
        return screenHeight;
    }

    /**
     * @return the levelWidth
     */
    public static int getLevelWidth() {
        return levelWidth;
    }

    /**
     * @return the levelHeight
     */
    public static int getLevelHeight() {
        return levelHeight;
    }

    /**
     * @return the pauseHeight
     */
    public static int getPauseHeight() {
        return pauseHeight;
    }

    /**
     * @return the playerHeight
     */
    public static int getPlayerHeight() {
        return playerHeight;
    }

    /**
     * @return the playerWidth
     */
    public static int getPlayerWidth() {
        return playerWidth;
    }

    /**
     * @return the playerStepSize
     */
    public static int getPlayerStepSize() {
        return playerStepSize;
    }

    /**
     * @return the playerPowerupStepSize
     */
    public static int getPlayerPowerupStepSize() {
        return playerPowerupStepSize;
    }

    /**
     * @return the bubbleDefaultDiameter
     */
    public static int getBubbleDefaultDiameter() {
        return bubbleDefaultDiameter;
    }

    /**
     * @return the bubbleDefaultX
     */
    public static int getBubbleDefaultX() {
        return bubbleDefaultX;
    }

    /**
     * @return the bubbleDefaultY
     */
    public static int getBubbleDefaultY() {
        return bubbleDefaultY;
    }

    /**
     * @return the lives
     */
    public static int getLives() {
        return lives;
    }

    /**
     * @return the ropeSpeed
     */
    public static int getRopeSpeed() {
        return ropeSpeed;
    }

    /**
     * @return the smallestBubbleSize
     */
    public static int getSmallestBubbleSize() {
        return smallestBubbleSize;
    }

    /**
     * @return the powerupSpeed
     */
    public static int getPowerupSpeed() {
        return powerupSpeed;
    }

    /**
     * @return the powerupChance
     */
    public static int getPowerupChance() {
        return powerupChance;
    }

    /**
     * @return the powerupWidth
     */
    public static int getPowerupWidth() {
        return powerupWidth;
    }

    /**
     * @return the powerupHeight
     */
    public static int getPowerupHeight() {
        return powerupHeight;
    }

    /**
     * @return the dragonRed
     */
    public static Color getDragonRed() {
        return dragonRed;
    }

    /**
     * @return the wallWidth
     */
    public static int getWallWidth() {
        return wallWidth;
    }

    /**
     * @return the wallHeight
     */
    public static int getWallHeight() {
        return wallHeight;
    }

    /**
     * @return the topMargin
     */
    public static int getTopMargin() {
        return topMargin;
    }

    /**
     * @return the leftMargin
     */
    public static int getLeftMargin() {
        return leftMargin;
    }

}
