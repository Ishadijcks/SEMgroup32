package game;

import java.util.Random;

import game.bubble.Bubble;
import game.bubble.Bubblex128;
import game.bubble.Bubblex16;
import game.bubble.Bubblex32;
import game.bubble.Bubblex64;
import game.bubble.Bubblex8;
import game.screens.PauseScreen;

/**
 * Class that handles everything of one survival game.
 * 
 * @author Boning
 *
 */
public class SurvivalGame extends Game {
    private static int spawnTime = 7000;
    private static int allBubbles = 1;
    private static int bubbleNumber = 1;
    private int startTime;
    private static Bubble bubble1;
    private static Bubble bubble2;
    private static Bubble bubble3;
    private static Bubble bubble4;
    private static Bubble bubble5;
    
    /**
     * Constructor of a survival game.
     */
    public SurvivalGame() {
        super();
        lives = 1;
        startTime = (int) System.currentTimeMillis();
    }
    
    /**
     * Give random generated x and y-coordinates for the bubbles.
     * @param bubbleNumber The bubble sort which will be generated.
     */
    public static void randomPlacedBubble(int bubbleNumber) {
        Random rand = new Random();
        int randX = rand.nextInt(((Settings.getLevelWidth() - 10) - 10) + 1) + 10; 
        int randY = rand.nextInt(((Settings.getLevelHeight() - 200) - 10) + 1) + 10;
        
        switch (bubbleNumber) {
        case 1:
            bubble1 = new Bubblex8(randX, randY, false, false);
            break;
        case 2:
            bubble2 = new Bubblex16(randX, randY, false, false);
            break;
        case 3:
            bubble3 = new Bubblex32(randX, randY, false, false);
            break;
        case 4:
            bubble4 = new Bubblex64(randX, randY, false, false);
            break;
        case 5:
            bubble5 = new Bubblex128(randX, randY, false, false);
            break;
        default:
            bubble1 = new Bubblex8(randX, randY, false, false);
            break;
        }
    }

    /**
     * Checks if a game is lost.
     */
    public void gameLost() {

        allBubbles = 1;
        bubbleNumber = 1;
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
        SurvivalLevel curLevel = (SurvivalLevel) levelList.get(currentLevel - 1);
        int currentTime = (int) System.currentTimeMillis();
        if ((currentTime - startTime) > spawnTime) {
            spawnTime = spawnTime - 1000;
            
            //score.addScore(100);
            
            if (allBubbles == 2) {
                spawnTime = 20000;
            }
            
            if (allBubbles == 3) {
                spawnTime = 30000;
            }
            
            startTime = (int) System.currentTimeMillis();
            
            for (int i = 0; i < allBubbles; i++) {
                randomPlacedBubble(bubbleNumber);
                switch (bubbleNumber) {
                case 1:
                    curLevel.addBubble(bubble1);
                    break;
                case 2:
                    curLevel.addBubble(bubble2);
                    break;
                case 3:
                    curLevel.addBubble(bubble3);
                    break;
                case 4:
                    curLevel.addBubble(bubble4);
                    break;
                case 5:
                    curLevel.addBubble(bubble5);
                    break;
                default:
                    curLevel.addBubble(bubble1);
                    break;
                }
            }
            
            if (bubbleNumber == 5) {
                bubbleNumber = 1;
                allBubbles++;
            }
            else {
                bubbleNumber++;
            }
            
        }
    }

    /**
     * Checks if a game is won.
     */
	@Override
	public void gameWon() {
		
	}
}
