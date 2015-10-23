package game.states;

import game.StateManager;
import game.screens.StartScreen;

public class NewGameState implements State{
	
	private StateManager context;

	public NewGameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(StateManager context) {
		this.context = context;
        new StartScreen();
	}

	@Override
	public void changeContextState(State state) {
		context.newState(state);
	}

}
