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
import game.screens.LogScreen;
import game.screens.LosingScreen;
import game.screens.StartScreen;
import game.screens.WinningScreen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class that executes the game
 * 
 * @author Naomi
 *
 */
@SuppressWarnings("serial")
public class SurvivalDriver extends Driver {

    public static SurvivalGame game;
    private static SurvivalDriver driver;
    private static GameScreen gameScreen;
    
    private static int allBubbles = 1;
    private static int bubbleNumber = 1;
    private static int spawnTime = 7000;
    private static Bubble bubble1;
    private static Bubble bubble2;
    private static Bubble bubble3;
    private static Bubble bubble4;
    private static Bubble bubble5;

    /**
     * Frame to start the game
     */
    public void startGame() {
        gameScreen.startGame();
        game.gameStart();
    }
    
    public static void randomPlacedBubble(int bubbleNumber)
    {
        int randX = MathFunctions.randomInt(10, Settings.getLevelWidth() - 10);
        int randY = MathFunctions.randomInt(10, Settings.getLevelHeight() - 200);;
        
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
     * Check if the game has been lost
     */
    public static boolean checkGameLost() {
        int livesLeft = game.getLives();
        if (livesLeft == 0 && game.inProgress()) {
            allBubbles = 1;
            bubbleNumber = 1;
            spawnTime = 7000;
            gameScreen.dispose();
            game.toggleProgress();
            new LosingScreen(driver, Score.getScore());
            Logger.log("Game lost", 7, 4);
            return true;
        }
        return false;
    }

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
        driver = new SurvivalDriver();
        Player isha = new Player("Isha", 350, false);
        
        game = GameCreator.createSurvival(isha);
        score = new Score();
        
        game.addPlayer(isha);
        
        player = game.getPlayerList().get(0);
        
        int centerConstant = (int) Math
                .round(0.5 * (Settings.getScreenWidth() - Settings
                        .getLevelWidth()));
        Settings.setLeftMargin(centerConstant);
        GameScreen.setupScreen(game, score);
        
        driver.startScreen();

        driver.startScreen();

        LogSettings.setActiveLog(true);

        while (true) {
            if (game.inProgress()) {
                curLevel = game.getCurrentLevel();
                
                int currentTime = (int) System.currentTimeMillis();
                if((currentTime - startTime) > spawnTime)
                {
                    spawnTime = spawnTime - 1000;
                    
                    score.addScore(100);
                    
                    if(allBubbles == 2)
                    {
                        spawnTime = 20000;
                    }
                    
                    if(allBubbles == 3)
                    {
                        spawnTime = 30000;
                    }
                    
                    startTime = (int) System.currentTimeMillis();
                    
                    for(int i = 0; i < allBubbles; i++)
                    {
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
                    
                    if(bubbleNumber == 5)
                    {
                        bubbleNumber = 1;
                        allBubbles++;
                    }
                    else
                    {
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
                player1.move();

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
     * Set up the game
     */
    public void setupGame() {
        driver = new SurvivalDriver();
        Player isha = new Player("Isha", 350, false);
        game = GameCreator.createSurvival(isha);
        score = new Score();
        game.addPlayer(isha);
        player = game.getPlayerList().get(0);
        int centerConstant = (int) Math
                .round(0.5 * (Settings.getScreenWidth() - Settings
                        .getLevelWidth()));
        Settings.setLeftMargin(centerConstant);
        GameScreen.setupScreen(game, score);
    }

}