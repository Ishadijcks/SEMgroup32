package game;

import game.bubble.Bubble;
import game.bubble.Bubblex16;
import game.bubble.Bubblex32;
import game.bubble.Bubblex64;
import game.bubble.Bubblex8;
import game.log.Logger;
import game.wall.BubbleWall;
import game.wall.NoMoveBubbleWall;
import game.wall.PlayerWall;
import helperobjects.Coordinates;

import java.util.ArrayList;

import settings.screenSettings;

/**
 * Class that creates a level for the normal game mode.
 * 
 * @author Boning
 */
public class NormalLevelFactory {

    private static ArrayList<Player> playerList;
    private static int levelsAvailable = 10;
    
    public NormalLevelFactory(ArrayList<Player> pList) {
    	this.playerList = pList;
    }
    
    /** Get an arraylist of all the levels that can be built
     * within this class.
     * @return ArrayList<Level>
     */
    public ArrayList<Level> getAllLevels() {
    	ArrayList<Level> levelList = new ArrayList<Level>();
    	for(int i = 1; i < levelsAvailable + 1; i++){
    		levelList.add(getLevel(i));
    	}
    	return levelList;
    }

    /**
     * Return the level.
     * 
     * @param level
     *            number of the level that you want
     * @return Level that is selected
     */
    public Level getLevel(int level) {
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
        case 6:
            return getLevel6();
        case 7:
            return getLevel7();
        case 8:
            return getLevel8();
        case 9:
            return getLevel9();
        case 10:
            return getLevel10();
        default:
            Logger.log("getLevel switch default triggered", 8, 3);
            return getLevel1();

        }
    }

    /**
     * Get level 1.
     * 
     * @return Level 1
     */
    public Level getLevel1() {
        Bubble bubble1 = new Bubblex8(100, 100, false, false);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        NoMoveBubbleWall wall1 = new NoMoveBubbleWall(new Coordinates(300, 0), screenSettings.getLevelHeight() - 300, 100);
        level.addWall(wall1);
        PlayerWall wall9 = new PlayerWall(new Coordinates(675, 0), screenSettings.getLevelHeight(), 100);
        level.addWall(wall9);
        level.setLevelNumber(1);
        return level;
    }

    /**
     * Get level 2.
     * 
     * @return Level 2
     */
    public Level getLevel2() {
        Bubble bubble1 = new Bubblex16(320, 250, false, true);
        Bubble bubble2 = new Bubblex32(720, 100, false, false);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        level.addBubble(bubble2);
        BubbleWall wall = new NoMoveBubbleWall(new Coordinates(300, 0), screenSettings.getLevelHeight() - 200, 50);
        PlayerWall wall2 = new PlayerWall(new Coordinates(700, 0), screenSettings.getLevelHeight() - 300, 40);
        BubbleWall wall3 = new NoMoveBubbleWall(new Coordinates(850, 0), screenSettings.getLevelHeight() - 400, 30);
        BubbleWall wall4 = new NoMoveBubbleWall(new Coordinates(900, 0), screenSettings.getLevelHeight() - 100, 20);
        level.addWall(wall);
        level.addWall(wall2);
        level.addWall(wall3);
        level.addWall(wall4);
        level.setLevelNumber(2);
        return level;
    }

    /**
     * Get level 3.
     * 
     * @return Level 3
     */
    public Level getLevel3() {
        Bubble bubble1 = new Bubblex32(620, 300, false, true);
        Bubble bubble2 = new Bubblex64(120, 200, false, false);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        level.addBubble(bubble2);
        level.setLevelNumber(3);
        return level;
    }

    /**
     * Get level 4.
     * 
     * @return Level 4
     */
    public Level getLevel4() {
        Bubble bubble1 = new Bubblex64(320, 100, false, true);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        level.setLevelNumber(4);
        return level;
    }

    /**
     * Get level 5.
     * 
     * @return Level 5
     */
    public Level getLevel5() {
        Bubble bubble1 = new Bubblex64(320, 100, false, true);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        level.setLevelNumber(5);
        return level;
    }

    /**
     * Get level 6.
     * 
     * @return Level 6
     */
    public static Level getLevel6() {
        Bubble bubble1 = new Bubblex64(320, 100, false, true);
        NormalLevel level = new NormalLevel(playerList);
        PlayerWall wall1 = new PlayerWall(new Coordinates(700, 0), screenSettings.getLevelHeight(), 10);
        level.addBubble(bubble1);
        level.addWall(wall1);
        level.setLevelNumber(6);
        return level;
    }

    /**
     * Get level 7.
     * 
     * @return Level 7
     */
    public static Level getLevel7() {
        Bubble bubble1 = new Bubblex64(320, 100, false, true);
        NormalLevel level = new NormalLevel(playerList);
        PlayerWall wall1 = new PlayerWall(new Coordinates(600, 0), screenSettings.getLevelHeight(), 10);
        PlayerWall wall2 = new PlayerWall(new Coordinates(200, 0), screenSettings.getLevelHeight(), 10);
        level.addBubble(bubble1);
        level.addWall(wall1);
        level.addWall(wall2);
        level.setLevelNumber(7);
        return level;
    }

    /**
     * Get level 8.
     * 
     * @return Level 8
     */
    public static Level getLevel8() {
        Bubble bubble1 = new Bubblex64(320, 100, false, true);
        Bubble bubble2 = new Bubblex64(320, 100, false, true);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        level.addBubble(bubble2);
        level.setLevelNumber(8);
        return level;
    }

    /**
     * Get level 9.
     * 
     * @return Level 9
     */
    public static Level getLevel9() {
        NormalLevel level = new NormalLevel(playerList);
        for (int i = 0; i < 4; i++) {
            Bubble bubble = new Bubblex16(320, 100, false, true);
            level.addBubble(bubble);
        }
        level.setLevelNumber(9);
        return level;
    }

    /**
     * Get level 10.
     * 
     * @return Level 10
     */
    public static Level getLevel10() {
        NormalLevel level = new NormalLevel(playerList);
        for (int i = 0; i < 8; i++) {
            Bubble bubble = new Bubblex8(320, 100, false, true);
            level.addBubble(bubble);
        }
        level.setLevelNumber(10);
        return level;
    }

    /**
     * Setter for the player list.
     * 
     * @param pList
     *            list that would be the new player list
     */
    public static void setPlayerList(ArrayList<Player> pList) {
        playerList = pList;
    }
    
    /** The total amount of playable levels
     * @return int of the total amount of playable levels
     */
    public int getLevelsAvailable() {
        return levelsAvailable;
    }

}
