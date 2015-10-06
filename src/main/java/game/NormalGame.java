package game;

import game.log.Logger;

import java.util.ArrayList;

public class NormalGame extends Game {
    
    public NormalGame() {
        super();
    }
    
    /**
     * Function that advances the player to the next level or makes the player
     * win the whole game.
     */
    public void gameWon() {
        if (currentLevel < levelList.size() ) {
            currentLevel++;
            Logger.log("Level completed", 8, 4);
            inProgress = false;
        } else {
            inProgress = false;
        }
    }

	@Override
	public void gameLost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
