package game;

import game.bubble.Bubble;
import game.log.Logger;
import game.powerups.Powerup;

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
