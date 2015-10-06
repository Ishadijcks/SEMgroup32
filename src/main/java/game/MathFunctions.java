package game;

import java.util.Random;

/**
 * Class that has all mathematical functions.
 * @author Boning
 *
 */
public class MathFunctions {

    /**
     * Create a random integer.
     * @param min minimal value of the integer
     * @param max maximal value of the integer
     * @return a random integer
     */
    public static int randomInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
