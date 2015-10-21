package game;

import game.collisions.Collision;
import game.collisions.CollisionFactory;
import game.log.LogSettings;
import game.log.Logger;
import game.screens.GameScreen;
import game.screens.LosingScreen;
import game.screens.WinningScreen;

import java.util.ArrayList;

import settings.PlayerSettings;
import settings.ScreenSettings;

/**
 * Class that executes the game.
 * 
 * @author Boning
 *
 */

public class NormalDriver extends Driver {

    private static String name;
    private static NormalDriver driver;
    private static GameScreen gameScreen;
    private ArrayList<Collision> collisions;

    /**
     * Constructor that will pass the name of the player.
     */
    public NormalDriver() {
        setupGame();
        initDriver();
        this.collisions = (new CollisionFactory()).buildAllCollisions();
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
            new WinningScreen(driver);
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
            EndScore es = new EndScore(name, score.getScore());
            score.resetScore();
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
        if (game.inProgress()) {
            curLevel = game.getCurrentLevel();

            game.moveEntities();
            for (Collision col : collisions) {
            	col.checkCollision(game);
            }

            gameScreen.reload();

            Player player1 = game.getPlayerList().get(0);
            player1.move();

            if (curLevel.getBubbleList().size() == 0) {
                canDrawGame = false;
                gameScreen.levelWon();
                game.gameWon();
            }
            checkGameLost();
            checkGameWon();
        }
    }

    /**
     * Set up the game.
     */
    public void setupGame() {
        Player player = new Player(name, PlayerSettings.getPlayerSpawnPoint());
        game = GameFactory.createSinglePlayer(player);
        
        score = Score.getInstance();
        game.addPlayer(player);

        int centerConstant = (int) Math
                .round(0.5 * (ScreenSettings.getScreenWidth() - ScreenSettings
                        .getLevelWidth()));
        ScreenSettings.setLeftMargin(centerConstant);
    }

    /**
     * Initialize the driver.
     */
    @Override
    public void initDriver() {
        gameScreen = new GameScreen();
        Logger.log("Main Frame created", 9, 4);
        GameScreen.setupScreen(game, score);
        LogSettings.setActiveLog(true);

    }

}