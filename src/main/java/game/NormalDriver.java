package game;

import game.bubble.Bubble;
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
public class NormalDriver extends Driver {

    public static NormalGame game;
    private static NormalDriver driver;
    private static GameScreen gameScreen;


    /**
     * Frame to start the game
     */
    public void startGame() {
        gameScreen.startGame();
        game.gameStart();
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
     * Check if the game has been won
     */
    public static boolean checkGameWon() {
        if (game.getCurrentLevelInt() == 4) {
            gameScreen.dispose();
            Logger.log("Frame destroyed", 9, 4);
            new WinningScreen(driver);
            return true;
        }
        return false;
    }

    /**
     * Check if the game has been lost
     */
    public static boolean checkGameLost() {
        int livesLeft = game.getLives();
        if (livesLeft == 0 && game.inProgress()) {
            gameScreen.dispose();
            game.toggleProgress();
            new LosingScreen(driver);
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
        Logger.log("Main Frame created", 9, 4);
        driver = new NormalDriver();
        Player isha = new Player("Isha", 100);
        game = GameCreator.createSinglePlayer(isha);
        score = new Score();
        game.addPlayer(isha);
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

                curLevel.moveBubbles();

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

                if (curLevel.getBubbleList().size() == 0) {
                    boolean once = true;
                    if (once) {
                        once = false;
                        canDrawGame = false;
                        gameScreen.levelWon();
                    }
                    game.gameWon();
                }
                checkGameLost();
                checkGameWon();
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
     * initialize game.
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
        driver = new NormalDriver();
        Player isha = new Player("Isha", 100);
        game = GameCreator.createSinglePlayer(isha);
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