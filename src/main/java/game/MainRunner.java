package game;

import game.log.LogSettings;
import game.screens.StartScreen;

/**
 * Class that will execute the whole game.
 * 
 * @author Boning
 *
 */
public class MainRunner {

    private static Driver driver;
    private static boolean driverIsSet;
    private final static int GAME_FPS = 120;

    /**
     * Constructor of the main runner class.
     */
    public MainRunner() {
        driverIsSet = false;
    }

    /**
     * main method will be executed.
     * 
     * @param args
     *            standard java thingie
     */
    public static void main(String[] args) {
        driverIsSet = false;
        new StartScreen();
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
            driver.totalFrames++;
            if (LogSettings.isLogScreen() && driver.totalFrames % 500 == 0
                    && driver.game.inProgress()) {
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
        driverIsSet = true;
    }

}
