package game;

import game.bubble.Bubble;
import game.log.Logger;

import java.util.ArrayList;

/**
 * Class that will handle everything in a survival level.
 * 
 * @author Boning
 */
public class SurvivalLevel extends Level {

    /**
     * Constructor, initializes the bubble- and playerList.
     * 
     * @param playerList
     *            list of players that will be added to the level
     */
    public SurvivalLevel(ArrayList<Player> playerList) {
        super(playerList);
        Logger.log("Level created", 8, 4);
    }

    /**
     * Add a bubble to the bubbleList.
     * 
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
