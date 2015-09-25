package game;

import game.bubble.Bubble;
import game.bubble.Bubblex128;
import game.bubble.Bubblex16;
import game.bubble.Bubblex32;
import game.bubble.Bubblex64;
import game.bubble.Bubblex8;
import game.log.LogSettings;
import game.log.Logger;
import game.screens.GameScreen;
import game.screens.LeaderBoardScreen;
import game.screens.LosingScreen;
import game.screens.StartScreen;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTextField;

/**
 * Class that executes the game.
 * 
 * @author Boning
 *
 */
public class SurvivalDriver extends Driver {

    public static SurvivalGame game;
    private static SurvivalDriver driver;
    private static GameScreen gameScreen;
    private static String name;
    private static Leaderboard lb = new Leaderboard();
    
    private static int allBubbles = 1;
    private static int bubbleNumber = 1;
    private static int spawnTime = 7000;
    private static Bubble bubble1;
    private static Bubble bubble2;
    private static Bubble bubble3;
    private static Bubble bubble4;
    private static Bubble bubble5;

    public SurvivalDriver(String name)
    {
        this.name = name;
    }
    
    /**
     * Frame to start the game.
     */
    public void startGame(String playerName) {
        name = playerName;
        gameScreen.startGame();
        game.gameStart();
    }
    
    /**
     * Give random generated x and y-coordinates for the bubbles.
     * @param bubbleNumber The bubble sort which will be generated.
     */
    public static void randomPlacedBubble(int bubbleNumber) {
        int randX = MathFunctions.randomInt(10, Settings.getLevelWidth() - 10);
        int randY = MathFunctions.randomInt(10, Settings.getLevelHeight() - 200);
        
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
     * Gives the starting frame.
     */
    public void startScreen() {
        try {
            new StartScreen(driver);
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (LineUnavailableException e1) {
            e1.printStackTrace();
        }
        Logger.log("Start screen created", 9, 4);
    }

    /**
     * Check if the game has been lost.
     * @return Gives true if the game has ended, otherwise gives false.
     */
    public static boolean checkGameLost() {
        int livesLeft = game.getLives();
        if (livesLeft == 0 && game.inProgress()) {
            allBubbles = 1;
            bubbleNumber = 1;
            spawnTime = 7000;
            endScore es = new endScore(name , Score.getScore());
            lb.addScore(es);
            lb.appendToFile();
            Score.resetScore();
            gameScreen.dispose();
            game.toggleProgress();
            new LeaderBoardScreen(lb);
            new LosingScreen(driver, es);
            Logger.log("Game lost", 7, 4);
            return true;
        }
        return false;
    }

    /**
     * Setup the beginscreen and handels the actual game.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException,
            UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        try {
            gameScreen = new GameScreen();
        } catch (UnsupportedAudioFileException e) {
            Logger.log("UnsupportedAudioFileException", 7, 2);
            e.printStackTrace();
        } catch (IOException e) {
            Logger.log("IOException", 7, 2);
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            Logger.log("LineUnavailableException", 7, 2);
            e.printStackTrace();
        }
        
        int startTime = (int) System.currentTimeMillis();
        
        Logger.log("Main Frame created", 9, 4);
        driver = new SurvivalDriver(name);
        Player player = new Player(name , 350, false);
        
        game = GameCreator.createSurvival(player);
        score = new Score();
        
        game.addPlayer(player);
        
        player = game.getPlayerList().get(0);
        
        int centerConstant = (int) Math
                .round(0.5 * (Settings.getScreenWidth() - Settings
                        .getLevelWidth()));
        Settings.setLeftMargin(centerConstant);
        GameScreen.setupScreen(game, score);
        
        driver.startScreen();

        LogSettings.setActiveLog(true);

        while (true) {
            if (game.inProgress()) {
                curLevel = game.getCurrentLevel();
                
                int currentTime = (int) System.currentTimeMillis();
                if ((currentTime - startTime) > spawnTime) {
                    spawnTime = spawnTime - 1000;
                    
                    score.addScore(100);
                    
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

                for (int i = 0; i < curLevel.getBubbleList().size(); i++) {
                    Bubble bubble = curLevel.getBubbleList().get(i);
                    bubble.move();
                }

                for (int i = 0; i < curLevel.getPowerupList().size(); i++) {
                    curLevel.getPowerupList().get(i).move();
                    curLevel.checkPowerupCollision();
                }

                if (curLevel.hasRope()) {
                    curLevel.getRope().move();
                }

                curLevel.checkCollisionRope();

                if (curLevel.checkCollisionPlayer()) {
                    game.getPlayerList().get(0).removeAllPowerUps();
                    game.resetLevel();
                }

                int powerupListSize = game.getPlayerList().get(0)
                        .getPowerupList().size();

                if (powerupListSize > 0) {
                    for (int i = 0; i < powerupListSize; i++) {
                        if (game.getPlayerList().get(0).getPowerupList().get(i)
                                .getName().equals("life")) {
                            Powerup life = game.getPlayerList().get(0)
                                    .getPowerupList().get(i);
                            game.getLife();
                            game.getPlayerList().get(0).removePowerUp(life);
                        } else if (game.getPlayerList().get(0).getPowerupList()
                                .get(i).getName().equals("ice")) {
                            iceRope = true;
                            game.getPlayerList().get(0).getPowerupList().get(i)
                                    .decreaseFramesLeft();
                        } else if (game.getPlayerList().get(0).getPowerupList()
                                .get(i).getName().equals("speed")) {
                            game.getPlayerList().get(0).getPowerupList().get(i)
                                    .decreaseFramesLeft();
                        }

                    }
                }
                iceRope = game.getPlayerList().get(0).hasIceRope();

                gameScreen.reload();

                Player player1 = game.getPlayerList().get(0);
                player1.move(curLevel.getWallList());

                checkGameLost();
            }

            // 120 FPS
            Thread.sleep(1000 / Settings.getFps());
            totalFrames++;
            if (LogSettings.isLogScreen() && totalFrames % 500 == 0
                    && game.inProgress()) {
                LogSettings.getLogscreen().reloadData();
            }
        }

    }
    
    
    /**
     * Initialises the game..
     */
    public void initGame() {
        try {
            gameScreen = new GameScreen();
        } catch (UnsupportedAudioFileException e) {
            Logger.log("UnsupportedAudioFileException", 7, 2);
            e.printStackTrace();
        } catch (IOException e) {
            Logger.log("IOException", 7, 2);
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            Logger.log("LineUnavailableException", 7, 2);
            e.printStackTrace();
        }
        Logger.log("Main Frame created", 9, 4);
    }

    /**
     * Set up the game.
     */
    public void setupGame() {
        driver = new SurvivalDriver(name);
        Player player = new Player(name, 350, false);
        game = GameCreator.createSurvival(player);
        score = new Score();
        game.addPlayer(player);
        player = game.getPlayerList().get(0);
        int centerConstant = (int) Math
                .round(0.5 * (Settings.getScreenWidth() - Settings
                        .getLevelWidth()));
        Settings.setLeftMargin(centerConstant);
        GameScreen.setupScreen(game, score);
    }

}