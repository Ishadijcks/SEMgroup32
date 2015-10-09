package game;

import java.util.Random;

import game.bubble.Bubble;
import game.bubble.BubbleFactory;
import game.bubble.Bubblex128;
import game.bubble.Bubblex16;
import game.bubble.Bubblex32;
import game.bubble.Bubblex64;
import game.bubble.Bubblex8;

/**
 * Class that handles everything of one survival game.
 * 
 * @author Boning
 *
 */
public class SurvivalGame extends Game {
    private static int spawnTime = 7000;;
    private int startTime;
    
    private BubbleFactory bFac = new BubbleFactory();
    
    /**
     * Constructor of a survival game.
     */
    public SurvivalGame() {
        super();
        lives = 1;
        startTime = (int) System.currentTimeMillis();
    }
    
    /**
     * Updates the state of a game.
     */
    public void update() {
        SurvivalLevel curLevel = (SurvivalLevel) levelList.get(currentLevel - 1);
        int currentTime = (int) System.currentTimeMillis();
        if ((currentTime - startTime) > spawnTime) {
        	
            //score.addScore(100);
            
            startTime = (int) System.currentTimeMillis();
            
            curLevel.addBubble(bFac.getRandomPlacedBubble());
        }
    }

    /**
     * Checks if a game is won.
     */
	@Override
	public void gameWon() {
		
	}

	@Override
	public void gameLost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetLevel() {
    	SurvivalDriver.gameLost();
	}
}
