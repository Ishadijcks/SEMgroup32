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
       Logger.log("Game object created", 7, 5);
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
        Logger.log("Level added to the game",7 ,4);
    }
    /**
     * Add score to the players score
     */
    public void addScore(int score){
        this.score += score;
        Logger.log(score+" points gained. Total score is now "+this.score, 7, 5);
    }

    /**
     * Add score to the players score
     */
    public int getScore(){
       return score;
    }

    /**
     * If the game is paused, start the game
     */
    public void gameStart() {
        if (!this.inProgress)
            this.inProgress = true;
        Logger.log("Game started", 7,4);
    }

    /**
     * Function that advances the player to the next level or makes the player
     * win the whole game.
     */
    public void gameWon() {
        if (currentLevel < levelList.size() - 1) {
            currentLevel++;
            Logger.log("Level completed", 8, 4);
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
        Logger.log("Player "+player.getName()+ " added to the game", 1, 4);
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

    /**
	 * @param currentLevel the currentLevel to set
	 */
	public void setCurrentLevelInt(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
     * Get the lives of the player
     * @return the lives of the player
     */
    public int getLives() {
        return lives;
    }

    /**
	 * @param lives the lives to set
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}

	/**
     * Create an array with the players
     * @return the playerlist
     */
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Reset the level if you lost a life
     */
    public void resetLevel() {
        levelList.set(currentLevel-1, LevelCreator.getLevel(currentLevel));
        loseLife();

    }

    /**
     * Method to control losing a life
     */
    public void loseLife() {
        lives--;
        if(lives < 0)
        {
            lives = 0;
        }
    }

    /**
     * Method to control getting a life (thanks to powerups e.g.)
     */
    public void getLife() {
        lives++;
    }

    /**
     * Method to show that the game is in progress
     * @return a boolean that is true if the game is in progress.
     */
    public boolean inProgress() {
        return this.inProgress;
    }
    
    
    public void toggleProgress(){
        inProgress = !inProgress;
    }
}
