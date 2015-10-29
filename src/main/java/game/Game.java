package game;

import game.log.Logger;
import game.states.PauseGameState;

import java.util.ArrayList;

/**
 * Class that will handle everything of 1 game session.
 * 
 * @author Boning
 *
 */
public abstract class Game {
    protected ArrayList<Level> levelList = new ArrayList<Level>();
    protected ArrayList<Player> playerList;
    protected int lives = 5;
    protected int currentLevel = 9;
    protected boolean inProgress;

    /**
     * Constructor that will initialize a player list.
     */
    public Game() {
        this.inProgress = false;
        this.playerList = new ArrayList<Player>();
        Logger.log("Game object created", 7, 5);
    }

    /**
     * Returns the levelList.
     * 
     * @return the levelList (ArrayList)
     */
    public ArrayList<Level> getLevelList() {
        return levelList;
    }

    /**
     * 
     * @param levels
     *            List of all levels
     */
    public void setLevelList(ArrayList<Level> levels) {
        levelList = levels;
    }

    /**
     * Adds a level to the levelList.
     * 
     * @param level
     *            level to add
     */
    public void addLevel(Level level) {
        if (!levelList.contains(level)) {
            levelList.add(level);
        }
        Logger.log("Level added to the game", 7, 4);
    }

    /**
     * If the game is paused, start the game.
     */
    public void gameStart() {
        if (!this.inProgress) {
            this.inProgress = true;
            Logger.log("Game started", 7, 4);
        }
    }

    /**
     * Add a player to the playerList.
     * 
     * @param player
     *            player to add
     */
    public void addPlayer(Player player) {
        if (!playerList.contains(player)) {
            playerList.add(player);
        }
        Logger.log("Player " + player.getName() + " added to the game", 1, 4);
    }

    /**
     * Move entities in the level.
     */
    public void moveEntities() {
        Level currentLevel = this.getCurrentLevel();

        currentLevel.moveBubbles();
        for (int i = 0; i < currentLevel.getPowerupList().size(); i++) {
            currentLevel.getPowerupList().get(i).move();
        }
        if (currentLevel.hasRope()) {
            currentLevel.getRope().move();
        }
        for (int a = 0; a < currentLevel.getWallList().size(); a++) {
            currentLevel.getWallList().get(a).move();
        }
    }

    /**
     * Returns the currentLevel.
     * 
     * @return the current level
     */
    public Level getCurrentLevel() {
        return levelList.get(currentLevel - 1);
    }

    /**
     * Returns the currentLevel as an integer.
     * 
     * @return the current level as an integer
     */
    public int getCurrentLevelInt() {
        return currentLevel;
    }

    /**
     * Setter for the currentLevel.
     * 
     * @param currentLevel
     *            the currentLevel to set
     */
    public void setCurrentLevelInt(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Get the lives of the player.
     * 
     * @return the lives of the player
     */
    public int getLives() {
        return lives;
    }

    /**
     * Setter for the amount of lives.
     * 
     * @param lives
     *            the lives to set
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Create an array with the players.
     * 
     * @return the playerlist
     */
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Reset the level if you lose a life.
     */
    public abstract void resetLevel();

    /**
     * Ends the game and disposes the screen.
     */
    public void endGame() {

    }

    /**
     * Method to control losing a life.
     */
    public void loseLife() {
        lives--;
        if (lives < 0) {
            lives = 0;
        }
    }

    /**
     * Method to control getting a life (thanks to powerups e.g.).
     */
    public void getLife() {
        lives++;
    }

    /**
     * Method to show that the game is in progress.
     * 
     * @return a boolean that is true if the game is in progress.
     */
    public boolean inProgress() {
        return this.inProgress;
    }

    /**
     * Method to toggle the inProgress of the game.
     */
    public void toggleProgress() {
        inProgress = !inProgress;
    }

    /**
     * Updates the state of a game.
     */
    public abstract void update();

    /**
     * Game is paused.
     */
    public void pauseGame() {
    	toggleProgress();
        MainRunner.getStateManager().newState(new PauseGameState());
    }

    /**
     * Checks if a game is won.
     */
    public void gameWon() {

    }

    /**
     * Generated equals method to check if all attributes equals another of the
     * same class.
     * 
     * @param obj
     *            Object that it will compare to
     * @return true if the object is from the same type and has the same
     *         attributes
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Game other = (Game) obj;
        if (currentLevel != other.currentLevel) {
            return false;
        }
        if (inProgress != other.inProgress) {
            return false;
        }
        if (!levelList.equals(other.levelList)) {
            return false;
        }
        if (lives != other.lives) {
            return false;
        }
        if (!playerList.equals(other.playerList)) {
            return false;
        }
        return true;
    }
}
