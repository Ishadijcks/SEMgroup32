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
    @Override
    public void gameWon() {
        if (currentLevel <= levelList.size() + 2) {
            LevelCompletion.setLevelCompleted(currentLevel);
            currentLevel++;
            Logger.log("Level completed", 8, 4);
            inProgress = false;
        } else {
            inProgress = false;
        }
    }
	
	/**
     * Ends the game and disposes the screen.
     */
    public void endGame() {
        this.setLives(0);
        this.toggleProgress();
    }

	/**
     * Updates the state of a game.
     */
	@Override
	public void update() {
		
	}

	/**
	 * Will reset the level.
	 */
	@Override
	public void resetLevel() {
    	NormalLevelFactory nLevelFac = new NormalLevelFactory(playerList);
        levelList.set(currentLevel - 1,
                nLevelFac.getLevel(currentLevel));
    }
}
