package game.states;

import game.StateManager;
import game.screens.StartScreen;

/**
 * New game state.
 * @author Floris
 *
 */
public class NewGameState implements State {

    private StateManager context;

    @Override
    public void handle(StateManager context) {
        this.context = context;
        new StartScreen();
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
