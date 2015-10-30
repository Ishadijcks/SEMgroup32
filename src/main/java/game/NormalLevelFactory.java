package game;

import game.bubble.Bubble;
import game.bubble.Bubblex128;
import game.bubble.Bubblex16;
import game.bubble.Bubblex32;
import game.bubble.Bubblex64;
import game.bubble.Bubblex8;
import game.log.Logger;
import game.wall.HorizontalMoveBubbleWall;
import game.wall.NoMoveBubbleWall;
import game.wall.PlayerWall;
import game.wall.VerticalMoveBubbleWall;
import game.helperobjects.Coordinates;

import java.util.ArrayList;

/**
 * Class that creates a level for the normal game mode.
 * 
 * @author Boning
 */
public class NormalLevelFactory {

    private static ArrayList<Player> playerList;
    private static int levelsAvailable = 10;

    /**
     * Creates a normalLevelFactory with a playerList.
     * 
     * @param pList
     *            the playerList to use
     */
    public NormalLevelFactory(ArrayList<Player> pList) {
        NormalLevelFactory.playerList = pList;
    }

    /**
     * Get an arraylist of all the levels that can be built within this class.
     * 
     * @return ArrayList<Level>
     */
    public ArrayList<Level> getAllLevels() {
        ArrayList<Level> levelList = new ArrayList<Level>();
        for (int i = 1; i < levelsAvailable + 1; i++) {
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
        Bubble bubble1 = new Bubblex16(152, 50, false, false);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        HorizontalMoveBubbleWall wall1 = new HorizontalMoveBubbleWall(
                new Coordinates(225, 300), 10, 300, 100, 550, 2);
        HorizontalMoveBubbleWall wall2 = new HorizontalMoveBubbleWall(
                new Coordinates(200, 350), 10, 200, 20, 550, 3);
        level.addWall(wall1);
        level.addWall(wall2);
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
        PlayerWall wall1 = new PlayerWall(new Coordinates(600, 0), 3);
        HorizontalMoveBubbleWall wall2 = new HorizontalMoveBubbleWall(
                new Coordinates(300, 350), 10, 75, 100, 650, 5);
        VerticalMoveBubbleWall wall3 = new VerticalMoveBubbleWall(
                new Coordinates(750, 250), 100, 10, 50, 350, 2);
        level.addWall(wall1);
        level.addWall(wall2);
        level.addWall(wall3);
        level.setLevelNumber(2);
        return level;
    }

    /**
     * Get level 3.
     * 
     * @return Level 3
     */
    public Level getLevel3() {
        Bubble bubble1 = new Bubblex64(620, 100, false, true);
        NoMoveBubbleWall wall1 = new NoMoveBubbleWall(
                new Coordinates(750, 0), 500, 10);
        NoMoveBubbleWall wall2 = new NoMoveBubbleWall(
                new Coordinates(250, 0), 500, 10);
        NoMoveBubbleWall wall3 = new NoMoveBubbleWall(
                new Coordinates(350, 0), 500, 10);
        NoMoveBubbleWall wall4 = new NoMoveBubbleWall(
                new Coordinates(550, 0), 500, 10);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        level.addWall(wall1);
        level.addWall(wall2);
        level.addWall(wall3);
        level.addWall(wall4);
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
        PlayerWall wall1 = new PlayerWall(
                new Coordinates(750, 0), 10);
        PlayerWall wall2 = new PlayerWall(
                new Coordinates(250, 0), 10);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        level.addWall(wall1);
        level.addWall(wall2);
        level.setLevelNumber(4);
        return level;
    }

    /**
     * Get level 5.
     * 
     * @return Level 5
     */
    public Level getLevel5() {
        Bubble bubble1 = new Bubblex32(320, 100, false, true);
        Bubble bubble2 = new Bubblex32(620, 100, false, true);
        PlayerWall wall1 = new PlayerWall(
                new Coordinates(450, 0), 10);
        HorizontalMoveBubbleWall wall2 = new HorizontalMoveBubbleWall(
                new Coordinates(55, 300), 10, 300, 75, 150, 1);
        HorizontalMoveBubbleWall wall3 = new HorizontalMoveBubbleWall(
                new Coordinates(500, 350), 10, 200, 470, 710, 1);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        level.addBubble(bubble2);
        level.addWall(wall1);
        level.addWall(wall2);
        level.addWall(wall3);
        level.setLevelNumber(5);
        return level;
    }

    /**
     * Get level 6.
     * 
     * @return Level 6
     */
    public static Level getLevel6() {
        Bubble bubble1 = new Bubblex16(320, 100, false, true);
        Bubble bubble2 = new Bubblex16(620, 100, false, true);
        HorizontalMoveBubbleWall wall1 = new HorizontalMoveBubbleWall(
                new Coordinates(55, 100), 10, 300, 75, 150, 1);
        HorizontalMoveBubbleWall wall2 = new HorizontalMoveBubbleWall(
                new Coordinates(55, 300), 10, 300, 75, 150, 1);
        HorizontalMoveBubbleWall wall3 = new HorizontalMoveBubbleWall(
                new Coordinates(500, 350), 10, 200, 470, 710, 1);
        HorizontalMoveBubbleWall wall4 = new HorizontalMoveBubbleWall(
                new Coordinates(500, 150), 10, 200, 470, 710, 1);
        HorizontalMoveBubbleWall wall5 = new HorizontalMoveBubbleWall(
                new Coordinates(500, 250), 10, 200, 150, 500, 1);
        VerticalMoveBubbleWall wall6 = new VerticalMoveBubbleWall(
                new Coordinates(350, 250), 100, 10, 50, 350, 2);
        VerticalMoveBubbleWall wall7 = new VerticalMoveBubbleWall(
                new Coordinates(550, 250), 100, 10, 50, 350, 2);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        level.addBubble(bubble2);
        level.addWall(wall1);
        level.addWall(wall2);
        level.addWall(wall3);
        level.addWall(wall4);
        level.addWall(wall5);
        level.addWall(wall6);
        level.addWall(wall7);
        level.setLevelNumber(5);
        return level;
    }

    /**
     * Get level 7.
     * 
     * @return Level 7
     */
    public static Level getLevel7() {
        Bubble bubble1 = new Bubblex128(320, 100, false, true);
        NormalLevel level = new NormalLevel(playerList);
        PlayerWall wall1 = new PlayerWall(new Coordinates(600, 0), 10);
        PlayerWall wall2 = new PlayerWall(new Coordinates(250, 0), 10);
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
        Bubble bubble2 = new Bubblex64(820, 30, false, true);
        VerticalMoveBubbleWall wall1 = new VerticalMoveBubbleWall(
                new Coordinates(150, 250), 150, 10, 25, 300, 1);
        VerticalMoveBubbleWall wall2 = new VerticalMoveBubbleWall(
                new Coordinates(250, 250), 130, 10, 25, 310, 2);
        VerticalMoveBubbleWall wall3 = new VerticalMoveBubbleWall(
                new Coordinates(350, 250), 110, 10, 25, 300, 3);
        VerticalMoveBubbleWall wall4 = new VerticalMoveBubbleWall(
                new Coordinates(450, 250), 70, 10, 25, 300, 4);
        VerticalMoveBubbleWall wall5 = new VerticalMoveBubbleWall(
                new Coordinates(550, 250), 30, 10, 25, 300, 2);
        VerticalMoveBubbleWall wall6 = new VerticalMoveBubbleWall(
                new Coordinates(650, 250), 10, 10, 25, 330, 6);
        VerticalMoveBubbleWall wall7 = new VerticalMoveBubbleWall(
                new Coordinates(750, 250), 100, 10, 25, 300, 3);
        NormalLevel level = new NormalLevel(playerList);
        level.addBubble(bubble1);
        level.addBubble(bubble2);
        level.addWall(wall1);
        level.addWall(wall2);
        level.addWall(wall3);
        level.addWall(wall4);
        level.addWall(wall5);
        level.addWall(wall6);
        level.addWall(wall7);
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
        for (int i = 0; i < 6; i++) {
            Bubble bubble = new Bubblex8(250 + 95 * i, 100, false, false);
            level.addBubble(bubble);
        }
        Bubble bubble1 = new Bubblex128(720, 100, false, true);
        VerticalMoveBubbleWall wall1 = new VerticalMoveBubbleWall(
                new Coordinates(250, 250), 200, 10, 25, 330, 1);
        VerticalMoveBubbleWall wall2 = new VerticalMoveBubbleWall(
                new Coordinates(750, 250), 150, 10, 25, 300, 1);
        level.addBubble(bubble1);
        level.addWall(wall1);
        level.addWall(wall2);
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
        Bubble bubble1 = new Bubblex128(320, 100, false, true);
        Bubble bubble2 = new Bubblex128(720, 80, false, true);
        VerticalMoveBubbleWall wall1 = new VerticalMoveBubbleWall(
                new Coordinates(250, 250), 200, 10, 25, 330, 1);
        VerticalMoveBubbleWall wall2 = new VerticalMoveBubbleWall(
                new Coordinates(750, 250), 150, 10, 25, 300, 1);
        level.addBubble(bubble1);
        level.addBubble(bubble2);
        level.addWall(wall1);
        level.addWall(wall2);
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
    
    /**
     * Getter for the player list.
     * @return the playerlist.
     */
    public static ArrayList<Player> getPlayerList() {
    	return playerList;
    }

    /**
     * The total amount of playable levels.
     * 
     * @return int of the total amount of playable levels
     */
    public int getLevelsAvailable() {
        return levelsAvailable;
    }

}
