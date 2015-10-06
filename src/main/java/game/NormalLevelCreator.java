package game;

import game.bubble.Bubble;
import game.bubble.Bubblex16;
import game.bubble.Bubblex32;
import game.bubble.Bubblex64;
import game.bubble.Bubblex8;
import game.log.Logger;
import game.wall.BubbleWall;
import game.wall.DuoWall;
import game.wall.PlayerWall;

import java.util.ArrayList;

/**
 * Class that creates a level for the normal game mode.
 * @author Boning
 */
public class NormalLevelCreator {

    private static ArrayList<Player> playerList;
    private static int levelsAvailable = 5;

    /**
     * Return the level.
     * @param level number of the level that you want
     * @return Level that is selected
     */
    public static Level getLevel(int level) {
        switch (level) {
            case 1:
                return getLevel1();
            case 2:
                return getLevel2();
            case 3:
                return getLevel3();
            case 4:
                return getLevel4();
            case 5:
                return getLevel5();
            default:
                Logger.log("getLevel switch default triggered", 8, 3);
                return getLevel1();

        }
    }

    /**
     * Get level 1.
     * @return Level 1 
     */
    public static Level getLevel1() {

        Bubble bubble1 = new Bubblex8(100, 100, false, false);

        Level level1 = new NormalLevel(playerList);

        level1.addBubble(bubble1);
        BubbleWall wall1 = new BubbleWall(300);
        level1.addWall(wall1);
       
        PlayerWall wall9 = new PlayerWall(575);
        level1.addWall(wall9);
        
        return level1;
    }

    /**
     * Get level 2.
     * @return Level 2 
     */
    public static Level getLevel2() {

        Bubble bubble1 = new Bubblex16(320, 250, false, true);
        Bubble bubble2 = new Bubblex32(720, 100, false, false);

        Level level2 = new NormalLevel(playerList);

        level2.addBubble(bubble1);
        level2.addBubble(bubble2);
     
        BubbleWall wall = new BubbleWall(700);
        PlayerWall wall2 = new PlayerWall(600);
        level2.addWall(wall);
        level2.addWall(wall2);
        return level2;
    }

    /**
     * Get level 3.
     * @return Level 3 
     */
    public static Level getLevel3() {
        Bubble bubble1 = new Bubblex32(620, 300, false, true);
        Bubble bubble2 = new Bubblex64(120, 200, false, false);
        Level level2 = new NormalLevel(playerList);
        level2.addBubble(bubble1);
        level2.addBubble(bubble2);
        return level2;
    }

    /**
     * Get level 4.
     * @return Level 4 
     */
    public static Level getLevel4() {
        Bubble bubble1 = new Bubblex64(320, 100, false, true);
        Level level2 = new NormalLevel(playerList);
        level2.addBubble(bubble1);
        return level2;
    }

    /**
     * Get level 5.
     * @return Level 5 
     */
    public static Level getLevel5() {
        Bubble bubble1 = new Bubblex64(320, 100, false, true);
        Level level2 = new NormalLevel(playerList);
        level2.addBubble(bubble1);
        return level2;
    }

    /**
     * Setter for the player list.
     * @param pList list that would be the new player list
     */
    public static void setPlayerList(ArrayList<Player> pList) {
        playerList = pList;
    }

    /**
     * Getter for the available levels.
     * @return number of levels that are available
     */
    public static int getLevelsAvailable() {
        return levelsAvailable;
    }
}
