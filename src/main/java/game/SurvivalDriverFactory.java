package game;

/**
 * 
 * @author Floris
 *
 */
public class SurvivalDriverFactory extends DriverFactory {

    /**
     * The constructor of the driver factory for the survival game.
     */
    public SurvivalDriverFactory() {
    }

    @Override
    public Driver buildDriver() {
        return new SurvivalDriver();
    }

}
