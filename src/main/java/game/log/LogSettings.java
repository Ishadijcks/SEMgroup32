package game.log;

import game.screens.LogScreen;

/**
 * Class that keep all settings for the logger.
 * @author Boning
 *
 */
public class LogSettings {
    static boolean logScreen = false;
    static int severityMin = 6;
    static LogScreen logscreen;
    static boolean activeLog = false;

    /**
     * @return the logScreen
     */
    public static boolean isLogScreen() {
        return logScreen;
    }

    /**
     * @param logScreenInput the logScreen to set
     */
    public static void setLogScreen(boolean logScreenInput) {
        logScreen = logScreenInput;
    }

    /**
     * @return the logscreen
     */
    public static LogScreen getLogscreen() {
        return logscreen;
    }

    /**
     * @param logscreen the logscreen to set
     */
    public static void setLogscreen(LogScreen logscreen) {
        LogSettings.logscreen = logscreen;
    }
    
    /**
     * Getter for the active log.
     * @return the active log
     */
    public static boolean getActiveLog() {
        return activeLog;
    }

    /**
     * Setter for the active log.
     * @param bool true if the log is active, false otherwise
     */
    public static void setActiveLog(boolean bool) {
        activeLog = bool;
        
    }
}
