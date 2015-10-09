package game;

import java.util.ArrayList;

/**
 * keeps track of the completed levels.
 * @author Tim
 *
 */
public class LevelCompletion {
    static ArrayList<Integer> levelsCompleted = new ArrayList<Integer>();

    /**
     * Add a new completed level.
     * 
     * @param level
     *            number of the level
     */
    public static void setLevelCompleted(int level) {
        if (!levelsCompleted.contains(level)) {
            levelsCompleted.add(level);
        }
    }

    /**
     * Returns true if level is completed.
     * 
     * @param level
     *            the number of the level
     * @return true if completed
     */
    public static boolean isLevelCompleted(int level) {
        return levelsCompleted.contains(level);
    }
}
