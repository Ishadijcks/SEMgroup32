package game.states;

import game.Driver;
import game.DriverFactory;
import game.MainRunner;
import game.NormalDriverFactory;
import game.Score;
import game.StateManager;
import game.log.LogSettings;
import game.screens.GameScreen;

public class NormalGameState implements State{
	
	private StateManager context;
	private Driver driver;

	public NormalGameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(StateManager context) {
		this.context = context;
        DriverFactory dFactory = new NormalDriverFactory();
        driver = dFactory.buildDriver();
        driver.startGame(MainRunner.getPlayerName());
        MainRunner.setDriver(driver);
        driver.registerListeningState(this);
	}

	@Override
	public void changeContextState(State state) {
		context.newState(state);
	}

}
