package game;

import game.bubble.Bubble;
import game.bubble.Bubblex32;

import java.util.ArrayList;

/**
 * Class that creates a level for the survival mode.
 * 
 * @author Boning
 */
public class SurvivalLevelFactory {

    private static ArrayList<Player> playerList;

    /**
     * Creates a survivalLevelFactory with a list of players.
     * 
     * @param pList
     *            the list of players to use
     */
    public SurvivalLevelFactory(ArrayList<Player> pList) {
        this.playerList = pList;
    }

    /**
     * Returns the level that is created.
     * 
     * @return Level The level that is created
     */
    public Level getLevel() {
        Bubble bubble1 = new Bubblex32(100, 100, false, false);
        Level level1 = new SurvivalLevel(playerList);
        level1.addBubble(bubble1);
        return level1;
    }
    
    /**
     * Getter for the player list.
     * @return the playerlist.
     */
    public static ArrayList<Player> getPlayerList() {
    	return playerList;
    }

}
