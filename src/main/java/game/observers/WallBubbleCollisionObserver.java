package game.observers;

import game.Collisions;
import game.Game;
import game.bubble.Bubble;

public class WallBubbleCollisionObserver extends Observer {

	public WallBubbleCollisionObserver(Collisions collisions) {
		super(collisions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Object wall, Object bubb, Game game) {
		Bubble bubble = (Bubble)bubb;
		bubble.bounceH();
	}

}