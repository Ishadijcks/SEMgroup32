package game;

import game.log.Logger;

/**
 * Class that will handle a normal game session.
 * @author Boning
 *
 */
public class NormalGame extends Game {
    
    /**
     * Constructor for a normal game.
     */
    public NormalGame() {
        super();
    }
    
    /**
     * Function that advances the player to the next level or makes the player
     * win the whole game.
     */
    public void gameWon() {
        if (currentLevel < levelList.size()) {
            currentLevel++;
            Logger.log("Level completed", 8, 4);
            inProgress = false;
        } else {
            inProgress = false;
        }
    }

    /**
     * Checks if a game is lost.
     */
	@Override
	public void gameLost() {
		
	}

	/**
     * Updates the state of a game.
     */
	@Override
	public void update() {
		
	}
}
