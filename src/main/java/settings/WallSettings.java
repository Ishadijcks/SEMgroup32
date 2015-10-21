package settings;

/**
 * Settings for the wall class.
 * @author Isha
 *
 */

public class WallSettings {

    private static int wallWidth = 10;
    private static int wallHeight = ScreenSettings.getLevelHeight();

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

}
