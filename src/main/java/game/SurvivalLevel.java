package game;

import game.bubble.Bubble;
import game.log.Logger;
import game.powerups.Powerup;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class SurvivalLevel extends Level {

    /**
     * Constructor, initializes the bubble- and playerList
     */
    public SurvivalLevel(ArrayList<Player> playerList) {
        super(playerList);
        Logger.log("Level created", 8, 4);
    }

    /**
     * Remove bubble.
     * 
     * @param i
     */
    public void destroyBubble(int i) {

        Bubble bubble = bubbleList.get(i);
        int x = bubble.getX();
        int y = bubble.getY();
        int diameter = bubble.getDiameter();

        addScore(diameter);
        bubbleList.remove(i);

        bubbleList.addAll(bubble.destroyBubble(x, y));

        if (Settings.getPowerupChance() > Math.random() * 100) {
            Powerup powerup = generatePowerup(x, y, randomInt(1, 2));
            powerupList.add(powerup);
        }
    }

    /**
     * Add a bubble to the bubbleList
     * 
     * @param bubble
     *            bubble to add
     */
    public void addBubble(Bubble bubble) {
        bubbleList.add(bubble);
    }
    
    public void spawnBubble(){
        
    }
    
}
