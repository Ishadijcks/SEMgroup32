package game.powerups;


/**
 * Class that keeps all the settings of the whole game.
 * 
 * @author Boning
 *
 */
public class PowerupThreadKiller {

    private static boolean dieThreads = false;

    /**
     * Set the left margin.
     * 
     * @param left
     *            what the margin should be.
     */

    /**
     * @return the dieThreads
     */
    public static boolean getDieThreads() {
        return dieThreads;
    }

    /**
     * @param dieThreads
     *            the dieThreads to set
     */
    public static void setDieThreads(boolean dieThreads) {
        PowerupThreadKiller.dieThreads = dieThreads;
    }

}
