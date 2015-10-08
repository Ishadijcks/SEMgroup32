package game.observers;

import java.util.ArrayList;

import game.Collisions;
import game.Game;
import game.Level;
import game.NormalDriver;
import game.Rope;
import game.Settings;
import game.bubble.Bubble;
import game.powerups.IcePowerup;
import game.powerups.Powerup;
import game.powerups.PowerupFactory;

public class RopeCollisionObserver extends Observer {
	
	PowerupFactory pfac = new PowerupFactory();

	public RopeCollisionObserver(Collisions collisions) {
		super(collisions);
	}

	@Override
	public void update(Object bub, Object rop, Game g) {
		Bubble bubble = ((Bubble)bub);
		Rope rope = ((Rope)rop);
		Game game = ((Game)g);
		Level currentLevel = game.getCurrentLevel();
		ArrayList<Bubble> bubbleList = game.getCurrentLevel().getBubbleList();
		
        int bubblePos_x = bubble.getX();
        int bubblePos_y = bubble.getY();

        NormalDriver.score.addScore(bubble.getScoreWorth());
        bubbleList.addAll(bubble.destroyBubble(bubblePos_x, bubblePos_y));
        bubbleList.remove(bubble);

        
        currentLevel.setRope(null);

        if (Settings.getPowerupChance() > Math.random() * 100) {
            Powerup powerup = pfac.createRandomPowerup();
            powerup.setX(bubblePos_x);
            powerup.setY(bubblePos_y);
            currentLevel.getPowerupList().add(powerup);

        }
	}

}
