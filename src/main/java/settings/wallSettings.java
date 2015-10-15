package settings;


public class wallSettings {

    private static int wallWidth = 10;
    private static int wallHeight = screenSettings.getLevelHeight();

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
