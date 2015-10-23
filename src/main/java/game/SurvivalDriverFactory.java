package game;

/**
 * Class that will create a SurvivalDriver.
 * @author Floris
 *
 */
public class SurvivalDriverFactory extends DriverFactory {

    /**
     * The constructor of the driver factory for the survival game.
     */
    public SurvivalDriverFactory() {
    }

    /**
     * Builds a survival driver.
     * @return Returns a driver.
     */
    @Override
    public Driver buildDriver() {
        return new SurvivalDriver();
    }

}
