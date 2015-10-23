package game;

import game.states.State;

public class StateManager {
	
	private State currentState;

	public StateManager() {
		this.currentState = null;
	}
	
	/**
	 * Sets the state
	 * @param state
	 */
	public void setState(State state) {
		this.currentState = state;
	}
	
	/**
	 * Changes state and handles that state
	 * @param state
	 */
	public void newState(State state) {
		this.currentState = state;
		currentState.handle(this);
	}
	
	/**
	 * Returns the current state
	 * @return
	 */
	public State getState() {
		return this.currentState;
	}

}
