package game;

import java.util.ArrayList;

/**
 * Class that handles everything of one game.
 * 
 * @author Boning
 *
 */
public class SurvivalGame extends Game {
    
    /**
     * Constructor of the class.
     */
    public SurvivalGame() {
        super();
        lives = 1;
    }
    public void update(){
        SurvivalLevel sl = (SurvivalLevel) levelList.get(currentLevel -1);
        sl.spawnBubble();
    }
}
