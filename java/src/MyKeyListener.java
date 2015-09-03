import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class MyKeyListener extends KeyAdapter {

	Game game = Driver.game;

	public void keyPressed(KeyEvent evt) {
		System.out.println(evt.getKeyCode());

		Level curLevel = game.getLevelList().get(game.getCurrentLevel());

		switch (evt.getKeyCode()) {

		// Left
		case 37:
			curLevel.getPlayerList().get(0).moveLeft();
			break;

		// Right
		case 39:
			curLevel.getPlayerList().get(0).moveRight();
			break;

		case 32:
			curLevel.getPlayerList().get(0).shootRope();
			break;
		}
	}
}
