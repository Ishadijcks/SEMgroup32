package game.collisions;

import game.Game;
import game.Player;
import game.observers.Observer;
import game.wall.Wall;

public class WallPlayerCollision extends Collision {

	public WallPlayerCollision() {
		super();
	}

	@Override
	public boolean checkCollision(Game game) {
        Player player = game.getPlayerList().get(0);
        for (Wall wall : game.getCurrentLevel().getWallList()) {
            if (wall.expectPlayerCollision(player.getX(),
                    player.getMovingLeft())) {
                notifyListeningObservers();
                return true;
            }
        }
        return false;
	}

	@Override
	public void notifyListeningObservers() {
    	for (Observer o : observers) {
    		o.wallPlayerEvent();
    	}

	}

	@Override
	public void notifyListeningObservers(Object object) {
		// TODO Auto-generated method stub

	}

}
