package game.states;

import game.StateManager;

public class PauseGameState implements State{
	
	private StateManager context;

	public PauseGameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(StateManager context) {
		this.context = context;
	}

	@Override
	public void changeContextState(State state) {
		context.newState(state);
	}

}
