package game.states;

import game.Driver;
import game.EndScore;
import game.Leaderboard;
import game.MainRunner;
import game.Score;
import game.StateManager;
import game.screens.LeaderBoardScreen;
import game.screens.LosingScreen;

public class LoseSurvivalGameState implements State{
	
	private StateManager context;

	public LoseSurvivalGameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(StateManager context) {
		this.context = context;
        Driver.game.toggleProgress();
	    Leaderboard leaderBoard = new Leaderboard();
        EndScore es = new EndScore(MainRunner.getPlayerName(), Score.getInstance().getScore());
        leaderBoard.addScore(es);
        Leaderboard.appendToFile();
        Score.getInstance().resetScore();
        new LosingScreen(es);
        new LeaderBoardScreen(leaderBoard);
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
