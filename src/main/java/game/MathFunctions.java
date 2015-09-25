package game;

import java.util.Random;

public class MathFunctions {

    /**
     * Create a random integer
     * 
     * @param min
     * @param max
     * @return a random integer
     */
    public static int randomInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
