package game;

import java.awt.Color;

public class Settings {

    private static int fps = 120;
    private static int screenWidth = 1000;
    private static int screenHeight = 800;

    private static int levelWidth = 850;
    private static int levelHeight = 500;

    private static int playerHeight = 161;
    private static int playerWidth = 111;
    private static int playerStepSize = 2;
    private static int playerPowerupStepSize = 3;

    private static int bubbleDefaultDiameter = 16;
    private static int bubbleDefaultX = 10;
    

    private static int bubbleDefaultY = 10;

    private static int lives = 5;

    private static int ropeSpeed = 4;

    private static int smallestBubbleSize = 5;
    
    private static int powerupSpeed = 2;
    private static int powerupChance = 10;
    private static int powerupWidth = 15;
    private static int powerupHeight = 10;

    private static Color dragonRed = new Color(135, 15, 15);
    


    private static int topMargin = 50;
    private static int leftMargin = 0;

    public static void setLeftMargin(int left ) {
        leftMargin = left;
    }

    public static int getLeftMargin() {
        return leftMargin;
    }


    public static int getFps() {
        return fps;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    public static int getLevelWidth() {
        return levelWidth;
    }

    public static int getLevelHeight() {
        return levelHeight;
    }

    public static int getPlayerHeight() {
        return playerHeight;
    }

    public static int getPlayerWidth() {
        return playerWidth;
    }

    public static int getPlayerStepSize() {
        return playerStepSize;
    }

    public static int getPlayerPowerupStepSize() {
        return playerPowerupStepSize;
    }

    public static int getLives() {
        return lives;
    }

    public static int getRopeSpeed() {
        return ropeSpeed;
    }

    public static int getSmallestBubbleSize() {
        return smallestBubbleSize;
    }

    public static int getTopMargin() {
        return topMargin;
    }

    public static int getPowerupSpeed() {
        return powerupSpeed;
    }

    public static int getPowerupChance() {
        return powerupChance;
    }

    public static int getPowerupWidth() {
        return powerupWidth;
    }

    public static int getPowerupHeight() {
        return powerupHeight;
    }


    public static Color getDragonRed(){
        return dragonRed;
    }
    
    public static int getBubbleDefaultDiameter() {
        return bubbleDefaultDiameter;
    }

    public static int getBubbleDefaultX() {
        return bubbleDefaultX;
    }

    public static int getBubbleDefaultY() {
        return bubbleDefaultY;
    }
    

}
