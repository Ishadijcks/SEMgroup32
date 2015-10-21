package game;

import game.log.LogSettings;
import game.screens.StartScreen;
import settings.ScreenSettings;

/**
 * Class that will execute the whole game.
 * 
 * @author Boning
 *
 */
public class MainRunner {

    private static Driver driver;
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
        new StartScreen();
        while (true) {
            try {
                driver.driverHeart();
            } catch (Exception e) {
            }

            // 120 FPS
            try {
                Thread.sleep(1000 / ScreenSettings.getFps());
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

}
