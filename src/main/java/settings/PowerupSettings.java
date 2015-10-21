package settings;


/**
 * Settings for the powerup class.
 * @author Isha
 *
 */
public class PowerupSettings {

    private static int powerupSpeed = 2;
    private static int powerupChance = 40;
    private static int powerupWidth = 15;
    private static int powerupHeight = 10;

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

}
