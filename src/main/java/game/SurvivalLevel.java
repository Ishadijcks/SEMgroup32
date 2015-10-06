package game;

import game.bubble.Bubble;
import game.log.Logger;

import java.util.ArrayList;

/**
 * Class that will handle everything in a survival level.
 * @author Boning
 */
public class SurvivalLevel extends Level {

    /**
     * Constructor, initializes the bubble- and playerList.
     * @param playerList list of players that will be added to the level
     */
    public SurvivalLevel(ArrayList<Player> playerList) {
        super(playerList);
        Logger.log("Level created", 8, 4);
    }

    /**
     * Generate a random powerup.
     * @param xCoord x-Coordinate of the powerup
     * @param yCoord y-Coordinate of the powerup
     * @param randomNumber1 randomNumber to select the type of the powerup
     * @return The generated powerup
     */
    public Powerup generatePowerup(int xCoord, int yCoord, int randomNumber1) {
        int randomNumber = randomNumber1;
        switch (randomNumber) {
        case 1:
            Logger.log("Powerup speed spawned", 6, 4);
            return new Powerup("speed", xCoord, yCoord, false);
        case 2:
            Logger.log("Powerup ice spawned", 6, 4);
            return new Powerup("ice", xCoord, yCoord, false);
        default:
            Logger.log("Powerup speed spawned", 6, 4);
            Logger.log("generatePowerup switch default triggered", 6, 3);
            return new Powerup("speed", xCoord, yCoord, false);
        }
    }

    /**
     * Remove bubble.
     * 
     * @param i The index of the bubble that should be destroyed
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
            Powerup powerup = generatePowerup(x, y, MathFunctions.randomInt(1, 2));
            powerupList.add(powerup);
        }
    }

    /**
     * Add a bubble to the bubbleList.
     * @param bubble
     *            bubble to add
     */
    public void addBubble(Bubble bubble) {
        bubbleList.add(bubble);
    }
    
    /**
     * Spawn a bubble into the level.
     */
    public void spawnBubble() {
        
    }
    
}
