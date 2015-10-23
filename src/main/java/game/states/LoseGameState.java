package game.states;

import game.Driver;
import game.EndScore;
import game.MainRunner;
import game.Score;
import game.StateManager;
import game.log.Logger;
import game.screens.LosingScreen;

public class LoseGameState implements State{
	
	private StateManager context;

	public LoseGameState() {
		
	}

	@Override
	public void handle(StateManager context) {
		System.out.println("YAA");
		this.context = context;
        Driver.game.toggleProgress();
        EndScore es = new EndScore(MainRunner.getPlayerName(), Score.getInstance().getScore());
        Score.getInstance().resetScore();
        new LosingScreen(MainRunner.getDriver(), es);
        Logger.log("Game lost", 7, 4);		
	}

	@Override
	public void changeContextState(State state) {
		context.newState(state);
	}

}
