package game;

import game.bubble.Bubble;
import game.bubble.Bubblex16;
import game.bubble.Bubblex32;
import game.bubble.Bubblex64;
import game.bubble.Bubblex8;
import game.log.Logger;

import java.util.ArrayList;

public class NormalLevelCreator {

    private static ArrayList<Player> playerList;
    private static int levelsAvailable = 5;

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
                Logger.log("getLevel switch default triggered",8, 3);
                return getLevel1();

        }
    }

    public static Level getLevel1() {

        Bubble bubble1 = new Bubblex32(100, 100, false, false);
        Level level1 = new Level(playerList, true);

        level1.addBubble(bubble1);
        BubbleWall wall1 = new BubbleWall(575);
        BubbleWall wall2 = new BubbleWall(550);
        BubbleWall wall3 = new BubbleWall(525);
        BubbleWall wall4 = new BubbleWall(500);
        BubbleWall wall5 = new BubbleWall(625);
        BubbleWall wall6 = new BubbleWall(650);
        BubbleWall wall7 = new BubbleWall(675);
        BubbleWall wall8 = new BubbleWall(700);
        level1.addWall(wall1);
        level1.addWall(wall2);
        level1.addWall(wall3);
        level1.addWall(wall4);
        level1.addWall(wall5);
        level1.addWall(wall6);
        level1.addWall(wall7);
        level1.addWall(wall8);
       
        PlayerWall wall9 = new PlayerWall(300);
        level1.addWall(wall9);
        
        return level1;
    }

    public static Level getLevel2() {

        Bubble bubble1 = new Bubblex16(320, 250, false, true);
        Bubble bubble2 = new Bubblex32(720, 100, false, false);
        Level level2 = new Level(playerList, true);

        level2.addBubble(bubble1);
        level2.addBubble(bubble2);
     
        DuoWall wall = new DuoWall(450);
        DuoWall wall2 = new DuoWall(600);
        level2.addWall(wall);
        level2.addWall(wall2);
        return level2;
    }

    public static Level getLevel3() {
        Bubble bubble1 = new Bubblex32(620, 300, false, true);
        Bubble bubble2 = new Bubblex64(120, 200, false, false);
        Level level2 = new Level(playerList, true);
        level2.addBubble(bubble1);
        level2.addBubble(bubble2);
        return level2;
    }

    public static Level getLevel4() {
        Bubble bubble1 = new Bubblex64(320, 100, false, true);
        Level level2 = new Level(playerList, true);
        level2.addBubble(bubble1);
        return level2;
    }

    public static Level getLevel5() {
        Bubble bubble1 = new Bubblex64(320, 100, false, true);
        Level level2 = new Level(playerList, true);
        level2.addBubble(bubble1);
        return level2;
    }

    public static void setPlayerList(ArrayList<Player> pList) {
        playerList = pList;
    }

    public static int getLevelsAvailable() {
        return levelsAvailable;
    }
}
