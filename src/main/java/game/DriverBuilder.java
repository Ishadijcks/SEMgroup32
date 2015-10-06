package game;

/**
 * Class that will build a driver.
 * @author Boning
 */
public class DriverBuilder {

    /**
     * Constructor of the driver builder class.
     */
	public DriverBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Build the driers.
	 * @param driver 0 for normal driver, 1 for survival driver
	 * @return Driver type, either normal or surivival
	 */
	public static Driver buildDriver(int driver) {
		switch (driver) {
			case 0:
				return new NormalDriver("");
			case 1:
				return new SurvivalDriver("");
			default:
				break;
		}
		return null;
	}

}
