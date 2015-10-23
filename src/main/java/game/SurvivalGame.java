package game;

import game.bubble.BubbleFactory;
import game.screens.PauseScreen;
import game.states.PauseGameState;

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
     * Ends the game and disposes the screen.
     */
    @Override
    public void endGame() {
        this.setLives(0);
        this.toggleProgress();
    }

    /**
     * Updates the state of a game.
     */
    public void update() {
        SurvivalLevel curLevel = (SurvivalLevel) levelList
                .get(currentLevel - 1);
        int currentTime = (int) System.currentTimeMillis();
        if ((currentTime - startTime) > spawnTime) {

            // score.addScore(100);

            startTime = (int) System.currentTimeMillis();

            curLevel.addBubble(bFac.getRandomPlacedBubble());
        }
    }

    /**
     * Resets the level.
     */
    @Override
    public void resetLevel() {
        //SurvivalDriver.gameLost();
    }
}
