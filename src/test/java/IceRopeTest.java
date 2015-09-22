
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import game.IceRope;
import game.Level;
import game.Player;
import game.Powerup;
import game.Rope;
import game.bubble.Bubble;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class IceRopeTest {
    
    public int x;
    public int y;
    Rope rope;
    
    @Before
    public void init() {
        x = 0;
        y = 0;
        rope = new IceRope(x, y);
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
    public void testMoveNormal() {
        rope = new IceRope(250, 100);
        rope.move();
        int expectedYCoord = 96;
        assertEquals(expectedYCoord, rope.getY());
    }
    
    @Test
    public void testMoveRopeTop() {
        rope = new IceRope(250, 48);
        rope.move();
        int expectedYCoord = 48;
        assertEquals(expectedYCoord, rope.getY());
    }

}
