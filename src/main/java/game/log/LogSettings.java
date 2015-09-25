package game.log;

import game.screens.LogScreen;

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
     * @param logScreen
     *            the logScreen to set
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
    
    public static boolean getActiveLog(){
        return activeLog;
    }

    public static void setActiveLog(boolean bool) {
        activeLog = bool;
        
    }
}
