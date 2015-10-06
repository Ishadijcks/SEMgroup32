package game;

import game.bubble.Bubble;
import game.log.Logger;
import game.powerups.Powerup;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class NormalLevel extends Level {

    /**
     * Constructor, initializes the bubble- and playerList
     */
    public NormalLevel(ArrayList<Player> playerList) {
        super(playerList);
        Logger.log("Level created", 8, 4);
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
