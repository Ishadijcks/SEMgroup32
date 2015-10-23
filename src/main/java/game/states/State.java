package game.states;

import game.StateManager;

public interface State {
	
	public void handle(final StateManager context);
	
	public void changeContextState(State state);
	
}
