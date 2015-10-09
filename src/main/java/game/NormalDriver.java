package game;

import game.log.LogSettings;
import game.log.Logger;
import game.screens.GameScreen;
import game.screens.LosingScreen;
import game.screens.WinningScreen;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Class that executes the game.
 * 
 * @author Boning
 *
 */
@SuppressWarnings("serial")
public class NormalDriver extends Driver {

    private static String name;
    private static NormalDriver driver;
    private static GameScreen gameScreen;

    private Collisions collisions;

    /**
     * Constructor that will pass the name of the player.
     * 
     * @param name
     *            Name that the player entered
     */
    public NormalDriver(String name) {
        NormalDriver.name = name;
        this.collisions = new Collisions();
    }

    /**
     * Frame to start the game.
     */
    @Override
    public void startGame(String playerName) {
        name = playerName;
        gameScreen.startGame();
        game.gameStart();
    }

    /**
     * Check if the game has been won.
     * 
     * @return true if the game is won, false otherwise
     */
    public static boolean checkGameWon() {
        if (game.getCurrentLevelInt() == game.getLevelList().size() - 1) {
            gameScreen.dispose();
            Logger.log("Frame destroyed", 9, 4);
            new WinningScreen(driver, name);
            return true;
        }
        return false;
    }

    /**
     * Check if the game has been lost.
     * 
     * @return true if the game is lost, false otherwise
     */
    public static boolean checkGameLost() {
        int livesLeft = game.getLives();
        if (livesLeft == 0 && game.inProgress()) {
            gameScreen.dispose();
            game.toggleProgress();
            EndScore es = new EndScore(name, Score.getScore());
            Score.resetScore();
            new LosingScreen(driver, es);
            Logger.log("Game lost", 7, 4);
            return true;
        }
        return false;
    }

    /**
     * Method that will take care of everything that happens in a game session.
     */
    public void driverHeart() {
        
	    if (game.inProgress()) 	{
	        curLevel = game.getCurrentLevel();
	
	        game.moveEntities();
	        collisions.allCollisions(game);
	
	        gameScreen.reload();
	        
	        // It is important that the player moves after all the collisions
	        // are checked. Since the collisions decide if the player can move
	        // one step ahead or not. If the player moves first the collisions
	        // detection will be too late.
	        Player player1 = game.getPlayerList().get(0);
	        player1.move();
	
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
    }

    /**
     * Getter returns game screen.
     * 
     * @return game screen
     */
    public GameScreen getGameScreen() {
        return gameScreen;
    }

    /**
     * Initialise the game.
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
        Player player = new Player(name, 350);
        game = GameFactory.createSinglePlayer(player);

        score = new Score();
        game.addPlayer(player);
        player = game.getPlayerList().get(0);
        int centerConstant = (int) Math
                .round(0.5 * (Settings.getScreenWidth() - Settings
                        .getLevelWidth()));
        Settings.setLeftMargin(centerConstant);
    }

    /**
     * Initialise the driver.
     */
    @Override
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

        Player player = new Player(name, 350);
        game = GameFactory.createSinglePlayer(player);

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
     * Method that should make a screen where the player can select different
     * options.
     */
    @Override
    public void startScreen() {

    }

}