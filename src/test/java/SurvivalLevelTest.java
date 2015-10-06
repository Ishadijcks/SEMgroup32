

import static org.junit.Assert.*;
import game.Level;
import game.Player;
import game.Powerup;
import game.SurvivalLevel;
import game.bubble.Bubble;
import game.bubble.Bubblex16;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SurvivalLevelTest {
	
	public SurvivalLevel l;
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
		l = new SurvivalLevel(p);
		bubbleList = new ArrayList<Bubble>();
		plist = new ArrayList<Powerup>();
		powr = new Powerup("speed", 0,0, true);
		rand = new Random();
	}

	@Test
	public void testDestroyBubble() {
		l.addBubble(bubble);
		assertTrue(l.getBubbleList().size() == 1);
		l.destroyBubble(0);
		assertTrue(l.getBubbleList().size() == 2);
	}

	@Test
	public void testGeneratePowerupSpeed() {
		Powerup pow = new Powerup("speed", 0, 0, true);
		int randomInt = rand.nextInt((1 - 1) + 1) + 1;
		Powerup pow2 = l.generatePowerup(0, 0, randomInt);
		assertTrue(pow.equals(pow2));
	}
	
	@Test
	public void testGeneratePowerupIce() {
		Powerup pow = new Powerup("ice", 0, 0, true);
		int randomInt = rand.nextInt((2 - 2) + 1) + 2;
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
	public void testSpawnBubble() {
		l.spawnBubble();
	}

}
