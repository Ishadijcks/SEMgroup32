package game;

import game.log.LogSettings;
import game.log.Logger;
import game.screens.GameScreen;
import game.screens.LeaderBoardScreen;
import game.screens.LosingScreen;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Class that executes a survival game.
 * 
 * @author Boning
 *
 */
public class SurvivalDriver extends Driver {

    private static SurvivalDriver driver;
    private static GameScreen gameScreen;
    private static String name;
    private static Leaderboard leaderBoard = new Leaderboard();
    
    private Collisions collisions;

    /** Constructor for a survival driver that will get the name of a player.
     * 
     * @param name Name that the player entered
     */
    public SurvivalDriver(String name) {
        SurvivalDriver.name = name;
        this.collisions = new Collisions();
    }

    /**
     * Frame to start the game.
     * @param playerName string.
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
     */
    public static void gameLost() {
        game.gameLost();
        EndScore es = new EndScore(name, Score.getScore());
        leaderBoard.addScore(es);
        leaderBoard.appendToFile();
        Score.resetScore();
        gameScreen.dispose();
        game.toggleProgress();
        new LeaderBoardScreen(leaderBoard);
        new LosingScreen(driver, es);
    }
    
    /**
     * Initialize the driver.
     */
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
        game = GameFactory.createSurvival(player);
        score = Score.getInstance();
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
            curLevel = game.getCurrentLevel();
        	
	        game.moveEntities();
	        collisions.allCollisions(game);
	
	        gameScreen.reload();

            Player player1 = game.getPlayerList().get(0);
            player1.move();

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
        player = new Player(name, Settings.getPlayerSpawnPoint());
        game = GameFactory.createSurvival(player);
        score = Score.getInstance();
        
        game.addPlayer(player);
        player = game.getPlayerList().get(0);
        int centerConstant = (int) Math
                .round(0.5 * (Settings.getScreenWidth() - Settings
                        .getLevelWidth()));
        Settings.setLeftMargin(centerConstant);
    }
    
    /**
     * initialize the game.
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
     * Method that should make a screen where the player can select different options.
     */
	@Override
	public void startScreen() {
		
	}

}