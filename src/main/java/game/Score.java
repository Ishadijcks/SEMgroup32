package game;

import game.log.Logger;

/**
 * Score class.
 * 
 * @author Boning
 *
 */
public final class Score {
    private static volatile Score uniqueInstance;
    static int score = 0;

    private Score() {
    }

    /**
     * The constructor checks if only 1 score class is in the game.
     * 
     * @return the unique Instance score class.
     */
    public static synchronized Score getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Score();
        }
        return uniqueInstance;
    }

    /**
     * Increase the score by an amount.
     * 
     * @param add
     *            amount that will be increased
     */
    public static void addScore(int add) {
        score += add;
        Logger.log(score + " points gained. Total score is now " + score, 7, 5);
    }

    /**
     * Add score to the players score.
     * 
     * @return score of the player
     */
    public static int getScore() {
        return score;
    }

    /**
     * Reset the score.
     */
    public static void resetScore() {
        score = 0;
    }
}
