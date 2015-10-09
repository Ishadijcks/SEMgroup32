/**
 * 
 */
package game;

/**
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
     * @return Retruns a driver.
     */
	@Override
	public Driver buildDriver() {
		return new NormalDriver();
	}

}
