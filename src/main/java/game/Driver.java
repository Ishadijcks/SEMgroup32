package game;

import game.collisions.Collision;
import game.states.State;

/**
 * Abstract class for the Normal- and SurvivalDriver.
 * 
 * @author Boning
 *
 */
public abstract class Driver {
    public static int totalFrames = 1;
    public static Score score;
    protected static Level curLevel;
    protected static boolean canDrawGame = true;
    protected static boolean iceRope = false;
    protected static Player player;
    protected Collision collisions;
    public static Game game;

    /** 
     * Method to start the game.
     * 
     * @param name
     *            Name that the player entered
     */
    public abstract void startGame(String name);

    /**
     * Set up the game.
     */
    public abstract void setupGame();

    /**
     * Initialise the driver.
     */
    public abstract void initDriver();

    /**
     * Method that will take care of everything that happens in a game session.
     */
    public abstract void driverHeart();

    /**
     * Return the total frames the game is playing.
     * @return the total frames
     */
    public static int getTotalFrames() {
        return totalFrames;
    }

    
    /**
     * Set the total frames the game is playing.
     * @param totalFrames the amount of frames
     */
    public static void setTotalFrames(int totalFrames) {
        Driver.totalFrames = totalFrames;
    }
    
    /**
     * Registers a state to fall back on when the 
     * current state needs to change;
     * @param state
     */
    public void registerListeningState(State state) {
    	this.listeningState = state;
    }

}
