package game;

import game.log.Logger;

import java.util.ArrayList;

public abstract class Game {
    protected ArrayList<Level> levelList = new ArrayList<Level>();
    protected ArrayList<Player> playerList;
    protected int lives = Settings.getLives();
    protected int currentLevel = 1;
    protected boolean inProgress;

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
     * If the game is paused, start the game
     */
    public void gameStart() {
        if (!this.inProgress)
            this.inProgress = true;
        Logger.log("Game started", 7,4);
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
        levelList.set(currentLevel-1, NormalLevelCreator.getLevel(currentLevel));
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (currentLevel != other.currentLevel)
			return false;
		if (inProgress != other.inProgress)
			return false;
		if (levelList == null) {
			if (other.levelList != null)
				return false;
		} else if (!levelList.equals(other.levelList))
			return false;
		if (lives != other.lives)
			return false;
		if (playerList == null) {
			if (other.playerList != null)
				return false;
		} else if (!playerList.equals(other.playerList))
			return false;
		return true;
	}
}
