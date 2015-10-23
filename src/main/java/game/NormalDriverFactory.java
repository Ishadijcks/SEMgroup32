/**
 * 
 */
package game;

/**
 * Class that will make a NormalDriver object.
 * @author floris
 *
 */
public class NormalDriverFactory extends DriverFactory {

    /**
     * Constructor for the NormalDriverFactory.
     */
	public NormalDriverFactory() {
	}
	
	/**
     * Builds a normal driver.
     * @return Returns a driver.
     */
	@Override
	public Driver buildDriver() {
		return new NormalDriver();
	}

}
