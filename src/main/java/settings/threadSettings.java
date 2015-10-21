package settings;


/**
 * Settings for the threads.
 * @author Isha
 *
 */

public class ThreadSettings {

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
        ThreadSettings.dieThreads = dieThreads;
    }

}
