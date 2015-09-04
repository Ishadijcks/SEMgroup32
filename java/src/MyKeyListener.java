import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class MyKeyListener extends KeyAdapter {

	Game game = Driver.game;

	public void keyPressed(KeyEvent evt) {
		if (game.inProgress()) {

			Level curLevel = game.getLevelList().get(game.getCurrentLevel());

			switch (evt.getKeyCode()) {

			// Left
			case 37:
				curLevel.getPlayerList().get(0).movingLeft();
				break;
			// Right
			case 39:
				curLevel.getPlayerList().get(0).movingRight();
				break;
			case 32:
				curLevel.getPlayerList().get(0).shootRope();
				break;
			}
		}
	}

	public void keyReleased(KeyEvent evt) {

		Level curLevel = game.getLevelList().get(game.getCurrentLevel());

		switch (evt.getKeyCode()) {

		// Left
		case 37:
			curLevel.getPlayerList().get(0).stopMovingLeft();
			break;

		// Right
		case 39:
			curLevel.getPlayerList().get(0).stopMovingRight();
			break;
		}
	}
}
