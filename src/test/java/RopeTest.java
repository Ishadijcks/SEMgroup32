
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


public class RopeTest {
    
    public int x;
    public int y;
    Rope rope;
    
    @Before
    public void init() {
        x = 0;
        y = 0;
        rope = new Rope(x, y);
    }
    
    @Test
    public void testgetX() {
        int expectedXCoord = 0;
        assertEquals(expectedXCoord, rope.getX());
    }
    
    @Test
    public void testgetY() {
        int expectedXCoord = 0;
        assertEquals(expectedXCoord, rope.getY());
    }

    @Test
    public void testaddX() {
        rope.addX(50);
        int expectedXCoord = 50;
        assertEquals(expectedXCoord, rope.getX());
    }
    
    @Test
    public void testMoveNormal() {
        rope = new Rope(250, 100);
        rope.move();
        int expectedYCoord = 96;
        assertEquals(expectedYCoord, rope.getY());
    }
    
    @Test
    public void testMoveRopeTop() {
        rope = new Rope(250, 40);
        rope.move();
        //assertEquals(null, rope.move());
    }

}
