import java.util.ArrayList;

public class Game {
	private ArrayList<Level> levelList = new ArrayList<Level>();
	int lives = 5;
	int currentLevel = 0;
	int score;

	public void gameLoop() {
		Level level = levelList.get(currentLevel);
		boolean collision = level.checkCollisionPlayer();
		if (collision) {
			lives--;
			level.resetLevel();
		}
	}
}
