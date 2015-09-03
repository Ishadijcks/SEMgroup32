import java.util.ArrayList;

public class Game {
	private ArrayList<Level> levelList = new ArrayList<Level>();
	private int lives = 5;
	private int currentLevel = 0;
	int score;

	public void gameLoop() {
		Level level = levelList.get(currentLevel);
		boolean collision = level.checkCollisionPlayer();
		if (collision) {
			lives--;
			level.resetLevel();
		}
	}

	/**
	 * Returns the levelList
	 * 
	 * @return the levelList (ArrayList)
	 */
	public ArrayList<Level> getLevelList() {
		return levelList;
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
	 * Returns the currentLevel
	 * 
	 * @return the current level (int)
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public int getLives(){
		return lives;
	}
	
	public void loseLife(){
		lives--;
	}
}
