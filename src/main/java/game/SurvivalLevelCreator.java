package game;

import game.bubble.Bubble;
import game.bubble.Bubblex32;

import java.util.ArrayList;

/**
 * Class that creates a level for the survival mode.
 * 
 * @author Boning
 *
 */
public class SurvivalLevelCreator {

    private static ArrayList<Player> playerList;

    /**
     * Returns the level that is created.
     * @return Level The level that is created
     */
    public static Level getLevel() {
        Bubble bubble1 = new Bubblex32(100, 100, false, false);
        Level level1 = new Level(playerList, false);
        level1.addBubble(bubble1);
        return level1;
    }
    
    /**
     * Set the playerList.
     * @param pList The list that should be used to set the playerList.
     */
    public static void setPlayerList(ArrayList<Player> pList) {
        playerList = pList;
    }

}
