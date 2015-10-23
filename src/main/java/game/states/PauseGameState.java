package game.states;

import game.Driver;
import game.StateManager;
import game.screens.PauseScreen;

public class PauseGameState implements State{
	
	private StateManager context;

	public PauseGameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(StateManager context) {
		this.context = context;
        new PauseScreen(Driver.game.getPlayerList().get(0).getName(), Driver.game);
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
