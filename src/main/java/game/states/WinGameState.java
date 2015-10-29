package game.states;

import game.StateManager;
import game.log.Logger;
import game.screens.WinningScreen;

/**
 * The state the game is in when the game is won.
 * @author floris
 *
 */
public class WinGameState implements State {

	private StateManager context;

	@Override
	public void handle(StateManager context) {
		this.context = context;
        Logger.log("Frame destroyed", 9, 4);
        new WinningScreen();
	}

	@Override
	public void changeContextState(State state) {
		context.newState(state);
	}

	@Override
	public void handleFallBack() {
		// TODO Auto-generated method stub
		
	}

}
