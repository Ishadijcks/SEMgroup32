
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import game.NormalGame;
import game.Level;
import game.Player;
import game.Score;

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
		l = new Level(p, true);
		k = new Level(p, true);
		player = new Player("TestPlayer", 1, true);
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
	public void testAddScore(){
		int scoreNumber = 5;
		Score score1 = new Score();
		score1.addScore(scoreNumber);
		assertEquals(Score.getScore(),score1);
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
		assertEquals(1, game.getCurrentLevelInt());
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

}
