package game;

import game.states.State;

public class StateManager {
	
	private State currentState;
	private State prevState = null;

	public StateManager() {
		this.currentState = null;
	}
	
	/**
	 * Sets the state
	 * @param state
	 */
	public void setState(State state) {
		this.prevState = this.currentState;
		this.currentState = state;
	}
	
	/**
	 * Changes state and handles that state
	 * @param state
	 */
	public void newState(State state) {
		this.prevState = this.currentState;
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
	
	public void prevState() {
		this.currentState = this.prevState;
		this.currentState.handleFallBack();
	}

}
