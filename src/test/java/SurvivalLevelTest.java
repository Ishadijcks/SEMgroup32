

import static org.junit.Assert.*;
import game.Level;
import game.Player;
import game.SurvivalLevel;
import game.bubble.Bubble;
import game.bubble.Bubblex16;
import game.powerups.Powerup;
import game.powerups.SpeedPowerup;

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
		bubble = new Bubblex16(2, 2, true, true);
		p = new ArrayList<Player>();
		l = new SurvivalLevel(p);
		bubbleList = new ArrayList<Bubble>();
		plist = new ArrayList<Powerup>();
		powr = new SpeedPowerup(0, 0);
		rand = new Random();
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
