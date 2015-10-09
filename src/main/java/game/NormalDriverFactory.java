/**
 * 
 */
package game;

/**
 * @author floris
 *
 */
public class NormalDriverFactory extends DriverFactory {

	public NormalDriverFactory() {
	}
	
	@Override
	public Driver buildDriver() {
		return new NormalDriver();
	}

}
