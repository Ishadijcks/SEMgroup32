package game;

public class DriverBuilder {

	public DriverBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	public static Driver buildDriver(int driver) {
		switch(driver){
			case 0:
				return new NormalDriver("Ok");
			case 1:
				System.out.println("OKOKOK");
				return new SurvivalDriver("");
		}
		return null;
	}

}
