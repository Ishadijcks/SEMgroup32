package game.states;

import game.Driver;
import game.DriverFactory;
import game.MainRunner;
import game.NormalDriverFactory;
import game.StateManager;

/**
 * The state the game is in when the player
 * chooses to play a normal game.
 * @author floris
 *
 */
public class NormalGameState implements State {
	
	private StateManager context;
	private Driver driver;

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

	@Override
	public void handleFallBack() {
		MainRunner.getDriver();
        Driver.game.toggleProgress();
	}

}
