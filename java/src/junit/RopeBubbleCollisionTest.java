package junit;

import static org.junit.Assert.*;
import game.Bubble;
import game.Level;
import game.Player;
import game.Powerup;
import game.Rope;
import game.Settings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RopeBubbleCollisionTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 20, 68, 2 }, { 29, 68, 2 }, { 38, 68, 2 }, 
                 { 20, 59, 2 }, { 20, 50, 2 }, { 20, 30, 2 },
                 { 24, 59, 2 }, { 35, 29, 2 },
                 { 19, 68, 1 }, { 20, 69, 1 }, { 19, 69, 1 },
                 { 39, 68, 1 }, { 38, 69, 1 }, { 39, 69, 1 },
                 { -10000, 20192, 1 }, { 100000, -129293, 1 }
           });
    }
    
    public Level l;
	public Bubble bubble;
	public ArrayList<Bubble> bubbleList;
	public ArrayList<Player> p;
	private int expected;
	
	public RopeBubbleCollisionTest(int x, int y, int exp) {
		bubble = new Bubble(18,20,50,true,true);
		p = new ArrayList<Player>();
		l = new Level(p);
		bubbleList = new ArrayList<Bubble>();
		Rope r = new Rope(x, y);
		l.setRope(r);
		l.addBubble(bubble);
		this.expected = exp;
	}

	@Test
	public void testCheckCollisionRope() {
		l.checkCollisionRope(true);
		assertEquals(this.expected, l.getBubbleList().size());
	}

}
