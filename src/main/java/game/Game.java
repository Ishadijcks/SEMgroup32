package game;

import java.util.ArrayList;

public class Game {
    private ArrayList<Level> levelList = new ArrayList<Level>();
    private ArrayList<Player> playerList;
    private int lives = Settings.getLives();
    private int currentLevel = 1;
    private boolean inProgress;
    int score;

    public Game() {
        this.inProgress = false;
        this.playerList = new ArrayList<Player>();
    }

    /**
     * Returns the levelList
     * 
     * @return the levelList (ArrayList)
     */
    public ArrayList<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(ArrayList<Level> levels) {
        levelList = levels;
    }

    /**
     * Adds a level to the levelList
     * 
     * @param level
     *            level to add
     */
    public void addLevel(Level level) {
        if (!levelList.contains(level)) {
            levelList.add(level);
        }
    }

    /**
     * If the game is paused, start the game
     */
    public void gameStart() {
        if (!this.inProgress)
            this.inProgress = true;
    }

    /**
     * Function that advances the player to the next level or makes the player
     * win the whole game.
     */
    public void gameWon() {
        if (currentLevel < levelList.size() - 1) {
            currentLevel++;
            inProgress = false;
        } else {
            inProgress = false;
        }
    }

    /**
     * Add a player to the playerList
     * 
     * @param player
     *            player to add
     */
    public void addPlayer(Player player) {
        if (!playerList.contains(player)) {
            playerList.add(player);
        }
    }

    // Getters and setters

    /**
     * Returns the currentLevel
     * 
     * @return the current level
     */
    public Level getCurrentLevel() {
        return levelList.get(currentLevel - 1);
    }

    /**
     * Returns the currentLevel as an integer
     * 
     * @return the current level as an integer
     */
    public int getCurrentLevelInt() {
        return currentLevel;
    }

    public int getLives() {
        return lives;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void resetLevel() {
        levelList.get(currentLevel).resetLevel();
        loseLife();

    }

    public void loseLife() {
        lives--;
        if(lives < 0)
        {
            lives = 0;
        }
    }

    public void getLife() {
        lives++;
    }

    public boolean inProgress() {
        return this.inProgress;
    }
}
