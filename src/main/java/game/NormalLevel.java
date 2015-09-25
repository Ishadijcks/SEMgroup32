package game;

import game.bubble.Bubble;
import game.log.Logger;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class NormalLevel extends Level {

    /**
     * Constructor, initializes the bubble- and playerList
     */
    public NormalLevel(ArrayList<Player> playerList) {
        super(playerList);
        this.bubbleList = new ArrayList<Bubble>();
        this.playerList = playerList;
        this.powerupList = new ArrayList<Powerup>();
        this.wallList = new ArrayList<Wall>();
        Logger.log("Level created", 8, 4);
    }

    public Powerup generatePowerup(int x, int y, int randomNumber1) {
        int randomNumber = randomNumber1;
        switch (randomNumber) {
        case 1:
            Logger.log("Powerup speed spawned", 6, 4);
            return new Powerup("speed", x, y, true);
        case 2:
            Logger.log("Powerup life spawned", 6, 4);
            return new Powerup("life", x, y, true);
        case 3:
            Logger.log("Powerup ice spawned", 6, 4);
            return new Powerup("ice", x, y, true);
        default:
            Logger.log("Powerup speed spawned", 6, 4);
            Logger.log("generatePowerup switch default triggered", 6, 3);
            return new Powerup("speed", x, y, true);
        }
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
            Powerup powerup = generatePowerup(x, y, randomInt(1, 3));
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
        if (!bubbleList.contains(bubble)) {
            bubbleList.add(bubble);
        }
    }
}
