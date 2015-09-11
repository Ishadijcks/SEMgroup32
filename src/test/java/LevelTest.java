
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import game.Bubble;
import game.Level;
import game.Player;
import game.Powerup;
import game.Rope;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class LevelTest {
	
	public Level l;
	public Bubble bubble;
	public Powerup powr;
	public ArrayList<Player> p;
	public ArrayList<Bubble> bubbleList;
	public ArrayList<Powerup> plist;
	
	@Before
	public void init() {
		bubble = new Bubble(18,2,2,true,true);
		p = new ArrayList<Player>();
		l = new Level(p);
		bubbleList = new ArrayList<Bubble>();
		plist = new ArrayList<Powerup>();
		powr = new Powerup("speed", 0,0);
	}

	@Test
	public void testLevel() {
		assertTrue(l.getBubbleList().equals(bubbleList));
		assertTrue(l.getPlayerList().equals(p));
		assertTrue(l.getPowerupList().equals(plist));
	}

	@Test
	public void testCheckCollisionPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckPowerupCollision() {
		fail("Not yet implemented");
	}

	@Test
	public void testDestroyBubble() {
		Bubble bub = new Bubble(8,2,2,true,true);
		l.addBubble(bub);
		l.destroyBubble(0);
		assertTrue(l.getBubbleList().isEmpty());
		
	}
	
	@Test
	public void testDestroyBubbleBig() {
		l.addBubble(bubble);
		l.destroyBubble(0);
		assertEquals(2, l.getBubbleList().size());
	}

	@Test
	public void testGeneratePowerup() {
		Powerup pow = new Powerup("speed", 0, 0);
		Powerup pow2 = l.generatePowerup(0, 0);
		assertTrue(pow.equals(pow2));
	}

	@Test
	public void testResetLevel() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddBubble() {
		assertTrue(l.getBubbleList().isEmpty());
		l.addBubble(bubble);
		assertTrue(l.getBubbleList().contains(bubble));
	}

	@Test
	public void testAddPowerup() {
		assertTrue(l.getPowerupList().isEmpty());
		l.addPowerup(powr);
		assertTrue(l.getPowerupList().contains(powr));
	}

	@Test
	public void testSetRope() {
		Rope r = new Rope(0, 0, false);
		assertNull(l.getRope());
		l.setRope(r);
		assertEquals(r, l.getRope());
	}

}
