package game;

import game.states.State;

/**
 * Statemanager class that manages the states
 * during runtime of the game.
 * @author floris
 *
 */
public class StateManager {
	
	private State currentState;
	private State prevState = null;

	/**
	 * Initialise the statemanager.
	 */
	public StateManager() {
		this.currentState = null;
	}
	
	/**
	 * Sets the state.
	 * @param state that has to be set
	 */
	public void setState(State state) {
		this.prevState = this.currentState;
		this.currentState = state;
	}
	
	/**
	 * Changes state and handles that state.
	 * @param state that has to be set
	 */
	public void newState(State state) {
		this.prevState = this.currentState;
		this.currentState = state;
		currentState.handle(this);
	}
	
	/**
	 * Returns the current state.
	 * @return State
	 */
	public State getState() {
		return this.currentState;
	}
	
	/**
	 * Sets the previous state the 
	 * manager was in.
	 */
	public void prevState() {
		this.currentState = this.prevState;
		this.currentState.handleFallBack();
	}

}
