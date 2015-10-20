package game;

import game.collisions.Collision;
import game.collisions.CollisionFactory;
import game.log.LogSettings;
import game.log.Logger;
import game.screens.GameScreen;
import game.screens.LeaderBoardScreen;
import game.screens.LosingScreen;

import java.util.ArrayList;

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

    private ArrayList<Collision> collisions;

    /**
     * Constructor for a survival driver that will get the name of a player.
     * 
     * @param name
     *            Name that the player entered
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
    public static void gameLost() {
        EndScore es = new EndScore(name, score.getScore());
        leaderBoard.addScore(es);
        leaderBoard.appendToFile();
        score.resetScore();
        gameScreen.dispose();
        game.toggleProgress();
        new LeaderBoardScreen(leaderBoard);
        new LosingScreen(driver, es);
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
            game.update();
            for(Collision col : collisions){
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
        driver = this;
        player = new Player(name, 350);
        game = GameFactory.createSurvival(player);
        score = Score.getInstance();
        game.addPlayer(player);

        int centerConstant = (int) Math
                .round(0.5 * (1000 - 850));
    }

    /**
     * init the driver.
     */
    public void initDriver() {
        gameScreen = new GameScreen();
        Logger.log("Main Frame created", 9, 4);

        GameScreen.setupScreen(game, score);

        LogSettings.setActiveLog(true);
    }
}