package game;

import game.collisions.Collision;
import game.collisions.CollisionFactory;
import game.log.LogSettings;
import game.log.Logger;
import game.screens.GameScreen;
import game.states.LoseSurvivalGameState;

import java.util.ArrayList;

/**
 * Class that executes a survival game.
 * 
 * @author Boning
 *
 */
public class SurvivalDriver extends Driver {

    private static GameScreen gameScreen;
    private static String name;

    private ArrayList<Collision> collisions;

    /**
     * Constructor for a survival driver that will get the name of a player.
     */
    public SurvivalDriver() {
        setupGame();
        initDriver();
        this.collisions = (new CollisionFactory()).buildAllCollisions();
    }

    /**
     * Frame to start the game.
     * 
     * @param playerName
     *            string.
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
    public void gameLost() {
        gameScreen.dispose();
        listeningState.changeContextState(new LoseSurvivalGameState());
    }

    /**
     * Setup the beginscreen and handels the actual game.
     * 
     */
    public void driverHeart() {
        if (game.inProgress()) {
            curLevel = game.getCurrentLevel();

            game.moveEntities();
            game.update();
            for (Collision col : collisions) {
                col.checkCollision(game);
            }

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
        player = new Player(name, 350);
        game = GameFactory.createSurvival(player);
        score = Score.getInstance();
        game.addPlayer(player);
    }

    /**
     * Initialises the driver.
     */
    public void initDriver() {
        gameScreen = new GameScreen();
        Logger.log("Main Frame created", 9, 4);

        GameScreen.setupScreen(game, score);

        LogSettings.setActiveLog(true);
    }
}