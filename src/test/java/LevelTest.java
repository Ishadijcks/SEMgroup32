
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import game.Level;
import game.NormalLevel;
import game.Player;
import game.Powerup;
import game.Rope;
import game.bubble.Bubble;
import game.bubble.Bubblex16;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class LevelTest {
	
	public Level l;
	public Bubble bubble;
	public Powerup powr;
	public ArrayList<Player> p;
	public ArrayList<Bubble> bubbleList;
	public ArrayList<Powerup> plist;
	public Random rand;
	
	@Before
	public void init() {
		bubble = new Bubblex16(2,2,true,true);
		p = new ArrayList<Player>();
		l = new NormalLevel(p);
		bubbleList = new ArrayList<Bubble>();
		plist = new ArrayList<Powerup>();
		powr = new Powerup("speed", 0,0, true);
		rand = new Random();
	}

	@Test
	public void testLevel() {
		assertTrue(l.getBubbleList().equals(bubbleList));
		assertTrue(l.getPlayerList().equals(p));
		assertTrue(l.getPowerupList().equals(plist));
	}

	@Test
	public void testGeneratePowerupSpeed() {
		Powerup pow = new Powerup("speed", 0, 0, true);
		int randomInt = rand.nextInt((1 - 1) + 1) + 1;
		Powerup pow2 = l.generatePowerup(0, 0, randomInt);
		assertTrue(pow.equals(pow2));
	}
	
	@Test
	public void testGeneratePowerupLife() {
		Powerup pow = new Powerup("life", 0, 0, true);
		int randomInt = rand.nextInt((2 - 2) + 1) + 2;
		Powerup pow2 = l.generatePowerup(0, 0, randomInt);
		assertTrue(pow.equals(pow2));
	}
	
	@Test
	public void testGeneratePowerupIce() {
		Powerup pow = new Powerup("ice", 0, 0, true);
		int randomInt = rand.nextInt((3 - 3) + 1) + 3;
		Powerup pow2 = l.generatePowerup(0, 0, randomInt);
		assertTrue(pow.equals(pow2));
	}
	
	@Test
	public void testGeneratePowerupDefault() {
		Powerup pow = new Powerup("speed", 0, 0, true);
		int randomInt = rand.nextInt((1000000 - 1000) + 1) + 1000;
		Powerup pow2 = l.generatePowerup(0, 0, randomInt);
		assertTrue(pow.equals(pow2));
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
		Rope r = new Rope(0, 0, true);
		assertNull(l.getRope());
		l.setRope(r);
		assertEquals(r, l.getRope());
	}

}
