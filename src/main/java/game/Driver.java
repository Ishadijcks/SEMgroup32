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
 * @author Naomi
 *
 */
@SuppressWarnings("serial")
public class Driver extends JPanel {

    public static int totalFrames = 1;
    public static Game game;
    private static Level curLevel;
    private static Driver driver;
    private static boolean canDrawGame = true;
    private static GameScreen gameScreen;
    private static boolean iceRope = false;
    private static Player player;

    /**
     * Show a frame when the level is won
     */
    public void levelWonFrame() {
        if (game.getCurrentLevel().equals(
                game.getLevelList().get(game.getLevelList().size() - 1))) {
            JLabel label = new JLabel("test");
            label.setText("Congratulations! Game won!");
            add(label);
        } else {
            System.out.println("level finished");
            gameScreen.levelWon();
        }
        validate();
    }

    /**
     * Frame to start the game
     */
    public void startGame() {
        gameScreen.startGame();
        game.gameStart();
    }

    /**
     * Add a start button to the screen
     */
    public void addStartButton() {
        final JButton nextLevel = new JButton("Start game");
        nextLevel.setVerticalTextPosition(AbstractButton.BOTTOM);
        nextLevel.setHorizontalTextPosition(AbstractButton.CENTER);
        nextLevel.setMnemonic(KeyEvent.VK_M);
        nextLevel.setFocusable(false);
        nextLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                canDrawGame = true;
                game.gameStart();
                remove(nextLevel);
            }
        });
        add(nextLevel);
        validate();
        Logger.log("Start button added", 9, 4);
    }

    /**
     * Check if the game has been won
     */
    public static boolean checkGameWon(){
        int levelNumbers = game.getLevelList().size();
        if(game.getCurrentLevelInt() == 4)
        {
            System.out.println("won..");
            gameScreen.dispose();
            Logger.log("Frame destroyed",9 ,4);
            System.out.println("won..");
            new WinningScreen(driver);
            return true;
        }
        return false;
    }
    
    /**
     * Check if the game has been lost
     */
    public static boolean checkGameLost(){
        int livesLeft = game.getLives();
        if(livesLeft == 0 && game.inProgress())
        {
            gameScreen.dispose();
            game.toggleProgress();
            new LosingScreen(driver);
            Logger.log("Game lost", 7, 4);
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException{
        initGame();
        setupGame();
        startScreen();

        LogSettings.setActiveLog(true);
        
        while (true) {
            if (game.inProgress()) {
                curLevel = game.getCurrentLevel();

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
                
                int powerupListSize = game.getPlayerList().get(0).getPowerupList().size();
                
                if (powerupListSize > 0) {
                    for(int i = 0; i < powerupListSize; i++)
                    {
                        if (game.getPlayerList().get(0).getPowerupList().get(i).getName()
                                .equals("life")) {
                            Powerup life = game.getPlayerList().get(0).getPowerupList().get(i);
                            game.getLife();
                            game.getPlayerList().get(0).removePowerUp(life);
                        }
                        else if (game.getPlayerList().get(0).getPowerupList().get(i).getName()
                                .equals("ice")) {
                            iceRope = true;
                            game.getPlayerList().get(0).getPowerupList().get(i).decreaseFramesLeft();
                        }
                        else if (game.getPlayerList().get(0).getPowerupList().get(i).getName()
                                .equals("speed")) {
                            game.getPlayerList().get(0).getPowerupList().get(i).decreaseFramesLeft();
                        }
                        
                    }
                }
                iceRope = game.getPlayerList().get(0).hasIceRope();

                gameScreen.reload();

                Player player1 = game.getPlayerList().get(0);
                player1.move();

                if (curLevel.getBubbleList().size() == 0) {
                    boolean once = true;
                    if (once) {
                        once = false;
                        canDrawGame = false;
                        driver.levelWonFrame();
                    }
                    game.gameWon();
                }
                checkGameLost();
                checkGameWon();
            }

            // 120 FPS
            Thread.sleep(1000 / Settings.getFps());
            totalFrames++;
            if( LogSettings.isLogScreen() && totalFrames % 500 == 0 && game.inProgress()){
                LogSettings.getLogscreen().reloadData();
            }
        }

    }

    public static void initGame(){
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
       Logger.log("Main Frame created",9,4);
    }
    
    /**
     * Set up the game
     */
    public static void setupGame(){
       
        driver = new Driver();

        URL location = StartScreen.class.getProtectionDomain().getCodeSource().getLocation();
        String currentLocation = location.getFile();   

        Player isha = new Player("Isha", 350);
        Player tim = new Player("Tim", 80);

        game = GameCreator.createSinglePlayer(isha);

        game.addPlayer(isha);

        player = game.getPlayerList().get(0);

        int centerConstant = (int) Math
                .round(0.5 * (Settings.getScreenWidth() - Settings
                        .getLevelWidth()));
        Settings.setLeftMargin(centerConstant);

        GameScreen.setupScreen(game);
    }
    
    /**
     * Catching exceptions of the startscreen.
     */
    public static void startScreen(){
        try {
            new StartScreen(driver);
        } catch (UnsupportedAudioFileException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (LineUnavailableException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Logger.log("Start screen created", 9, 4);
    }

}