package game;

import game.log.Logger;

/**
 * Score class.
 * @author Boning
 *
 */
public class Score {
    static int score;

    /**
     * Constructor of the score class.
     */
    public Score() {
        score = 0;
    }

    /**
     * Increase the score by an amount.
     * @param add amount that will be increased
     */
    public static void addScore(int add) {
        score += add;
        Logger.log(score + " points gained. Total score is now " + score, 7, 5);
    }

    /**
     * Add score to the players score.
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
