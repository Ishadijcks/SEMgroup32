package game;

import game.bubble.Bubble;
import game.bubble.Bubblex16;
import game.bubble.Bubblex32;
import game.bubble.Bubblex64;
import game.log.Logger;

import java.util.ArrayList;

public class SurvivalLevelCreator {

    private static ArrayList<Player> playerList;

    public static Level getLevel() {
        Bubble bubble1 = new Bubblex32(100, 100, false, false);
        Level level1 = new Level(playerList);
        level1.addBubble(bubble1);
        return level1;
    }
    
    public static void setPlayerList(ArrayList<Player> pList) {
        playerList = pList;
    }

}
