import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.Level;
import game.MainRunner;
import game.NormalDriverFactory;
import game.NormalGame;
import game.NormalLevel;
import game.NormalLevelFactory;
import game.Player;
import game.StateManager;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

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
    public void testGame() {
        assertTrue(game.getPlayerList().equals(p));
        assertFalse(game.inProgress());
    }

    @Test
    public void testAddLevel() {
        assertEquals(0, game.getLevelList().size());
        game.addLevel(l);
        assertEquals(1, game.getLevelList().size());
    }

    @Test
    public void testAddLevelContains() {
        assertEquals(0, game.getLevelList().size());
        game.addLevel(l);
        assertEquals(1, game.getLevelList().size());
        game.addLevel(l);
        assertEquals(1, game.getLevelList().size());

    }

    @Test
    public void testGameStart() {
        assertFalse(game.inProgress());
        game.gameStart();
        assertTrue(game.inProgress());
    }

    @Test
    public void testGameAlreadyStarted() {
        assertFalse(game.inProgress());
        game.gameStart();
        assertTrue(game.inProgress());
        game.gameStart();
        assertTrue(game.inProgress());
    }

    @Test
    public void testGameWonOneLevel() {
        game.addLevel(l);
        game.gameStart();
        assertTrue(game.inProgress());
        assertEquals(1, game.getCurrentLevelInt());
        game.gameWon();
        assertFalse(game.inProgress());
        assertEquals(2, game.getCurrentLevelInt());
    }

    @Test
    public void testAddPlayer() {
        assertFalse(game.getPlayerList().contains(player));
        game.addPlayer(player);
        assertTrue(game.getPlayerList().contains(player));
    }

    @Test
    public void testLoseLife() {
        int lives = game.getLives();
        game.loseLife();
        assertEquals(lives - 1, game.getLives());
    }

    @Test
    public void testSetLevelList() {
        ArrayList<Level> llist = new ArrayList<Level>();
        llist.add(k);
        llist.add(l);

        assertTrue(game.getLevelList().isEmpty());
        game.setLevelList(llist);
        assertTrue(game.getLevelList().equals(llist));
    }

    @Test
    public void testResetLevel() {
        Level firstLevel = new NormalLevelFactory(game.getPlayerList())
                .getLevel(1);
        game.addLevel(firstLevel);
        assertTrue(game.getLives() == 5);
        assertTrue(game.getCurrentLevel().equals(firstLevel));
        game.resetLevel();
        assertTrue(game.getCurrentLevel().equals(firstLevel));
    }

    @Test
    public void testLoseLifeNoLifes() {
        assertTrue(game.getLives() == 5);
        game.loseLife();
        assertTrue(game.getLives() == 4);
    }

    @Test
    public void testLoseLifeManyLifes() {
        assertTrue(game.getLives() == 5);
        game.setLives(0);
        assertTrue(game.getLives() == 0);
        game.loseLife();
        assertTrue(game.getLives() == 0);
    }

    @Test
    public void testGetLife() {
        assertTrue(game.getLives() == 5);
        game.getLife();
        assertTrue(game.getLives() == 6);
    }
    
    @Test
    public void testPauseGame() {
    	(new NormalDriverFactory()).buildDriver();
    	StateManager sman = new StateManager();
    	MainRunner.setStateManager(sman);
    	assertFalse(game.inProgress());
    	game.pauseGame();
    	assertTrue(game.inProgress());
    }

}
