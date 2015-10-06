package game;

public class SurvivalDriverFactory extends DriverFactory {

	public SurvivalDriverFactory() {
	}

	@Override
	public Driver buildDriver() {
		return new SurvivalDriver("");
	}

}
