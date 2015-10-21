package game;

import game.bubble.Bubble;
import game.log.Logger;

import java.util.ArrayList;

/**
 * Class that will handle everything in a normal level.
 * 
 * @author Boning
 */
public class NormalLevel extends Level {
    private int levelNumber;

    /**
     * Constructor, initializes the bubble- and playerList.
     * 
     * @param playerList
     *            list of players that will be added
     */
    public NormalLevel(ArrayList<Player> playerList) {
        super(playerList);
        Logger.log("Level created", 8, 4);
    }
    
    /**
     * Add a bubble to the bubbleList.
     * 
     * @param bubble
     *            The bubble that is added
     */
    public void addBubble(Bubble bubble) {
        if (!bubbleList.contains(bubble)) {
            bubbleList.add(bubble);
        }
    }

    /**
     * set The level number.
     * 
     * @param levelNumber level number
     */
    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    /**
     * get The level number.
     * 
     * @return integer
     */
    public int getLevelNumber() {
        return (this.levelNumber);
    }
}
