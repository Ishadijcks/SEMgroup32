package game;

import java.util.ArrayList;

public class LevelCreator {
    
    private static ArrayList<Player> playerList;
    private static int levelsAvailable = 5;
    
    public static Level getLevel1( ){
        Bubble bubble1 = new Bubble(32, 50, 50, false, false);
        Level level1 = new Level(playerList);
        level1.addBubble(bubble1);
        return level1;
    }
    
    public static Level getLevel2(){
        Bubble bubble1 = new Bubble(32, 320, 100, false, true);
        Level level1 = new Level(playerList);
        level1.addBubble(bubble1);
        return level1;
    }
    
    
    public static void setPlayerList(ArrayList<Player> pList){
        playerList = pList;
    }
    
    public static int getLevelsAvailable(){
        return levelsAvailable;
    }
}
