package game;

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
    protected Collisions collisions;
    public static Game game;

    public Driver(){
    	System.setProperty("java.awt.headless", "true");
    }
    /** 
     * Method to start the game.
     * 
     * @param name
     *            Name that the player entered
     */
    public abstract void startGame(String name);

    /**
     * Set up the game.
     * 
     * @param startingLevel begin level number
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

}
