package settings;

/**
 * Settings for the screen class.
 * @author Isha
 *
 */

public class ScreenSettings {

    private static int fps = 120;
    private static int screenWidth = 1000;
    private static int screenHeight = 800;

    private static int levelWidth = 850;
    private static int levelHeight = 500;

    private static int pauseWidth = 350;
    private static int pauseHeight = 250;


    private static int topMargin = 50;
    private static int leftMargin = 0;

    /**
     * Set the left margin of the screen.
     * @param left the left margin
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
     * @return the pauseWidth
     */
    public static int getPauseWidth() {
        return pauseWidth;
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
