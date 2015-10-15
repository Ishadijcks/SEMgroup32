package settings;

import java.awt.Color;

public class playerSettings {

    private static int playerSpawnPoint = 350;
    private static int playerHeight = 161;
    private static int playerWidth = 111;
    private static int playerStepSize = 2;
    private static int playerPowerupStepSize = 5;
    private static boolean playerHasIceRope = false;
    private static boolean restrictMovingRight = false;
    private static boolean restrictMovingLeft = false;
    private static int lives = 5;

    private static Color dragonRed = new Color(135, 15, 15);

    /**
     * @return the playerSpawnPoint
     */
    public static int getPlayerSpawnPoint() {
        return (int) Math.round(0.5
                * (screenSettings.getScreenWidth() - screenSettings
                        .getLevelWidth()) + 0.5
                * screenSettings.getLevelWidth());
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
     * Has IceRope class.
     * 
     * @return true if ice rope is true.
     */
    public static boolean getPlayerHasIceRope() {
        return playerHasIceRope;
    }

    /**
     * Set the players Ice rope.
     * 
     * @param setter
     *            of the rope.
     */
    public static void setPlayerHasIceRope(boolean setter) {
        playerHasIceRope = setter;
    }

    /**
     * @return the restrictMovingRight
     */
    public static boolean isRestrictMovingRight() {
        return restrictMovingRight;
    }

    /**
     * @param restrictMovingRight
     *            the restrictMovingRight to set
     */
    public static void setRestrictMovingRight(boolean restrictMovingRight) {
        playerSettings.restrictMovingRight = restrictMovingRight;
    }

    /**
     * @return the restrictMovingLeft
     */
    public static boolean isRestrictMovingLeft() {
        return restrictMovingLeft;
    }

    /**
     * @param restrictMovingLeft
     *            the restrictMovingLeft to set
     */
    public static void setRestrictMovingLeft(boolean restrictMovingLeft) {
        playerSettings.restrictMovingLeft = restrictMovingLeft;
    }

    /**
     * @return the dragonRed
     */
    public static Color getDragonRed() {
        return dragonRed;
    }

    /**
     * @return the lives
     */
    public static int getLives() {
        return lives;
    }    
    
}
