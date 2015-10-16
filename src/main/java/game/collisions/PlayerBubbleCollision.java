package game.collisions;

import game.Game;
import game.Player;
import game.bubble.Bubble;
import game.log.Logger;
import game.observers.BubbleController;
import game.observers.GameController;
import game.observers.LevelController;
import game.observers.Observer;
import game.observers.PlayerController;
import game.observers.PowerupController;

public class PlayerBubbleCollision extends Collision {

	public PlayerBubbleCollision() {
		super();
	}

	@Override
	public boolean checkCollision(Game game) {
		
		Player player = game.getPlayerList().get(0);

	    for (Bubble bubble : game.getCurrentLevel().getBubbleList()) {
	        if (player.getX() <= (bubble.getX() + bubble.getDiameter())
	                && (player.getCollisionX() + player.getWidth()) >= bubble
	                        .getX()
	                && player.getCollisionY() <= (bubble.getY() + bubble
	                        .getDiameter())
	                && (player.getY() + player.getHeight()) >= bubble.getY()) {
	            if (player.getCollisionY() <= bubble.getY()) {
	                Logger.log("Player collided with a bubble", 8, 4);
	                notifyListeningObservers();
	                return true;
	            }
	        }
	    }
	    return false;
	}

	@Override
	public void notifyListeningObservers() {
		for (Observer o : observers) {
    		o.bubblePlayerEvent();
    	}
	}

	@Override
	public void notifyListeningObservers(Object object) {
		// TODO Auto-generated method stub
		
	}

}
