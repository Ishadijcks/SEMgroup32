package game;

import game.bubble.Bubble;
import game.log.Logger;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class that will handle everything in a normal level.
 * @author Boning
 */
public class NormalLevel extends Level {

    /**
     * Constructor, initializes the bubble- and playerList.
     * @param playerList list of players that will be added
     */
    public NormalLevel(ArrayList<Player> playerList) {
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
            return new Powerup("speed", xCoord, yCoord, true);
        case 2:
            Logger.log("Powerup life spawned", 6, 4);
            return new Powerup("life", xCoord, yCoord, true);
        case 3:
            Logger.log("Powerup ice spawned", 6, 4);
            return new Powerup("ice", xCoord, yCoord, true);
        default:
            Logger.log("Powerup speed spawned", 6, 4);
            Logger.log("generatePowerup switch default triggered", 6, 3);
            return new Powerup("speed", xCoord, yCoord, true);
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
            Random rand = new Random();
            int randomNum = rand.nextInt((3 - 1) + 1) + 1;
            Powerup powerup = generatePowerup(x, y, randomNum);
            powerupList.add(powerup);

        }
    }

    /**
     * Add a bubble to the bubbleList.
     * 
     * @param bubble The bubble that is added
     */
    public void addBubble(Bubble bubble) {
        if (!bubbleList.contains(bubble)) {
            bubbleList.add(bubble);
        }
    }
}
