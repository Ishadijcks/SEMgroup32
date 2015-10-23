package game.states;

import game.Driver;
import game.DriverFactory;
import game.MainRunner;
import game.StateManager;
import game.SurvivalDriverFactory;

public class SurvivalGameState implements State{
	
	private StateManager context;

	public SurvivalGameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(StateManager context) {
		this.context = context;
        DriverFactory dFactory = new SurvivalDriverFactory();
        Driver d = dFactory.buildDriver();
        d.startGame(MainRunner.getPlayerName());
        MainRunner.setDriver(d);
        d.registerListeningState(this);
	}

	@Override
	public void changeContextState(State state) {
		context.newState(state);
	}

}
