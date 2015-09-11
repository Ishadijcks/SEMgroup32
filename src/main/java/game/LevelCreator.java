package game;

import java.util.ArrayList;

public class LevelCreator {

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
                return getLevel1();

        }
    }

    public static Level getLevel1() {
        Bubble bubble1 = new Bubble(16, 100, 100, false, false);
        Level level1 = new Level(playerList);
        level1.addBubble(bubble1);
        return level1;
    }

    public static Level getLevel2() {
        Bubble bubble1 = new Bubble(16, 320, 250, false, true);
        Bubble bubble2 = new Bubble(32, 720, 100, false, false);
        Level level2 = new Level(playerList);
        level2.addBubble(bubble1);
        level2.addBubble(bubble2);
        return level2;
    }

    public static Level getLevel3() {
        Bubble bubble1 = new Bubble(32, 620, 300, false, true);
        Bubble bubble2 = new Bubble(64, 120, 200, false, false);
        Level level2 = new Level(playerList);
        level2.addBubble(bubble1);
        level2.addBubble(bubble2);
        return level2;
    }

    public static Level getLevel4() {
        Bubble bubble1 = new Bubble(64, 320, 100, false, true);
        Level level2 = new Level(playerList);
        level2.addBubble(bubble1);
        return level2;
    }

    public static Level getLevel5() {
        Bubble bubble1 = new Bubble(64, 320, 100, false, true);
        Level level2 = new Level(playerList);
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
