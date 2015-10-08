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
    }

    @Override
    public void update(Object bub, Object rop, Game g) {
        Bubble bubble = ((Bubble) bub);
        Rope rope = ((Rope) rop);
        Game game = ((Game) g);
        Level currentLevel = game.getCurrentLevel();
        ArrayList<Bubble> bubbleList = game.getCurrentLevel().getBubbleList();

        int bubblePosX = bubble.getX();
        int bubblePosY = bubble.getY();

        NormalDriver.score.addScore(bubble.getScoreWorth());
        bubbleList.addAll(bubble.destroyBubble(bubblePosX, bubblePosY));
        bubbleList.remove(bubble);

        currentLevel.setRope(null);

        if (Settings.getPowerupChance() > Math.random() * 100) {
            Powerup powerup = pfac.createRandomPowerup();
            powerup.setX(bubblePosX);
            powerup.setY(bubblePosY);
            currentLevel.getPowerupList().add(powerup);

        }
    }

}
