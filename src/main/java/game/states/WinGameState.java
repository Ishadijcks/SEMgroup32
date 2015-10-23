package game.states;

import game.MainRunner;
import game.StateManager;
import game.log.Logger;
import game.screens.WinningScreen;

public class WinGameState implements State{

	private StateManager context;
	
	public WinGameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(StateManager context) {
		this.context = context;
        Logger.log("Frame destroyed", 9, 4);
        new WinningScreen(MainRunner.getDriver());
	}

	@Override
	public void changeContextState(State state) {
		context.newState(state);
	}

}
