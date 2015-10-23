package game;

import game.bubble.BubbleFactory;
import game.screens.PauseScreen;

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
     * Game is paused.
     */
    @Override
    public void pauseGame() {
        super.toggleProgress();
        new PauseScreen(super.getPlayerList().get(0).getName(), this);
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

    @Override
    public void resetLevel() {
        //SurvivalDriver.gameLost();
    }
}
