package game.observers;

import game.Collisions;
import game.Game;
import game.Player;
import game.Settings;

public class WallPlayerCollisionObserver extends Observer {

	public WallPlayerCollisionObserver(Collisions collisions) {
		super(collisions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Object wall, Object plyr, Game game) {
		Player player = (Player)plyr;
		if(player.getMovingRight()){
			Settings.setRestrictMovingRight(true);
			Settings.setRestrictMovingLeft(false);
		} else if(player.getMovingLeft()){
			Settings.setRestrictMovingLeft(true);
			Settings.setRestrictMovingRight(false);
		}

	}

}
