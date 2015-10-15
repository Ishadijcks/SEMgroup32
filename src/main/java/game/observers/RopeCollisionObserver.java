package game.observers;

import game.Collisions;
import game.Driver;
import game.Game;
import game.Level;
import game.Rope;
import game.bubble.Bubble;
import game.powerups.Powerup;
import game.powerups.PowerupFactory;

import java.util.ArrayList;

import settings.powerupSettings;

/**
 * The rope with bubble collision class.
 * @author Floris
 *
 */
public class RopeCollisionObserver extends Observer {

    PowerupFactory pfac = new PowerupFactory();
    /**
     * The Observer for rope collisions with bubbles.
     * @param collisions object
     */
    public RopeCollisionObserver(Collisions collisions) {
        super(collisions);
        collisions.registerObserver(this);
    }

    /**
     * The update method of the observer.
     * @param target object
     * @param cause object
     * @param game object
     */
    @Override
    public void update(Object bub, Object rop, Game g) {
        Bubble bubble = ((Bubble) bub);
        Rope rope = ((Rope) rop);
        Game game = ((Game) g);
        Level currentLevel = game.getCurrentLevel();
        ArrayList<Bubble> bubbleList = game.getCurrentLevel().getBubbleList();

        int bubblePosX = bubble.getX();
        int bubblePosY = bubble.getY();

        Driver.score.addScore(bubble.getScoreWorth());
        bubbleList.addAll(bubble.destroyBubble(bubblePosX, bubblePosY));
        bubbleList.remove(bubble);

        currentLevel.setRope(null);

        if (powerupSettings.getPowerupChance() > Math.random() * 100) {
            Powerup powerup = pfac.createRandomPowerup();
            powerup.setX(bubblePosX);
            powerup.setY(bubblePosY);
            currentLevel.getPowerupList().add(powerup);

        }
    }

}
