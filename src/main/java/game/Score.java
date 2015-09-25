package game;

import game.log.Logger;

public class Score {
    static int score;

    public Score() {
        score = 0;
    }

    public static void addScore(int add) {
        score += add;
        Logger.log(score + " points gained. Total score is now " + score, 7, 5);
    }

    /**
     * Add score to the players score
     */
    public static int getScore() {
        return score;
    }
    
    public static void resetScore()
    {
        score = 0;
    }
}
