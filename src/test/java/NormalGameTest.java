import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.Level;
import game.NormalGame;
import game.NormalLevel;
import game.NormalLevelFactory;
import game.Player;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class NormalGameTest {

    public NormalGame game;
    public ArrayList<Player> p;
    public Level l;
    public Level k;
    public Player player;
    int currentLevel = 1;

    @Before
    public void initGame() {
        game = new NormalGame();
        p = new ArrayList<Player>();
        l = new NormalLevel(p);
        k = new NormalLevel(p);
        player = new Player("TestPlayer", 1);
    }

    @Test
    public void testNormalGame() {
        assertTrue(game.getPlayerList().equals(p));
        assertFalse(game.inProgress());
    }

    @Test
    public void testGameWonLastLevel() {
        game.addLevel(l);
        assertFalse(game.inProgress());
        game.gameStart();
        assertTrue(game.getCurrentLevelInt() == 1);
        assertTrue(game.inProgress());
        game.gameWon();
        assertFalse(game.inProgress());
        assertTrue(game.getCurrentLevelInt() == 2);
    }

    @Test
    public void testGameWonNthLevel() {
        game.addLevel(l);
        game.addLevel(new NormalLevelFactory(game.getPlayerList()).getLevel1());
        assertFalse(game.inProgress());
        game.gameStart();
        assertTrue(game.getCurrentLevelInt() == 1);
        assertTrue(game.inProgress());
        game.gameWon();
        assertFalse(game.inProgress());
        assertTrue(game.getCurrentLevelInt() == 2);
    }
    
    @Test
    public void testEndGame() {
    	assertTrue(game.getLives() != 0);
    	game.endGame();
    	assertTrue(game.getLives() == 0);
    }
    
    @Test
    public void testGameWonElse() {
        game.addLevel(l);
        game.addLevel(new NormalLevelFactory(game.getPlayerList()).getLevel1());
        assertFalse(game.inProgress());
        game.gameStart();
        game.setCurrentLevelInt(1000000);
        game.gameWon();
        assertFalse(game.inProgress());
    }

}
