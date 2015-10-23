package test.rope;

import static org.junit.Assert.assertEquals;
import game.GameFactory;
import game.NormalDriver;
import game.Player;
import game.Rope;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests if the rope class functions correctly.
 * @author Isha
 *
 */
public class RopeTest {

    public int x;
    public int y;
    private Rope rope;
   
    /**
     * Sets up initial variables used in the tests.
     */
    @Before
    public void init() {
        x = 0;
        y = 0;
        rope = new Rope(x, y);
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
     * Tests if the xCoord was added correctly.
     */
    @Test
    public void testaddX() {
        rope.addX(50);
        int expectedXCoord = 50;
        assertEquals(expectedXCoord, rope.getX());
    }

    /**
     * Tests if the rope moved normally.
     */
    @Test
    public void testMoveNormal() {
        rope = new Rope(250, 100);
        rope.move();
        int expectedYCoord = 96;
        assertEquals(expectedYCoord, rope.getY());
    }

    /**
     * Tests if the rope stops at the roof.
     */
    @Test
    public void testMoveRoofNormal() {
        NormalDriver.game = GameFactory
                .createSinglePlayer(new Player("Test", 0));
        rope = new Rope(250, 0);
        rope.move();
        int expectedYCoord = 0;
        assertEquals(expectedYCoord, rope.getY());
    }

}
