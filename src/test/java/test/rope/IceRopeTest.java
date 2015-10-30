package test.rope;

import static org.junit.Assert.assertEquals;
import game.IceRope;
import game.RopeFactory;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests if the ice rope class functions correctly.
 * 
 * @author Isha
 */

public class IceRopeTest {

    public int x;
    public int y;
    private IceRope rope;

    /**
     * Sets up initial variables used in the tests.
     */
    @Before
    public void init() {
        x = 0;
        y = 0;
        rope = new IceRope(x, y);
    }
    /**
     * Tests if the xCoord was set correctly.
     */
    @Test
    public void testgetX() {
        int expectedXCoord = 0;
        assertEquals(expectedXCoord, rope.getX());
    }
    /**
     * Tests if the yCoord was set correctly.
     */
    @Test
    public void testgetY() {
        int expectedXCoord = 0;
        assertEquals(expectedXCoord, rope.getY());
    }
    /**
     * Tests if the rope moved normally.
     */
    @Test
    public void testMoveNormal() {
        rope = new IceRope(250, 100);
        rope.move();
        int expectedYCoord = 96;
        assertEquals(expectedYCoord, rope.getY());
    }
    /**
     * Tests if the rope stops at the top.
     */
    @Test
    public void testMoveRopeTop() {
        rope = new IceRope(250, 48);
        rope.move();
        int expectedYCoord = 48;
        assertEquals(expectedYCoord, rope.getY());
    }
    
    @Test
    public void testBuildIceRope() {
    	RopeFactory rFac = new RopeFactory();
    	rFac.createRope(true);
    }

}
