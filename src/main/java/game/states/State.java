package game.states;

import game.StateManager;

/**
 * State interface.
 * @author floris
 *
 */
public interface State {
	
	/**
	 * Function that fires when the state is changed.
	 * @param context here: StateManager
	 */
	void handle(final StateManager context);
	
	/**
	 * Changes the state of the context from another
	 * state.
	 * @param state the new state the manager has to set
	 */
	void changeContextState(State state);
	
	/**
	 * When the previous state should be set for
	 * the context then some things must be done
	 * when the old state is added back. But not the
	 * original handle function.
	 */
	void handleFallBack();
	
}
