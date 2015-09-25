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

    private static SurvivalDriver driver;
    private static GameScreen gameScreen;
    private static String name;
    private static Leaderboard lb = new Leaderboard();

    public SurvivalDriver(String name) {
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
     * Check if the game has been lost.
     * 
     * @return Gives true if the game has ended, otherwise gives false.
     */
    public static boolean checkGameLost() {
        int livesLeft = game.getLives();
        if (livesLeft == 0 && game.inProgress()) {
            Logger.log("Game lost", 7, 4);
            return true;
        }
        return false;
    }

    /**
     * Check if the game has been lost.
     * 
     * @return Gives true if the game has ended, otherwise gives false.
     */
    public static void gameLost() {
        game.gameLost();
        endScore es = new endScore(name, Score.getScore());
        lb.addScore(es);
        lb.appendToFile();
        Score.resetScore();
        gameScreen.dispose();
        game.toggleProgress();
        new LeaderBoardScreen(lb);
        new LosingScreen(driver, es);
    }
    
    public void initDriver() {
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
        
        this.startGame(name);
        
        LogSettings.setActiveLog(true);
    }

    /**
     * Setup the beginscreen and handels the actual game.
     * 
     * @param args
     * @throws InterruptedException
     */
    public void driverHeart() {
        if (game.inProgress()) {
            game.update();

            curLevel = game.getCurrentLevel();

            for (int i = 0; i < curLevel.getBubbleList().size(); i++) {
                Bubble bubble = curLevel.getBubbleList().get(i);
                bubble.move();
            }

            for (int i = 0; i < curLevel.getPowerupList().size(); i++) {
                curLevel.getPowerupList().get(i).move();
                curLevel.handlePowerupCollision();
            }

            if (curLevel.hasRope()) {
                curLevel.getRope().move();
            }

            curLevel.handleCollisionRope();

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

            if (checkGameLost()) {
                gameLost();
            }
        }
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

	@Override
	public void startScreen() {
		// TODO Auto-generated method stub
		
	}
}