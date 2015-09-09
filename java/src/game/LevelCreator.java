package game;

import java.util.ArrayList;

public class LevelCreator {
    
    private static ArrayList<Player> playerList;
    private static int levelsAvailable = 5;
    
    public static Level getLevel1( ){
        Bubble bubble1 = new Bubble(16, 100, 100, false, false);
        Level level1 = new Level(playerList);
        level1.addBubble(bubble1);
        return level1;
    }
    
    public static Level getLevel2(){
        Bubble bubble1 = new Bubble(16, 320, 250, false, true);
        Bubble bubble2 = new Bubble(16, 720, 100, false, false);
        Level level2 = new Level(playerList);
        level2.addBubble(bubble1);
        level2.addBubble(bubble2);
        return level2;
    }
    
    public static Level getLevel3(){
        Bubble bubble1 = new Bubble(16, 620, 300, false, true);
        Bubble bubble2 = new Bubble(32, 120, 500, false, false);
        Level level2 = new Level(playerList);
        level2.addBubble(bubble1);
        level2.addBubble(bubble2);
        return level2;
    }
    
    public static Level getLevel4(){
        Bubble bubble1 = new Bubble(32, 320, 100, false, true);
        Level level2 = new Level(playerList);
        level2.addBubble(bubble1);
        return level2;
    }
    
    public static Level getLevel5(){
        Bubble bubble1 = new Bubble(32, 320, 100, false, true);
        Level level2 = new Level(playerList);
        level2.addBubble(bubble1);
        return level2;
    }
    
    
    public static void setPlayerList(ArrayList<Player> pList){
        playerList = pList;
    }
    
    public static int getLevelsAvailable(){
        return levelsAvailable;
    }
}