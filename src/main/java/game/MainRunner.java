package game;

import game.log.LogSettings;
import game.states.NewGameState;

/**
 * Class that will execute the whole game.
 * 
 * @author Boning
 *
 */
public class MainRunner {

    private static Driver driver;
    private static final int GAME_FPS = 120;
    private static StateManager stateMan;
    private static String playerName;

    /**
     * Constructor of the main runner class.
     */
    public MainRunner() {
    }

    /**
     * main method will be executed.
     * 
     * @param args
     *            standard java thingie
     */
    public static void main(String[] args) {
        stateMan = new StateManager();
        stateMan.newState(new NewGameState());
        while (true) {
            try {
                driver.driverHeart();
            } catch (Exception e) {
            }

            // 120 FPS
            try {
                Thread.sleep(1000 / GAME_FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Driver.totalFrames++;
            if (LogSettings.isLogScreen() && Driver.totalFrames % 500 == 0
                    && Driver.game.inProgress()) {
                LogSettings.getLogscreen().reloadData();
            }
        }

    }

    /**
     * Set the normal or survival driver as a game.
     * 
     * @param buildDriver
     *            driver that will be used to build a game
     */
    public static void setDriver(Driver buildDriver) {
        driver = buildDriver;
    }

    /**
     * Returns the current driver.
     * 
     * @return Driver driver
     */
    public static Driver getDriver() {
        return driver;
    }

    /**
     * Get the stateManager from the main runner.
     * 
     * @return the state manager
     */
    public static StateManager getStateManager() {
        return stateMan;
    }
    
    /**
     * Sets the statemanager for the mainrunner class.
     * @param stateman that has to be set.
     */
    public static void setStateManager(StateManager stateman) {
    	stateMan = stateman;
    }

    /**
     * Sets the name of the player.
     * 
     * @param name of the player
     */
    public static void setPlayerName(String name) {
        playerName = name;
    }

    /**
     * Returns the name of the player.
     * 
     * @return player name.
     */
    public static String getPlayerName() {
        return playerName;
    }

}
